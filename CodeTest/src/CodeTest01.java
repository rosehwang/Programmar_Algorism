import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class CodeTest01 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, String> vDeclareId = new HashMap<>();//유저별 신고한 ID
        Map<String, Integer> vDeclareCnt = new HashMap<>();//유저별 신고 당한 횟수 
        //신고당한 횟수의 기준 : k 
        
        for(String str : id_list){
        	vDeclareCnt.put(str,0);
            vDeclareId.put(str,"");
        }

        Set<String> set = new HashSet<>(); // 얜 왜 Set으로 한 거지?
        for(String str : report) {
            // report :: 각 이용자가 신고한 이용자의 ID정보
            System.out.println("report :: {}"+str);
            set.add(str);
        }    

        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            StringTokenizer st = new StringTokenizer(it.next()," ");
            //StringTokenizer 이건 뭘까?
            String s1=st.nextToken();
            String s2=st.nextToken();
            vDeclareId.replace(s1,vDeclareId.get(s1)+" "+s2);
            vDeclareCnt.replace(s2,vDeclareCnt.get(s2)+1);
        }

        for(int i=0;i<id_list.length;i++){
            StringTokenizer st = new StringTokenizer(vDeclareId.get(id_list[i])," ");
            while(st.hasMoreTokens())
                if(vDeclareCnt.get(st.nextToken())>=k)
                    answer[i]++;
        }

        return answer;
    }
	
	public static void main(String[] args) {
		// public int[] solution(String[] id_list, String[] report, int k)
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		solution(id_list,report,k);
	}

}
