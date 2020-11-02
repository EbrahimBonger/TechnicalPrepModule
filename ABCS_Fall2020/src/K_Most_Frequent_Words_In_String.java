import java.util.*;
import java.util.stream.Collectors;
/**
 * Reference: https://www.hackerrank.com/contests/noram-fa20-hashtables/challenges/k-most-frequent-words-in-a-string/submissions
 *            https://leetcode.com/problems/top-k-frequent-words/discuss/913565/Map-Based-Java-Solution
 * **/

public class K_Most_Frequent_Words_In_String
{
    public static List topKFrequent(String[] words, int k, HashMap<String, Integer> resultant) {

        Map<String, Integer> map = new TreeMap<>();

        for(String w: words){
            if(map.containsKey(w)){
                int newK = map.get(w) + 1;
                map.put(w, newK);

            }else{

                map.put(w, 1);
            }
            if(map.get(w) >= k){
                resultant.put(w, map.get(w));
            }
        }

        return resultant.entrySet()
                .stream()
                .sorted((m1, m2) -> m1.getValue() == m2.getValue() ? m1.getKey().compareTo(m2.getKey()) :
                        m2.getValue().compareTo(m1.getValue()))

                .map(m -> m.getKey()).collect(Collectors.toList());
    }

    public static void main ( String[] args)
    {
        List list = new ArrayList();
        String[] s = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 1;
        HashMap<String, Integer> resultant = new HashMap<String, Integer>();
        list = topKFrequent(s, k, resultant);
        for(Object l: list){
            System.out.println(l + " " + resultant.get(l));
        }
    }
}