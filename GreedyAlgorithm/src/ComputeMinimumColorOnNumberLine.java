public class ComputeMinimumColorOnNumberLine {

    static class Bar{
        int leftBound, rightBound;
        int colorCode = 0;
        public String toString(){
            return "["+leftBound + " " + " " + rightBound +"] : ";
        }
    }

    public static int compute(Bar[] unOrder){

        return -1;
    }
    public static void main(String[] args){
        int[] left = new     int[]{0,1,2,3,4,7,9,10,11,14,15,16,17,18,21,22};
        int[] right = new int[]{6,5,9,6,13,13,14,12,15,19,21,23,21,22,23,24};
        Bar[] unOrder = new Bar[left.length];
        for(int i= 0; i< unOrder.length; i++){
            unOrder[i] = new Bar();
            unOrder[i].leftBound = left[i];

            unOrder[i].rightBound = right[i];
            System.out.print(unOrder[i].toString());
        }

    }
}
