import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CodeTest17 {    
    public int solution(int n, int[][] computers) {
    	/**
    	 * 네트워크 요구사항  
    	 * 1) 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수
    	 * 2) 네트워크의 개수를 return
    	 * 3) 컴퓨터의 개수 n은 1 이상 200 이하인 자연수
    	 * 4) 각 컴퓨터는 0부터 n-1인 정수
    	 * 5) i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1
    	 */
    	
        int answer = 0;
        boolean[] check = new boolean[n]; // n 갯수만큼 boolean 배열을 만들고 모든 요소를 false로 초기화

        for (int i = 0; i < n; i++) {
          if (!check[i]) {
            dfs(computers, i, check);
            answer++;
          }
        }

        return answer;
      }

      boolean[] dfs(int[][] computers, int i, boolean[] check) {
        check[i] = true;

        for (int j = 0; j < computers.length; j++) {
          if (i != j && computers[i][j] == 1 && check[j] == false) {
            check = dfs(computers, j, check);
          }
        }
        return check;
      }

      @Test
      public void 정답() {
        Assert.assertEquals(2, solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        Assert.assertEquals(1, solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
      }

}
