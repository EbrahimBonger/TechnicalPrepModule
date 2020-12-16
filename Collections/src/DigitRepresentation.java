public class DigitRepresentation {
    public static void main(String[] args){
        String s = "zero;two;five;seven;eight;four";
        digitRepresentation(s);
    }

    private static void digitRepresentation(String s) {
        String hold = "";
        String num = "3";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ';'){
                hold+=s.charAt(i);
            }else{
                //String day = 4;
                System.out.println(hold);
                switch (hold) {
                    case "zero":
                        num+="0";
                        break;
                    case "one":
                        num+="1";
                        break;
                    case "two":
                        num+="2";
                        break;
                    case "three":
                        num+="3";
                        break;
                    case "four":
                        num+="4";
                        break;
                    case "five":
                        num+="5";
                        break;
                    case "six":
                        num+="6";
                        break;
                    case "seven":
                        num+="7";
                        break;
                    case "eight":
                        num+="8";
                        break;
                    case "nine":
                        num+="9";
                        break;
                    default:
                }
                hold = "";
            }
        }
        hold = "";
        int i = s.length()-1;
        while(s.charAt(i) != ';'){
            //System.out.println(s.charAt(i));
            hold += s.charAt(i);
            i--;
        }
        hold = reverse(hold);

        switch (hold) {
            case "zero":
                num+="0";
                break;
            case "one":
                num+="1";
                break;
            case "two":
                num+="2";
                break;
            case "three":
                num+="3";
                break;
            case "four":
                num+="4";
                break;
            case "five":
                num+="5";
                break;
            case "six":
                num+="6";
                break;
            case "seven":
                num+="7";
                break;
            case "eight":
                num+="8";
                break;
            case "nine":
                num+="9";
                break;
            default:
        }
        num = num.substring(1, num.length());

        int result = Integer.parseInt(num);
        //result.format("%05d", 0);
        System.out.println(num);
    }
    public static String reverse(String s){
        String t = "";
        for(int i=s.length()-1; i>=0; i--){
            t+=s.charAt(i);
        }

        return t;
    }
}
