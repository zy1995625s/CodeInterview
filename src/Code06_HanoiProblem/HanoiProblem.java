package Code06_HanoiProblem;

/**
 * 	如果只剩下最上层的塔需要移动，则有如下处理：
 * 		○ 左到中，Move 1 from left to mid
 * 		○ 中到左，Move 1 from mid to left
 * 		○ 右到中，Move 1 from right to mid
 * 		○ 中到右，Move 1 from mid to right
 * 		○ 左到右，Move 1 from left to mid 与 Move 1 from mid to right
 * 		○ 右到左，Move 1 from right to mid 与 Move 1 from mid to left
 *
 * 	以上过程就是递归的终止条件。也就是递归头。剩下的是多层塔的问题：
 * 	如果剩下N层塔，从最上到最下依次为1~N，有如下判断：
 * 		○ 如果N层塔都在左，希望移动到中，需要以下几步：
 * 			§ 将1~N-1从左到右，这就是N-1规模的“左到右”递归问题。
 * 			§ 将N从左到中
 * 			§ 将1~N-1从右到中，这也是N-1规模的“右到中”递归问题。
 * 		○ N层塔从中到左，右到中，中到右，都与上面的相同。
 * 		○ N层塔从左到右，需要五个步骤
 * 			§ 将1~N-1从左到右，N-1规模的“左到右”递归问题
 * 			§ 将N从左对中
 * 			§ 将1~N-1从右到左，N-1规模的“右到左”递归问题
 * 			§ 将N从中到右
 * 			§ 将1~N-1从左到右，N-1规模的“左到右”递归问题
 * 		○ N层塔从右到左，与上一中情况类似。
 */

public class HanoiProblem {
	public static int hanoiProblem(int num, String left, String mid, String right) {
		if(num < 1) {
			return 0;
		}
		return process(num, left, mid, right, left, right);
	}
	
	public static int process(int num, String left, String mid, String right, String from, String to) {
		if(num == 1) {
			if(from.equals(mid) || to.equals(mid)) {
				System.out.println("Move 1 from " + from + " to " + to);
				return 1;
			} else {
				System.out.println("Move 1 from " + from + " to " + mid);
				System.out.println("Move 1 from " + mid + " to " + to);
				return 2;
			}
		} else {
			if (from.equals(mid) || to.equals(mid)) {
				String another = (from.equals("left") || to.equals("left")) ? right : left;
				int step1 = process(num - 1, left, mid, right, from, another);
				int step2 = 1;
				System.out.println("Move " + num + "from " + from + " to " + to);
				int step3 = process(num - 1, left, mid, right, another, to);
				return step1 + step2 + step3;
			} else {
				int step1 = process(num - 1, left, mid, right, from, to);
				int step2 = 1;
				System.out.println("Move " + num + "from " + from + " to " + mid);
				int step3 = process(num - 1, left, mid, right, to, from);
				int step4 = 1;
				System.out.println("Move " + num + "from " + mid + " to " + to);
				int step5 = process(num - 1, left, mid, right, from, to);
				return step1 + step2 + step3 + step4 + step5;
			}
		}
	}

	public static void main(String[] args){
		int steps = hanoiProblem(2, "left", "mid", "right");
		System.out.println(steps);
	}
}
