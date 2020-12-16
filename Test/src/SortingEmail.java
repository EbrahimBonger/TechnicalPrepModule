public class SortingEmail {
    public static void main(String[] args){
        String[] email = new String[]{"ala@gmail.com","alaba@gmail.com" ,"robert@gmail.com"};
        sortingEmail(email);
        int[] arr = {8, 5, 2, 9, 5, 6, 3};
        selection(arr);
        for(String s: email){
            System.out.println(s);
        }

    }
    public static void comparePairs(String[] email, String aa, String bb, int a, int b){
        //System.out.println(aa + " " + bb + " " + a + " " + b);
        String shorterStr = aa.length() < bb.length()? aa : bb;
        String longerStr = aa.length() < bb.length()? bb : aa;
        for(int i=0; i<shorterStr.length(); i++){

            int shorter_char =  shorterStr.charAt(i);
            int longer_char =  longerStr.charAt(i);
            //System.out.println(longer_char + " i " + shorter_char);
            if(shorter_char == longer_char){
                continue;
            }
            else if(shorter_char == longer_char && i == shorterStr.length()){
                //System.out.println(longerStr + "*");
                swap(email, a, b);
            }
            else if(shorter_char < longer_char){
                //System.out.println(" i ");
                swap(email, a, b);
            }
        }
        //System.out.println("error");
        //return "error";
    }

    public static void swap(String[] email, int a, int b){
        // the arguments are passed by reference not by value
        //System.out.println(email[a] + "***" + email[b]);
        String temp = email[a];
        email[a] = email[b];
        email[b] = temp;
    }

    private static void sortingEmail(String[] email) {
        //System.out.println(email[0] + " " + email[1]);
        for(int i=0; i<email.length; i++){
            String currStr_i = email[i].substring(0, email[i].length()-10);
            //System.out.println(email.length + " " + (i+1) );
            int j = i+1;
            while (j < email.length){
                String currStr_j = email[j].substring(0, email[j].length()-10);
                //System.out.print(currStr_i + " "  + currStr_j);
                //System.out.println(currStr_i + " ## " + currStr_j);
                comparePairs(email, currStr_i, currStr_j, i, j);
                j++;
            }
        }
    }


    public static int[] selection(int[] array){
        int n = array.length;

        for(int i=0; i<n; i++){
            int ptr = i;
            int smallestIdx = i; // points to the smallest value in the unsorted array per iteration
            while(ptr < n){
                if(array[smallestIdx] < array[ptr]){
                    smallestIdx = ptr;
                }
                ptr++;
            }
            //swap(array, i, smallestIdx);
        }
        return array;
    }


}
