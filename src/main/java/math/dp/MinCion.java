package math.dp;

/**
 * 尝试dp简单问题：如何用最少的硬币，凑够某个金额 <br>
 * dp理解：http://hawstein.com/posts/dp-novice-to-advanced.html
 * @author bohan.sj
 */
public class MinCion {
	
	private static int[] cions = new int[]{1, 3, 5, 10};
	
	public static int dpEval(int sumValue) {
		if(sumValue <= 0) {
			return 0;
		}
		int[] d = new int[sumValue+1];
		d[0] = 0;
		for(int i=1; i<=sumValue; i++) {
			d[i] = d[i-1] + 1; 
			for(int j=1; j<cions.length; j++) {
				int k = i-cions[j];
				if(k < 0) break;
				int t = d[k] + 1;
				if(t < d[i]) d[i] = t;
			}
		}
		return d[sumValue];
	}
	
	public static void main(String[] args) {
		System.out.println(dpEval(2));
		System.out.println(dpEval(3));
		System.out.println(dpEval(10));
		System.out.println(dpEval(130));
	}
}
