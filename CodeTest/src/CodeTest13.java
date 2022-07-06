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
    	
    		   //마라토너명, 중복횟수
    	HashMap<String,Integer> participantInMap = new HashMap<>();
    	HashMap<String,Integer> completionInMap = new HashMap<>();
    	
    	/* 참여한 마라토너별 동명이인 체크 */
    	for(int i=0; i<participant.length; i++) {
    		if(participantInMap.containsKey(participant[i])) {//중복값 체크, 중복 건 수를 +1 해줌 
    			   //key값이 중복인 케이스 => 중복 횟수 늘림 
    			participantInMap.put(participant[i], (participantInMap.get(participant[i])+1));
    		}else {//중복이 아닌 케이스 
    			participantInMap.put(participant[i], 1);
    		}
    	}   	
    	
    	/* 완주한 마라토너별 동명이인 체크 */
    	for(int i=0; i<completion.length; i++) {
    		if(completionInMap.containsKey(completion[i])) {//중복값 체크, 중복 건 수를 +1 해줌 
    			   //key값이 중복인 케이스 => 중복 횟수 늘림 
    			completionInMap.put(completion[i], (completionInMap.get(completion[i])+1));
    		}else {//중복이 아닌 케이스 
    			completionInMap.put(completion[i], 1);
    		}
    	}  
    	
    	
    	for(int i=0; i<participant.length; i++) {
    		if(completionInMap.containsKey(participant[i])) {
    			//마라톤 완주한 사람들 목록 
    			int pCnt = participantInMap.get(participant[i]);//중복횟수 학인 
    			int cCnt = completionInMap.get(participant[i]);//중복횟수 학인 
    			
    			if(pCnt > cCnt) {
    				answer = participant[i];
    			}
    			//동일하면 동명이인 체크 필요 없음. 
    			
    		}else {
    			//마라톤 완주 못한 사람
    			//System.out.println("마라톤 완주 못 한 사람들 목록 :: {} "+participant[i]);
    			answer = participant[i];
    		}
    	}
    	
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
