package jobreadyprogrammer.assignment;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class StackPlay {

    //public static String decimalToBinaryConverter(int inputNumber){
    //25 -> 11001
    //25%2 = 1 , 12%2 = 0 ,

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

    //reverse string using stack
    public static boolean  matchingParentheses(String input){
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        Set<Character> keys = map.keySet();
        Set<Character> closingParentheses = new HashSet<Character>();
        closingParentheses.add('}');
        closingParentheses.add(')');
        closingParentheses.add(']');
        Set<Character> openingParentheses = new HashSet<Character>();
        openingParentheses.add('{');
        openingParentheses.add('(');
        openingParentheses.add('[');
        Stack<Character> repo = new Stack<Character>();
        Character data;

        for(int i=0; i<input.length() ; i++){
            data = input.charAt(i);
            if(openingParentheses.contains(data)){
                repo.push(data);
            }
            else if(closingParentheses.contains(data)){
                if(repo.isEmpty()){
                    return false;
                }
                else{
                    if(repo.pop() != map.get(data)) {
                        return false;
                    }
                }
            }
        }

        if(!repo.isEmpty()){
            return false;
        }
        return true;
    }

    /*
    "{{{{}}"
“{{{{}}})"
“{{{{}}})"
“{{{}}]()"
 “{{{}}}()"
"{{}}([]){}{}{}{}{[[[[]]]]}"
     */


    //reverse string using stack
    public static String reverserString(String input){
        StringBuilder output = new StringBuilder();
        Stack<Character> bank = new Stack<Character>();
        for(int i=0; i<input.length(); i++){
            bank.push(input.charAt(i));
        }
        while(!bank.isEmpty()){
            output.append(bank.pop());
        }
        return output.toString();
    }


    /*
    operation -
    push [max limit exception]
    pop  [empty stack exception]
    peek [empty]
    isempty
    isfull

    Implementation -
    array
    MaxSize - arraySize - [stack overflow exceprion]
    topElementIndex
    constructor(stacksize [arraysize] )

    time and space complexity -
    complexity of various operations is mostly o(1) time and o(n) space

    usage -
    decimalToHexaDecimalConverter

    decimalToBinaryConverter

    reverse string using stack

    Questions :- Match-Parenthesis  //“{{{{}}})"  "{(["   "}])"

    HOLDING THE MEMORY FOR RECURSIVE CALLS IN A PROGRAMMING LANGUAGE

    STACKS CAN BE USED FOR UNDO FUNCTIONALITY IN APPLICATIONS.

    STACKS CAN BE USED FOR BACK FUNCTIONALITY IN BROWSERS
    */

    public static void main(String[] args){
        System.out.println(decimalToBinaryConverter(25));
        System.out.println(reverserString("rakesh"));

        System.out.println(matchingParentheses("{{{{}}"));
        System.out.println(matchingParentheses("{{{{}}})"));
        System.out.println(matchingParentheses("{{{{}}})"));

        System.out.println(matchingParentheses("{{{}}]()"));
        System.out.println(matchingParentheses("{{{}}}()"));
        System.out.println(matchingParentheses("{{}}([]){}{}{}{}{[[[[]]]]}"));
    }


}
