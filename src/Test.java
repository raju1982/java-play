import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Test {

    //4 = 1* 2* 3* 4
    //factorial

    //fibonacciCount
    //0, 1, 1, 2, 3, 5

    //

    public static Character findFirstDuplicate_impl1(String input){
        input = input.trim();
        if(input.length() < 2) {
            throw new IllegalArgumentException("StringQuiz length is less than 2.");
        }

        char[] inputArray = input.toCharArray();

        for(int i=0; i< inputArray.length; i++){
            for(int j=0; j< inputArray.length; j++){
                if(i == j) {
                    continue;
                }
                //System.out.println(inputArray[i] + " " + inputArray[j]);
                if(inputArray[i] == inputArray[j]){
                    return inputArray[i];
                }
            }
        }
        return null;
    }


    public static Character findFirstDuplicate_impl2(String input){
        input = input.trim();
        if(input.length() < 2) {
            throw new IllegalArgumentException("StringQuiz length is less than 2.");
        }

        char[] inputArray = input.toCharArray();
        Map<Character, Integer> res =  new HashMap<Character, Integer>();

        for(char x : inputArray){

        }

        /*for(int i=0; i< inputArray.length; i++){
            for(int j=0; j< inputArray.length; j++){
                if(i == j) {
                    continue;
                }
                //System.out.println(inputArray[i] + " " + inputArray[j]);
                if(inputArray[i] == inputArray[j]){
                    return inputArray[i];
                }
            }
        }*/
        return null;
    }


    public static Character findFirstUnique_impl2(String input){
        input = input.trim();
        if(input.length() < 2) {
            throw new IllegalArgumentException("StringQuiz length is less than 2.");
        }

        char[] inputArray = input.toCharArray();

        for(int i=0; i< inputArray.length; i++){
            for(int j=0; j< inputArray.length; j++){
                if(i == j || inputArray[i] == inputArray[j]) {
                    continue;
                }
                //System.out.println(inputArray[i] + " " + inputArray[j]);
                return inputArray[i];
            }
        }
        return null;
    }

    public static Map<StringQuiz, List<Integer>> findDuplicatesWithPosition(String input){
        input = input.trim();
        if(input.length() < 2) {
            throw new IllegalArgumentException("StringQuiz length is less than 2.");
        }
        char[] inputArray = input.toCharArray();

        for(int i=0; i< inputArray.length; i++) {
            for (int j = 0; j < inputArray.length; j++) {
                if(i == j) {
                    continue;
                }
                if(inputArray[i] == inputArray[j]){
                    
                }
            }
        }

        return null;
    }


    public static void main(StringQuiz[] args){
        System.out.println(Test.findFirstDuplicate_impl1("rakesh kandpal"));
        System.out.println(Test.findFirstUnique_impl2("rakesh kandpal"));
    }
}


//All duplicate with position
//All unique with position





