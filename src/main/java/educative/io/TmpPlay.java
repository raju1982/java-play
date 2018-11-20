package educative.io;

import java.util.HashSet;
import java.util.Set;

public class TmpPlay {

    public static String removeDuplicate(String inputString){
        if(inputString == null || inputString.trim().length() == 0){
            throw new IllegalArgumentException("invalid value");
        }

        Set<Character> charSet = new HashSet<Character>();
        char[] inputChar = inputString.toCharArray();
        StringBuffer strBuffer = new StringBuffer();
        for(char x : inputChar){
            if(!charSet.contains(x)){
                charSet.add(x);
                strBuffer.append(x);
            }
        }
        return strBuffer.toString();
    }

    public static String removeDuplicateTwo(String inputString){
        inputString = inputString.toLowerCase().replaceAll("\\s","").trim();
        if(inputString == null || inputString.length() == 0){
            throw new IllegalArgumentException("invalid value");
        }
        Set<Character> charSet = new HashSet<Character>();
        char[] inputChar = inputString.toCharArray();
        int readPointer = 0;
        int writePointer = 0;
        while(readPointer < inputString.length()){
            if(!charSet.contains(inputChar[readPointer])){
                charSet.add(inputChar[readPointer]);
                inputChar[writePointer] = inputChar[readPointer];
                writePointer++;
            }
            readPointer++;
        }
        return new String(inputChar).substring(0,writePointer);
    }

    public static String removeWhiteSpace(String inputString){
        inputString = inputString.toLowerCase().trim();
        if(inputString == null || inputString.length() == 0){
            throw new IllegalArgumentException("invalid value");
        }
        //Set<Character> charSet = new HashSet<Character>();
        char[] inputChar = inputString.toCharArray();
        int readPointer = 0;
        int writePointer = 0;
        while(readPointer < inputString.length()){
            if(inputChar[readPointer] != ' '){
                inputChar[writePointer] = inputChar[readPointer];
                writePointer++;
            }
            readPointer++;
        }
        return new String(inputChar).substring(0,writePointer);
    }

    public static void main(String[] args){
        System.out.println(removeDuplicate("rakesh kandpal"));
        System.out.println(removeDuplicateTwo("rakesh kandpal meri  uio             kl"));
        System.out.println(removeWhiteSpace("rakesh kandpal"));
    }
}
