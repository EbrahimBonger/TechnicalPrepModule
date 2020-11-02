import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SEC_Problem {


    public static List<String> matchName(List<String> names, List<String> records){
        ArrayList<String> EIN = new ArrayList<String>();
        HashMap<String, String> map = new HashMap<String, String>();
        List<String> resName = new ArrayList<>();


        for(String l: records){
            map.put(l.substring(0, l.length()-11), l.substring(l.length()-10, l.length()));
        }
        // Basics
        //if(!names.isEmpty()){
            for (int i=0; i<names.size(); i++){

                if( map.containsKey(names.get(i))){
                    EIN.add(map.get(names.get(i)));
                    String x = names.get(i) +";"+ map.get(names.get(i));
                    //System.out.println("X: " + x);
                    map.remove(names.get(i));

                    records.remove(x);
                    //records.remove(names.get(i) +";"+ map.get(names.get(i)));
                    //System.out.println("X: " + x + " y: "+ names.get(i) +";"+ map.get(names.get(i)));


//                    for(String s: records){
//                        if(s.contains(x)){
//                            records.remove(s);
//                        }
//                    }

                    names.remove(i);
                    if(names.isEmpty()){break;}
                    if(records.isEmpty()){break;}


                }
            }
        //}
        // MisSpelling

        checkMisspell(names, records, EIN);

        return EIN;
    }
    public static void checkMisspell(List<String> names, List<String> records, ArrayList<String> EIN){
        for(int i=0; i<names.size(); i++){
            for(int j=0; j<records.size(); j++){
                String rec = records.get(j);
                int len = rec.length();
                //rec = rec.substring(0, len-11);
                String name = names.get(i);

                //System.out.print(rec.substring(0, len-11) +" " + name);
                if(compare(name, rec.substring(0, len-11))){

                    //System.out.println(" " + name);
                    EIN.add(rec.substring(rec.length()-10, rec.length()));
                }
            }
        }
    }
    public static boolean compare(String a, String b){
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        if(ac.length== bc.length && ac[0] == bc[0] && ac[ac.length-1] == bc[bc.length-1]){
            System.out.println(a + " " + b + " :true");
            char aa = ' ';
            char ab = ' ';
            char bb = ' ';
            char ba = ' ';
            for(int i=0; i<ac.length; i++){
                aa = ' ';
                ab = ' ';
                if(ac[i] ==' '){
                   aa = ac[i-1];
                   ab = ac[i+1];
                   break;
                }
            }

            for(int i=0; i<ac.length; i++){

                if(bc[i] ==' '){
                    aa = ac[i-1];
                    ba = ac[i+1];
                    break;
                }

            }
            if(aa == bb && ab == ba){
                System.out.println(a + " " + b + " :true");
                return true;
            }
            //return true;
        }
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        for(char c: bc){
//            map.put(c,1);
//        }
//        int prob = 0;
//        for(char c: ac){
//            if(!map.containsKey(c)){
//                prob++;
//            }
//        }
//         if((!a.contains(b)) && ac.length - prob >= (ac.length)/2){
//            System.out.println(a + " " + b + " :true" + " prob: " + prob);
//            return true;
//        }
        return false;
    }


    public static void main(String[] args){
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> records = new ArrayList<String>();
        names.add("Harfeys SreakHouse");
        records.add("Harveys SteakHouse;12-3456789");
        names.add("abc");
        records.add("abc;12-3456789");
        //names.add("abcde");
        //records.add("abcde;12-3456789");

        // false
        //names.add("abceg");
        //records.add("abcef;12-3456789");
        //String s = "abc;12-3456789";
        //System.out.println(s.substring(s.length()-10, s.length()));
        matchName(names, records);
    }
}
