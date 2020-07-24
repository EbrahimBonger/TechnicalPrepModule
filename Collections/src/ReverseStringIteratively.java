public class ReverseStringIteratively {
    public static void main(String[] args){
        reverseString("eight");
    }

    public static String reverseString(String str){
        int length = str.length();
        int last = length-1;
        char[] chars = str.toCharArray();
        for(int i=0; i<length/2; i++){
            char c = chars[i];
            chars[i] = chars[last-i];
            chars[last-i] = c;
        }
        System.out.println(chars);
        return str;
    }
}

