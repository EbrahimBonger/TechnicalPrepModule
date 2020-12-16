import java.util.ArrayList;

public class AddingBinary {
    public static void addingBinary(String a, String b){
        ArrayList<Character> resultant = new ArrayList<Character>();
        //adjustingLength(a, b);
        //System.out.print(a+ " : " + b);

        int k = a.length();
        int carrier = '0';
        for(int i=k-1; i>= 0; i--){
            if(a.charAt(i) == '0' && b.charAt(i) == '0'){

                if(carrier == '1'){
                    resultant.add(0,'1');
                    //System.out.println(i + " " + resultant.get(0));
                    carrier = '0';
                }else{
                    resultant.add(0,'0');
                    //System.out.println(i + " 1 " + resultant.get(0));
                }
            }
            else if(a.charAt(i) == '0' && b.charAt(i) == '1' || a.charAt(i) == '1' && b.charAt(i) == '0'){
                if(carrier == '1'){
                    resultant.add(0,'0');
                    //System.out.println(i + " " + resultant.get(0));
                }else{
                    resultant.add(0,'1');
                    //System.out.println(i + " " + resultant.get(0));
                    carrier = '0';
                }
            }
            else if(a.charAt(i) == '1' && b.charAt(i) == '1'){
                if(carrier == '1'){
                    resultant.add(0,'1');
                    //System.out.println(i + " 0 " + resultant.get(0));
                }else{
                    resultant.add(0,'0');
                    //System.out.println(i + " " + resultant.get(0));
                    carrier = '1';
                }
            }
        }
        if(carrier == '1'){resultant.add(0, '1');}

        System.out.println();
        for(Character c: resultant){
            System.out.print(c);
        }
    }
    public static void adjustingLength(String a, String b){
        if(a.length() != b.length()){
            if(a.length() > b.length()){
                char[] c = new char[a.length()];
                int x = a.length()-b.length();
                for(int i=a.length()-1; i>=0; i--){
                    if(x > 0){
                        //System.out.print(x);
                        c[i] = b.charAt((a.length()-1)-x--);
                    }else{
                        c[i] = '0';
                    }
                }
                //System.out.print(b);
            }
        }

    }

    public static void main(String[] args){
        String a = "101101";
        String b = "111011";
        addingBinary(a, b);
    }
}
