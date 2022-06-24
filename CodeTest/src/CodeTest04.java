import java.util.ArrayList;
import java.util.regex.Pattern;


public class CodeTest04 {

	private static String solution(String new_id) {
		/*
		프로그래머스 - 신규 아이디 추천 
		요구사항
		 -아이디 길이 3자이상 15자 이하
		 -알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용
		 -마침표 처음과 끝 X 연속으로 사용 X
		 -빈 문자열이라면 , 신규 "a" 대입
		 -16자 이상, 처음부터 15개 문자제외한 나머지 문자 제거
		 -길이가 2자 이하라면, 마지막 문자를  길이가 3이 될때까지 반복해서   
		    끝에 붙임
		*/
		
		/**
		 *  1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
			2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
			3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
			4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
			5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
			6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
			     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
			7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
		 * */

		
		//1단계 : 대문자 -> 소문자 
		new_id = new_id.toLowerCase();

		
		//2단계 : new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
		new_id = new_id.replaceAll("[^-_.a-z0-9]", ".");	//[^-_.a-z0-9] => 나타낸거  [^ ~ ] =>NOT을 나타냄 				
		
		//3단계 : new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		new_id = new_id.replaceAll("[.]{2,}", ".");
		
		//4단계 : new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		new_id = new_id.replaceAll("^[.]|[.]$", "");
		
		//5단계 : new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		if(new_id.equals("")) {
			new_id += "a";
		}
		
		//6단계: new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
	    //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0,15);
			new_id = new_id.replaceAll("^[.]|[.]$", "");
		}
		
		//7단계 :  new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
		if(new_id.length() <= 2) {
           while(new_id.length()<3)
        	   new_id+=new_id.charAt(new_id.length()-1);
		}
		
		return new_id;
	}
	
	public static void main(String[] args) {

		String[] input = {"...!@BaT#*..y.abcdefghijklm"
				,"z-+.^."	
				,"=.="	
				,"abcdefghijklmn.p"	
				,"123_.def"	};
		
		for(int i=0; i<input.length; i++) {
			String result = solution(input[i]);
			System.out.println("result :: {} "+result);
		}

	}
}
