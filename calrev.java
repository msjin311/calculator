package cal;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class calrev {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	
		
		System.out.println("계산하고 싶은 식을 입력해주세요");
		//ex) "5 + 4 * 10 / 2";
		String input = scan.nextLine();
		
		//저장
		ArrayList<String> tokenlist = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(input);
		while(tokenizer.hasMoreTokens()) {
			tokenlist.add(tokenizer.nextToken());
		}
		
		//곱셉, 나눗셈 처리
		int index = 0;
		while (index < tokenlist.size()) {
			String token = tokenlist.get(index);
			if(token.equals("*") || token.equals("/")) {
				int prev = Integer.parseInt(tokenlist.get(index - 1));
				int next = Integer.parseInt(tokenlist.get(index + 1));
				int result = 0;
				if(token.equals("*")) {
					result = prev * next;
				}
				else if(token.equals("/")) {
					result = prev / next;
				}
				
				tokenlist.set(index - 1, Integer.toString(result));
				tokenlist.remove(index);
				tokenlist.remove(index);
				
				index--;
				System.out.println("Minus ||| index : " + index + " | " + tokenlist);
			} else {
                index++;
                System.out.println("Plus ||| index : " + index + " | " + tokenlist);
            }
        }//while end
		System.out.println("=================");
        System.out.println(tokenlist);
        
        //덧셈, 뺄셈 처리
        int result = Integer.parseInt(tokenlist.get(0));
        for (int i = 1; i <tokenlist.size(); i += 2) {
        	String xy = tokenlist.get(i);
        	int su = Integer.parseInt(tokenlist.get(i + 1));
        	
        	if (xy.equals("+")) {
        		result += su;
        	}
        	else if(xy.equals("-")) {
        		result -= su;
        	}
        }
        System.out.println(result);
        
	}//main end
}//class end
