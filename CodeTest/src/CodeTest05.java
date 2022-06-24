import java.util.HashMap;

public class CodeTest05 {
	private static int solution(String str) {
		/*
		프로그래머스 - 숫자 문자열과 영단어 
		 : 숫자의 일부 자릴수를 영단어로 바꿈  , 원래 숫자 반납 
		요구사항
		 - 1 <= s <= 50 
		 - zero 혹은 0으로 시작하는 경우는 주어지지 않음.
		 - return 1<=  2,000,000,000 이하의 정수
		*/
		int answer = 0;
		
		HashMap<String,String> tempInMap = new HashMap<String,String>();
		tempInMap.put("zero","0");
		tempInMap.put("one","1");
		tempInMap.put("two","2");
		tempInMap.put("three","3");
		tempInMap.put("four","4");
		tempInMap.put("five","5");
		tempInMap.put("six","6");
		tempInMap.put("seven","7");
		tempInMap.put("eight","8");
		tempInMap.put("nine","9");
		
		System.out.println("str :: {} " + str);
		
		//(1)value => key
		 for (String key : tempInMap.keySet()) {
	            String value = tempInMap.get(key);
	            //System.out.println("Iterating, key: " + key);
	            if(str.contains(key)) {
	            	str = str.replace(key, value);
	            }
	        }
		answer = Integer.parseInt(str); 
		
		return answer;//
	}
	
	public static void main(String[] args) {

		String[] input = {"one4seveneight"
				,"23four5six7"	
				,"2three45sixseven"	
				,"123"
				};
		
		for(int i=0; i<input.length; i++) {
			int result = solution(input[i]);
			System.out.println("result :: {} "+result);
		}

	}
}
