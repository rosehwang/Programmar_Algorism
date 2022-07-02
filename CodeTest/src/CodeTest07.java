import java.util.Arrays;

public class CodeTest07 {
    
	public static boolean solution(String[] phone_book) {
        /**
         * 전화번호 목록 :: 요구사항 정의
         * 1) 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false 그렇지 않으면 true
         * 2) phone_book의 길이는 1 이상 1,000,000 이하
         * 3) 각 전화번호의 길이는 1 이상 20 이하
         */
		boolean answer = true;	
        Arrays.sort(phone_book);
        for (int i=0; i<phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
            	answer = false;
                break;
            }
        }
	
      return answer;
    }
    
	public static void main(String[] args) {
		// "123","456","789" true
		// 
		String[] input = {"12","123","1235","567","88"
				};
		
		//for(int i=0; i<input.length; i++) {
			boolean result = solution(input);
			System.out.println("result :: {} "+result);
		//}

	}
}
