package Code06_HanoiProblem;

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
			if(from.equals(mid) || to.equals(mid)) {
				String another = (from.equals("left") || to.equals("left")) ? right : left;
				int step1 = process(num-1, left, mid, right, from, another);
				int step2 = 1;
				System.out.println("Move " + num + "from " + from + " to " + to);
				int step3 = process(num-1, left, mid, right, another, to);
				return step1 + step2 + step3;
			} else {
				int step1 = process(num-1, left, mid, right, from, to);
				int step2 = 1;
				System.out.println("Move " + num + "from " + from + " to " + mid);
				int step3 = process(num-1, left, mid, right, to, from);
				int step4 = 1;
				System.out.println("Move " + num + "from " + mid + " to " + to);
				int step5 = process(num-1, left, mid, right, from, to);
				return step1 + step2 + step3 + step4 + step5;
			}
		}
	}
}
