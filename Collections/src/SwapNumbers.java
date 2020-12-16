import java.util.Stack;

public class SwapNumbers {


    public static void main(String[] args){
        String s = "2Hey3 5There9 4jkbj6 8kjbjkbk7 5knknkn6";
        System.out.println(s);
        swapNumbers(s);
    }

    private static void swapNumbers(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] c = s.toCharArray();
        int hold = 0;
        stack.push(c[hold]);
        for(int i=1; i<s.length(); i++){
            if(c[i] >= '0' && c[i] <= '9' && !stack.empty()){
                char temp = c[i];
                c[i] = stack.pop();
                c[hold] = temp;
                hold = (i+2);
                i = i+3;
                if(hold <s.length()){
                    stack.push(c[hold]);
                }
            }
        }
        s = new String(c);
        System.out.println(s);
    }
}
