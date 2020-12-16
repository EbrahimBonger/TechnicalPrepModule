import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinMaxStack {
    static class Min_Max_Stack {
        ArrayList<Integer> Stack = new ArrayList<Integer>();
        ArrayList<Map<String, Integer>> minMax = new ArrayList<Map<String, Integer>>();


        public int pop(){
            minMax.remove(minMax.size()-1);
            return Stack.remove(Stack.size()-1);

        }
        public int peek(){
            return Stack.get(Stack.size()-1);

        }
        public void push(int number){
            Map<String, Integer> newMinMax = new HashMap<String, Integer>();
            newMinMax.put("min", number);
            newMinMax.put("max", number);


            if(minMax.size() > 0){
                Map<String, Integer> lastMinMax = new HashMap<String, Integer>(minMax.get(minMax.size()-1));
                newMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
                newMinMax.replace("max", Math.max(lastMinMax.get("max"), number));
            }
            Stack.add(number);
            minMax.add(newMinMax);


        }
        public int getMin(){

            if (minMax.size()>0){
                return minMax.get(minMax.size()-1).get("min");
            }
            return -1;
        }
        public int getMax(){

            if (minMax.size()>0){
                return minMax.get(minMax.size()-1).get("max");
            }
            return -1;
        }
    }
    public static void main(String[] args){
        Min_Max_Stack stack =  new Min_Max_Stack();
        stack.getMin();
    }
}
