import java.util.HashMap;
import java.util.Iterator;

public class CodeTest16 {
	
    public static int solution(String[][] clothes) {
    	/** 위장
    	 * (1) 매일 다른 옷을 조합하여 입어 자신을 위장
    	 * (2) 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 
    	 * (3) clothes의 각 행은 [의상의 이름, 의상의 종류]
    	 * (4) 같은 이름을 가진 의상은 존재하지 않습니다.
    	 * (5) clothes의 모든 원소는 문자열
    	 * (6) 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
    	 * (7) 스파이는 하루에 최소 한 개의 의상은 입습니다.
    	 * 
    	 *  종류	이름
			얼굴	동그란 안경, 검정 선글라스
			상의	파란색 티셔츠
			하의	청바지
			겉옷	긴 코트
    	 * */
        int answer = 1;//0이 아닌 이유는 각 카테고리마다 옷의 개수를 곱해주기 위함.
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){//중복된 값을 체크하는 식 
            String key = clothes[i][1];//의상의 종류
            if(!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        Iterator<Integer> it = map.values().iterator();
        
        //headgear 2
        //eyewear 1
        //예를 들어, 상의와 하의의 조합은 A*B이다.
        //근데 상의만 선택하고 하의는 선택하지 않을 수 있고, 하의만 선택하고 상의는 선택안할 수 있다.
        //때문에 (A+1)*(B+1)의 경우의 수가 나온다. 
        while(it.hasNext()) {
            answer *= it.next().intValue()+1;
        }
        return answer-1;//다 안 입는 경우를 빼준다.        
    }
	
	public static void main(String[] args) {
//		{{"yellow_hat", "headgear"}
//		 , {"blue_sunglasses", "eyewear"}
//		 , {"green_turban", "headgear"}}	=> 5
		
		String[][] clothes = {{"yellow_hat", "headgear"}
							 , {"blue_sunglasses", "eyewear"}
							 , {"green_turban", "headgear"}};
				
		int result = solution(clothes);
		System.out.println("result :: {} "+result);
	}
}
