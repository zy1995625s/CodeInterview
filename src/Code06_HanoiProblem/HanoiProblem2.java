package Code06_HanoiProblem;

import java.util.Stack;

/**
 * 	这个问题中的汉诺塔问题，不能让任何塔直接从“左”到“右”，也不能直接从“右”直接移动到“左”，一定要经过中间，
 * 	也就是说，实际只有四个最最基本的动作：左到中、中到右、中到左、右到中。
 *
 * 	现在把左、中、右三个地点抽象成三个栈：LS、MS、RS。最初所有的栈都在LS上，那么上面的动作用栈来描述就是：
 * 	    把某一个栈（from）从栈顶弹出，然后压入另一个栈里（to）的栈顶。
 *
 * 	一个动作能发生的先决条件是：不能违反小压大的原则。from栈弹出的元素num如果能压入to栈中，那么num的值一定要小于当前to栈的栈顶。
 *
 * 	这个结论就有一个推论：一个动作不可能连续发生两次。证明如下：
 *
 * 		LS、MS、RS栈中都是单调栈，栈顶到栈底元素递减。
 * 		如果一个动作发生一次，from->to，还要发生第二次的话，from下一个元素，一定大于当前to栈顶的元素。
 * 		所以一个动作不可能同时发生两次。
 *
 * 	为了保证获取到最小移动次数，一个动作发生后，不能发生反转的动作。这样相当于回到从前，白白浪费一步。
 *
 * 	以上两个原则分别叫做：不可连续原则与不可逆转原则，这就导致下一个推论：
 *
 * 		1.游戏的第一个动作一定是L->M
 * 		2.在走出最小步数的过程中的任何时刻，四个动作中只有一个动作同时满足以上两个原则。
 *
 * 	1的证明很明显，因为最开始所有元素都在LS中。
 *
 * 	2.的证明如下：
 * 		由于第一步一定是L->M，所以以后每一步都有前一步。
 * 		如果前一步是L->M，下一步的选择：
 * 			1.不能连续：L->M不可以
 * 			2.不能逆转：M->L不可以
 * 			3.M->R与R->M中只有一个可以
 *
 * 		如果前一步是M->L，下一步的选择：
 * 			1.不能连续：M->L不可以
 * 			2.不能逆转：L->M不可以
 * 			3.M->R与R->M中只有一个可以
 *
 * 		如果前一步是R->M，下一步的选择：
 * 			1.不能连续：R->M不可以
 * 			2.不能逆转：M->R不可以
 * 			3.M->L与L->M中只有一个可以
 *
 * 		如果前一步是M->R，下一步的选择：
 * 			1.不能连续：M->R不可以
 * 			2.不能逆转：R->M不可以
 * 			3.M->L与L->M中只有一个可以
 *
 * 		综上所述，每一步只有一个动作达标，所以按顺序走即可。
 */

public class HanoiProblem2 {
    public enum Action{
        No, MtoL, LtoM, MtoR, RtoM
    }

    public static int hanoiProblem(int nums, String left, String mid, String right){
        Stack<Integer> ls = new Stack<>();
        Stack<Integer> ms = new Stack<>();
        Stack<Integer> rs = new Stack<>();
        ls.push(Integer.MAX_VALUE);
        ms.push(Integer.MAX_VALUE);
        rs.push(Integer.MAX_VALUE);
        for(int i=nums; i>0; i--){
            ls.push(i);
        }
        Action[] record = {Action.No};
        int step = 0;
        while(rs.size() != nums + 1){
            step += fStackTotStack(record, Action.MtoL, Action.LtoM, ls, ms, left, mid);
            step += fStackTotStack(record, Action.LtoM, Action.MtoL, ms, ls, mid, left);
            step += fStackTotStack(record, Action.RtoM, Action.MtoR, ms, rs, mid, right);
            step += fStackTotStack(record, Action.MtoR, Action.RtoM, rs, ms, right, mid);
        }
        return step;
    }

    public static int fStackTotStack(Action[] record, Action preAct, Action nowAct,
                                     Stack<Integer> fStack, Stack<Integer> tStack,
                                     String from, String to){
        if(record[0] != preAct && fStack.peek() < tStack.peek()){
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args){
        int steps = hanoiProblem(2, "left", "mid", "right");
        System.out.println(steps);
    }
}
