import java.util.Arrays;

public class CodeTest15 {
	
	public boolean solution(String[] phone_book) {
        /**
         * 전화번호 목록 
         * (1) 전화번호부에 적힌 전화번호를 담은 배열 phone_book 
         * (2) 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return
         * (3) phone_book의 길이는 1 이상 1,000,000 이하
         * (4) 각 전화번호의 길이는 1 이상 20 이하
         * (5) 같은 전화번호가 중복해서 들어있지 않습니다
         */
		boolean answer = true;	
        Arrays.sort(phone_book);//성능이 훨씬 잘 나오고 같은 배열끼리 중복체크 하기도 쉽다.
        for (int i=0; i<phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {//startWith 첫 문자열이 ~ 
            	answer = false;
                break;
            }
        }
      return answer;
	}
	
	public static void main(String[] args) {
		// "119", "97674223", "1195524421"  => false
		// "123","456","789" => true
		// "12","123","1235","567","88" => false
		String[] phone_book = {"119", "97674223", "1195524421" };
				
		boolean result = solution(phone_book);
		System.out.println("result :: {} "+result);
	}
}
