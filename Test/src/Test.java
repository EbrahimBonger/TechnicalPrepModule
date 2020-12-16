import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Test
{

    public static void main ( String[] args)
    {
       //String s = "I like eating cheese do you like cheese";
       String t = "like cheese";
       //System.out.print(missingWords(s, t));
        String s = "abc";
        findSubstrings(s);
    }

    static void findSubstrings(String s) {

        List<Character> vowels = "aeiou".chars().mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        List<Character> consonants = "bcdfghjklmnpqrstvwxyz".chars()
                .mapToObj(c -> (char) c).collect(Collectors.toList());

        PriorityQueue<String> maxHeap = new PriorityQueue<>();
        PriorityQueue<String> minHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int length = s.length();

        for (int pass = 0; pass < length; pass++) {
            if (!vowels.contains(s.charAt(pass))) {
                continue;
            }
            for (int el = pass + 1; el < length; el++) {
                char current = s.charAt(el);
                if (!consonants.contains(current)) {
                    continue;
                }
                String str = s.substring(pass, el + 1);
                minHeap.add(str);
                maxHeap.add(str);

                while (minHeap.size() > 1) {
                    minHeap.poll();
                }

                while (maxHeap.size() > 1) {
                    maxHeap.poll();
                }
            }
        }
        System.out.println(minHeap.peek());
        System.out.println(maxHeap.peek());
    }





    static List<String> missingWords(String s, String t) {
        String[] new_s = s.split("\\s+");
        String[] new_t = t.split("\\s+");
        ArrayList<String> str = new ArrayList<String>();
        HashMap<String, Integer> visited = new HashMap<String, Integer>();
        int j = 0;
        int i = 0;
        boolean found = false;
        for(i=0; i<new_t.length; i++){


            while(j<new_s.length && found == false){
                if(!visited.containsKey(new_s[j]) && new_s[j].equals(new_t[i])){
                    visited.put(new_s[j], 1);
                    found = true;

                }else{

                    str.add(new_s[j]);
                }
                j++;
            }
            found = false;
        }
        while(j<new_s.length){
            str.add(new_s[j]);
            j++;
        }

        return str;
    }
}