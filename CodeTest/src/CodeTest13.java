import java.util.HashMap;

public class CodeTest13 {
	
    public static String solution(String[] participant, String[] completion) {
        /**
         * 완주하지 못한 선수 
         * (1) 마라톤에 참여한 선수들의 이름이 담긴 배열 participant
         * (2) 완주한 선수들의 이름이 담긴 배열 completion
         * (3) 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
         * (4) 완주하지 못한 선수의 이름을 return 
         * (5) 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하
         * (6) completion의 길이는 participant의 길이보다 1
         * (7) 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자
         * (8) 참가자 중에는 동명이인이 있을 수 있습니다.
         */
    	String answer = "";
    	
    	// 이걸 꼭 둘 다 HashMap으로 만들어줄 필요가 있을까?
//    	HashMap<Integer,String> participantInMap = new HashMap<>();//참여
//    	HashMap<Integer,String> completeInMap = new HashMap<>();//참여및완주
//    	
//    	for(int i=0; i<participant.length; i++) {
//    		participantInMap.put(i+1, participant[i]);
//    	}
//    	
//    	for(int i=0; i<completion.length; i++) {
//    		completeInMap.put(i+1, completion[i]);
//    	}
//    	
//    	for (Integer key : participantInMap.keySet()) {
//    		String value = participantInMap.get(key);
//    	    System.out.println("[key]:" + key + ", [value]:" + value);
//    	    
//    	    //value 중복값 체크
//    	    
//    	    if(!completeInMap.containsValue(value)) {
//    	    	answer = value;
//    	    }//동명이인 체크해줘야함.
//    	} 
    	
        return answer;
    }
	
	public static void main(String[] args) {
		// ["leo", "kiki", "eden"]	["eden", "kiki"] => "leo"
		// ["marina", "josipa", "nikola", "vinko", "filipa"]  ["josipa", "filipa", "marina", "nikola"] => "vinko"
		// ["mislav", "stanko", "mislav", "ana"] ["stanko", "ana", "mislav"] "mislav"
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
				
		String result = solution(participant, completion);
		System.out.println("result :: {} "+result);
	}
}
