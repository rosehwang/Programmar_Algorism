
public class CodeTest03 {
	  public static int[] solution(int[] lottos, int[] win_nums) {
	        int[] answer = new int[2];

	        int cnt1 = 0;//0의 갯수 체크 
	        int cnt2 = 0;//당첨 갯수 체크 
	        for(int i : lottos) {
	            if(i == 0) {
	                cnt1++;
	                continue;
	            }
	            for(int j : win_nums) {
	                if(i == j) cnt2++;
	            }
	        }


	        answer[0] = getGrade(cnt1+cnt2);
	        answer[1] = getGrade(cnt2);

	        return answer;
	    }

	    public static int getGrade(int n) {
	        switch(n) {
	            case 6 :
	                return 1;
	            case 5 :
	                return 2;
	            case 4 :
	                return 3;
	            case 3 :
	                return 4;
	            case 2 :
	                return 5;
	            default :
	                return 6;
	        }
	    }
	    
		public static void main(String[] args) {
			/*
			 *  [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
				[0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
				[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]
			 */
			
			int[] lottos = {0, 0, 0, 0, 0, 0};
			int[] win_nums = {38, 19, 20, 40, 15, 25};
			
			int[] result = solution(lottos,win_nums);
			System.out.println("result[0] :: {} "+result[0]);
			System.out.println("result[1] :: {} "+result[1]);
		}
}
