import java.util.LinkedList;
import java.util.Queue;

public class CodeTest18 {
	
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
	
    public static int solution(int[][] maps) {
       /**
        * 게임 맵 최단거리 
        * 1) 게임 맵의 상태 maps가 매개변수
        * 2) 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return
        * 3) 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
        * 4) maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
        * 5) n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
        * 6) maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
		* 7) 처음 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
        * */
    	
    	   int answer = 0;
           
           int[][] visited = new int[maps.length][maps[0].length];
           
           bfs(maps, visited);
           answer = visited[maps.length-1][maps[0].length-1];
           
           if(answer == 0){
               answer = -1;
           }
           
           return answer;
    }	
    
    public static void bfs(int[][] maps, int[][] visited){
    	  int x = 0;
          int y = 0;
          visited[x][y] = 1;
          Queue<int[]> queue = new LinkedList<>();
          queue.add(new int[]{x, y});
          
          while(!queue.isEmpty()){
              int[] current = queue.remove();
              int cX = current[0];
              int cY = current[1];
              
              for(int i = 0; i < 4; i++){
                  int nX = cX + dx[i];
                  int nY = cY + dy[i];
                  
                  if(nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1)
                      continue;
                  
                  if(visited[nX][nY] == 0 && maps[nX][nY] == 1){
                      visited[nX][nY] = visited[cX][cY] + 1;
                      queue.add(new int[]{nX, nY});
                  }
              }
              
          }       
    }
	
	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		solution(maps);
	}
}
