import java.util.*;

public class CodeTest02 {
	    public static int[] solution(int[] lottos, int[] win_nums) {
	        int[] answer = new int[2];
	        
	        //민우가 구매한 로또 번호를 담은 배열 lottos
	        //당첨 번호를 담은 배열 win_nums
	        //당첨가능한 최고순위, 최저순위 차례대로 배열 -> return ~
	        int vnLottos = 6;
	        //int[] vsAnswerList = {};
	        ArrayList<Integer> vsAnswerList = new ArrayList<>();
	        
	        // vsAnswerList 1 0 0 31 
	        //[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
	        for(int i=0; i<vnLottos; i++){//민우가 구매한 로또 번호 
	            for(int j=0; j<vnLottos; j++){
	                if(lottos[i] >= 0 && lottos[i] <= 45){
	                	if(win_nums[i] >= 1 && win_nums[i] <= 45){ 
	                        if(lottos[i] != lottos[j] || ((lottos[i] == lottos[j] && lottos[i] == 0))) {//0은 연속 허용		
	                        	if(win_nums[i] != win_nums[j]){//연속 숫자 중복 제거
				                    if(lottos[i] == win_nums[j] || (lottos[i] == 0 && lottos[i] == lottos[j])){//|| lottos[i] == 0 j에 있으니깐 5번씩 *2 = 10
				                    	System.out.println("i = "+i+" ,"+"j ="+j);// i ==2 i ==3 일때 한 번 들어와야 하는데 	
				                    	if(lottos[i] == 0){
					                      vsAnswerList.add(0);   
					                    }else{
					                      vsAnswerList.add(win_nums[j]);
					                      System.out.println("vsAnswerList[i]:: {} "+vsAnswerList);	
					                    } 
				                    }		
	                            }
	                        }
	                    }
	                }	            		            	
	            }
	        }
	            
	      
	        int vnZero = Collections.frequency(vsAnswerList, 0); //0의 갯수 
	        int vnAnswerIncludeZero = vsAnswerList.size(); // 0을 포함한 정답의 갯수 
	        int vnAnswer = vnAnswerIncludeZero - vnZero; //0을 제외한 정답의 갯수 
	        
	        System.out.println("vnAnswerIncludeZero :: {} "+vnAnswerIncludeZero);
	        System.out.println("vnAnswer :: {} "+vnAnswer);
	        System.out.println("vnZero :: {} "+vnZero);
	        
	        int maxNum = vnAnswer + vnZero;//당첨 가능 최고 번호 일치 갯수 
	        int minNum = vnAnswer;//당첨 가능 최저 번호 일치 갯수 	        
	        
	        answer[0] = ranking(maxNum);
	        answer[1] = ranking(minNum);
	        return answer;
	    }
	    
	    private static int ranking(int num) {
	        int rankingNum = 0;
	        
	        switch(num){
	            case 6 :
	            rankingNum = 1;
	            break;    
	            case 5 :
	            rankingNum = 2;
	            break;  
	            case 4 :
	            rankingNum = 3;
	            break; 
	            case 3 :
	            rankingNum = 4;
	            break;  
	            case 2 :
	            rankingNum = 5;
	            break;                  
	            default: 
	            rankingNum = 6;
	            break;    
	        }
	        System.out.println("rankingNum :: {} "+rankingNum);
	        return rankingNum;
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
