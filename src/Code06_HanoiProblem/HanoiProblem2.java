package Code06_HanoiProblem;

import java.util.Stack;

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
