import java.util.Stack;

class CheckValidParenthesis {
    /**
     * Reference: https://leetcode.com/problems/valid-parentheses/submissions/
     * **/
    public static void main(String[] args){
        String validParenthesis = "({[]})";
        String invalidParenthesis = "({[]}}";

        Boolean valid = isValid(validParenthesis);
        Boolean invalid = isValid(invalidParenthesis);
        System.out.println(validParenthesis + " : " + valid);
        System.out.println(invalidParenthesis + " : " + invalid);
    }

    public static boolean isValid(String s) {

            char[] str = s.toCharArray();
            if(s.length() == 1){
                return false;
            }
            Stack<Character> stack = new Stack<Character>();
            char closingChar = ' ';
            for(char c: str){
                if(c == ')'){
                    closingChar = '(';
                } else if(c == '}' ){
                    closingChar = '{';
                } else if(c == ']' ){
                    closingChar = '[';
                }

                // add the open parenthesis to the stack
                if(c == '(' || c == '{' || c == '['){

                    stack.push(c);
                } else{
                    if(stack.isEmpty()){
                        return false;
                    }
                    char top = stack.pop();
                    if(top != closingChar){
                        return false;
                    }
                }
            }
            if(!stack.isEmpty()){
                return false;
            }
            return true;
        }
}