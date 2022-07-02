
public class CodeTest09 {
	/** dfs
	 * - 시작점부터 다음 분기로 넘어가기 전에 해당 분기를 완벽하게 탐색하고 넘어가는 방법
	 * (1) '재귀함수' 또는 '스택'으로 구현
	 */
	public static int dfs(int[] numbers, int target, int depth, int sum) {
        int matchCount = 0;

        if (depth == numbers.length) {// 0 5 => 해당 사항 없음  // (초기)입력값이 아무것도 없을때를 해당함
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        matchCount += dfs(numbers, target, depth + 1, sum + numbers[depth]);//  numbers, 3, 1, 0+numbers[0] = 1
        matchCount += dfs(numbers, target, depth + 1, sum - numbers[depth]);//  numbers, 3, 2, 1-numbers[0]= 0
        return matchCount;
    }
	
    public static int solution(int[] numbers, int target) {
        /**
         * 타겟 넘버 :: 요구사항 정의
         * 1) 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수
         * 2) 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return
         * 3) 주어지는 숫자의 개수는 2개 이상 20개 이하
         * 4) 각 숫자는 1 이상 50 이하인 자연수
         * 5) 타겟 넘버는 1 이상 1000 이하인 자연수
         */
    	
    	return dfs(numbers, target, 0, 0);
    }
    
	public static void main(String[] args) {
		// [1, 1, 1, 1, 1]	3	=> 5
		// [4, 1, 2, 1]	4	=> 2
		int[] input = {1, 1, 1, 1, 1
				};
		
		int target = 0;
		
		//for(int i=0; i<input.length; i++) {
			int result = solution(input, target);
			System.out.println("result :: {} "+result);
		//}
	}
}
