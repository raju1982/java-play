package Recursion;

import java.util.Stack;
/**
 * Created by rkandpal on 7/25/17.
 */

//Converting Decimal Numbers to Binary Numbers
//Write a function to convert decimal to hexadecimal.

public class DecimalTOHexaDecimal {

    private static String formatter(int decimalInput) {
        switch (decimalInput) {
            case (10):
                return "A";
            case (11):
                return "B";
            case (12):
                return "C";
            case (13):
                return "D";
            case (14):
                return "E";
            case (15):
                return "F";
            default:
                return Integer.toString(decimalInput);
        }
    }

    public static String converter(int decimalInput, int base){
        StringBuilder sb = new StringBuilder();
        if(decimalInput < base){
            return sb.append(formatter(decimalInput)).toString();
        }
        return converter(decimalInput/base, base) + formatter(decimalInput%base);
    }

    private static Stack<String> outputStack =  new Stack<String>();
    public static String conversionUsingStack(int decimalInput, int base){
        while(decimalInput>base){
            outputStack.push(formatter(decimalInput%base));
            decimalInput = decimalInput/base;
        }
        outputStack.push(formatter(decimalInput));
        String outputString = "";
        while(!outputStack.empty()){
            outputString =  outputString + outputStack.pop();
        }
        return outputString;
    }

    private static Stack<String> recursionStack =  new Stack<String>();
    public static void conversionUsingStackRecursion(int decimalInput, int base){
        if(decimalInput<base){
            recursionStack.push(formatter(decimalInput));
        }
        else {
            recursionStack.push(formatter(decimalInput % base));
            conversionUsingStackRecursion(decimalInput / base, base);
        }
    }

    public static void main(String[] args){
        System.out.println(converter(125, 2));
        System.out.println(converter(125, 16));
        System.out.println(conversionUsingStack(125, 2));
        System.out.println(conversionUsingStack(125, 16));
        conversionUsingStackRecursion(125, 2);
        while(!recursionStack.empty()){
            System.out.print(recursionStack.pop());
        }
    }
}