import java.util.Stack;

/**
 * Created by rkandpal on 7/22/17.
 */

public class StackQuestion {

    public static String decimalToBinaryConverter(int inputNumber){
        StringBuilder result = new StringBuilder("");
        Stack<Integer> binaryNumber = new Stack<Integer>();
        while(inputNumber>0){
            binaryNumber.add(inputNumber%2);
            inputNumber = inputNumber/2;
            //System.out.println("binaryNumber: " + binaryNumber + "\tinputNumber:" + inputNumber);
        }
        while(!binaryNumber.isEmpty()){
            result.append(binaryNumber.pop());
        }
        return result.toString();
    }

    public static String decimalToHexaDecimalConverter(int inputNumber){
        StringBuilder result = new StringBuilder("");
        Stack<Integer> binaryNumber = new Stack<Integer>();
        while(inputNumber>0){
            binaryNumber.add(inputNumber%16);
            inputNumber = inputNumber/16;
            System.out.println("binaryNumber: " + binaryNumber + "\tinputNumber:" + inputNumber);
        }
        while(!binaryNumber.isEmpty()){
            int tmp = binaryNumber.pop();
            if(tmp > 9){
                char[] table =  new char[] {'A','B', 'C', 'D', 'E'};
                result.append(table[tmp-10]);
            }
            else {
                result.append(tmp);
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(decimalToBinaryConverter(678));
        System.out.println(decimalToHexaDecimalConverter(678));
    }

}

