import java.util.Arrays;
import java.util.Comparator;

public class CodeTest08 {
    
	public static String solution(int[] numbers) {
        /**
         * 가장 큰 수 :: 요구사항 정의
         * 1) 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어짐, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return
         * 2) numbers의 길이는 1 이상 100,000 이하
         * 3) numbers의 원소는 0 이상 1,000 이하
         */
		String answer = "";
		
		String[] nums = new String[numbers.length];
		
	    for (int i=0; i<nums.length; i++) 
            nums[i] = numbers[i] + "";// 뒤에 ""를 붙이는 이유는?
	    
	    /* compareTo(String, String)
	     *  - 기준값의 앞자리부터 일치하는 문자열이 포함된 경우 (기준문자열길이 - 비교대상문자열길이) 리턴
	     *  - 기준값의 앞자리부터 일치 X, 일부 일치하는 문자열이 포함된 경우 (아스키 코드값의 차이값) 리턴
	     *  - 기준값과 전혀 다른 경우, (아스키 코드값의 차이값) 리턴
	     */
	    
	    //TODO. 확인 필요 
	    Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
            	System.out.println("o1 :: "+o1+", o2 :: "+o2);
            	System.out.println("(o2 + o1).compareTo(o1 + o2) :: "+(o2 + o1).compareTo(o1 + o2));
                return (o2 + o1).compareTo(o1 + o2);//값 비교해서 내놓음 
            } 
        });

	    String ans = "";
        for (int i=0; i<numbers.length; i++) {
            ans += nums[i];
            System.out.println("ans :: "+ ans);
        }    
		
        return ans.charAt(0) == '0' ? "0" : ans;
    }
    
	public static void main(String[] args) {
		// 3, 30, 34, 5, 9		9534330
		// 6, 10, 2				6210
		int[] input = {6, 10, 2
				};
		
		//for(int i=0; i<input.length; i++) {
			String result = solution(input);
			System.out.println("result :: {} "+result);
		//}
	}

}
