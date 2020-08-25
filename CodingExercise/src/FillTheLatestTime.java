import java.util.Scanner;

public class FillTheLatestTime {

    public static String solution(String T) {
        // Your solution goes here.
        int tempMax =  Integer.MAX_VALUE;
        int max = -1;
        T.toCharArray();
        for(int i=0; i<T.length(); i++){
            switch (i){
                case 0:
                    max = 2;
                    break;
                case 1:
                    max = 3;
                    break;
                case 3:
                case 4:
                    max = 9;
                    break;
                default:
                    break;
            }
            if(T.toCharArray()[i] == '?') {
                tempMax = Math.min(tempMax, max);
                char c=(char)(tempMax+'0');
                char[] array = T.toCharArray();
                array[i] = c;
                T = String.valueOf(array);
            }
        }
        return T;
    }

    public static void main(String[] args) {
        // Read from stdin, solve the problem, write answer to stdout.
        //Scanner in = new Scanner(System.in);
        //String T ="2?:?8";
        String T ="??:??";
        System.out.print(T);
        System.out.print("\n" + solution(T));
        //solution(T);
    }
}
