
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HotelReservation {

    public static int solution(String[] A) {
        // Your solution goes here.
        System.err.println("Tip: Use System.err.println() to write debug messages on the output tab.");
        return 0;
    }

    public static void main(String[] args) {
        // Read from stdin, solve the problem, and write the answer to stdout.
//        Scanner in = new Scanner(System.in);
//        String raw = in.next();
//        String removedBrackets = raw.substring(1, raw.length() - 1);
//        String[] withQuotes = removedBrackets.split(",");
        String[] A = {"+0A","+9Z","+4F","-9Z","+3G","+4B","-4B","+4B","-4B"};


        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int reservationCount = 0;
        for(String s : A){
            if(!map.containsKey(s) && s.charAt(0) != '-'){
                reservationCount = reservationCount +1;
                map.put(s, 1);
                System.out.print(s + " : ");
            }
        }
        System.out.print("\n" + reservationCount);


//                Arrays.asList(withQuotes).stream()
//                        .map(s -> s.substring(1, s.length() - 1))
//                        .toArray(String[]::new);
        //System.out.print(solution(A));
    }
}
