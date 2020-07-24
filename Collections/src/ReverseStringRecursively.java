public class ReverseStringRecursively {
    /**
     * Reference: https://www.youtube.com/watch?v=7DrLYey2eiA&list=PL2veGun5Zfn3FhulE2Z5vlHzSBQJxssYP&index=18` 
     * **/
    public static void main(String[] args){
        String str = "wyo";
        returnS(str);
    }

    public static void returnS(String s){
        if(s.length() > 0){
            returnS(s.substring(1));
            System.out.print(s.substring(0, 1));
        }
    }
}
