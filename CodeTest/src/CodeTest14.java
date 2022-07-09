import java.util.HashMap;

public class CodeTest14 {
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
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        // getOrDefault(Object key, V DefaultValue) key: 값을 가져와야 하는 요소, DefaultValue: 지정된 키로 값이 없는 경우 반환되어야 하는 기본값
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
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
