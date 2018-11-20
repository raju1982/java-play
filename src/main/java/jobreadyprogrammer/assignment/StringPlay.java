package jobreadyprogrammer.assignment;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class StringPlay {


    public static List<String> stringPermutaion (String input){
        //null check
        return null;
    }



    /**
     Given a string of odd length, return the middle 3 characters from the string,
     so the string <b>"Monitor"</b> yields <b>"nit"</b>.
     If the string length is less than 3, return the string as is. <br> <br>

     <b>EXPECTATIONS:</b><br>
     middleThree("bunny") <b>---></b> "unn" <br>
     middleThree("peter") <b>---></b> "ete" <br>
     middleThree("Jamaica") <b>---></b>"mai" <br>
     */

    public static String middleThreeLetter(String input){
        if(input == null){
            throw new IllegalArgumentException("invalid input data");
        }
        int length = input.length();
        int middleCharIndex = length/2;
        if(length<3 || length%2 == 0){
            throw new IllegalArgumentException("invalid input data");
        }
        return input.substring(middleCharIndex-1, middleCharIndex+2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "invalid input data")
    public void nullValueTest(){
        middleThreeLetter(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp="invalid input data")
    public void evenStringLengthTest(){
        middleThreeLetter("hell");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp="invalid input data")
    public void minStringLengthTest(){
        middleThreeLetter("he");
    }

    @Test
    public void middleThreeLetterAPITest(){
        assertEquals(middleThreeLetter("Jamaica"),"mai");
    }

    @Test
    public void middleThreeLetterAPITest2(){
        assertEquals(middleThreeLetter("peter"),"ete");
    }

    @Test
    public void minimumAllowedLengthTest(){
        assertEquals(middleThreeLetter("hey"),"eyB");
    }



    /**
    11
     Given a string, return a string where for every char in the original, append another.
     <br>
     <br>

     * <b>EXPECTATIONS:</b><br>
     repeatChar("The")  <b>---></b>"TThhee"<br>
     repeatChar("AAbb")    <b>---></b> "AAAAbbbb" <br>
     repeatChar("Hi-There") <b>---></b> "HHii--TThheerree" <br>
     */

    public static String repeatChar(String str) {
        StringBuilder output = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            char tmp = str.charAt(i);
            output.append(tmp).append(tmp);
        }
        return output.toString();
    }


    /**
     *
     Return a version of the given string, where for every star (*)
     in the string the star and the chars immediately to its left and right are gone.
     So "ab*cd" yields "ad" and "ab**cd" also yields "ad". 	<br>
     <br>

     * <b>EXPECTATIONS:</b><br>
     starKill("cd*zq")  <b>---></b>"cq"<br>
     starKill("ab**cd")    <b>---></b> "ad" <br>
     starKill("wacy*xko") <b>---></b> "wacko" <br>
     */

    public static String starKill(String str) {
        //null check
        int index = str.indexOf("*");
        while (index == 0) {
            str = str.substring(2);
            index = str.indexOf("*");
        }
        if (index == -1) {
            return str;
        }
        String tmp;
        if(str.charAt(index+1) == '*'){
            tmp = str.substring(index+1, str.length());
        }
        else{
            tmp = str.substring(index+2, str.length());
        }
        return str.substring(0, index-1) + starKill(tmp);
    }

    /**
     *
     Given a string, return the length of the longest streak of the same chars in the string.

     <br>
     <br>

     * <b>EXPECTATIONS:</b><br>
     longestStreak("hayyeu") <b>---></b> 2<br>
     longestStreak("XPNzzzddOOOxx")  <b>---></b> 3 <br>
     longestStreak("")  <b>---></b> 0 <br>
     */

    public static int longestStreak(String str) {
        //System.out.println(str);
        int length = str.length();
        if(length <= 1){
            return length;
        }
        int i = 0;
        char tmp = str.charAt(0);
        int longestStreakLength = 1;
        while(i<length-1 && str.charAt(i+1) == tmp){
            longestStreakLength++;
            i=i+1;
        }
        int lonStreak = longestStreak(str.substring(i+1));
        return longestStreakLength > lonStreak ? longestStreakLength : lonStreak;
    }



    /*
    "There are five different types of foundations out of the many category:makeup There are five different types of foundations out of the many There are five different types of category:apparel foundations out of the many" +
                "foundations out of the many There are five different types category:dance five different types of foundations out";
     */
    //print Category
    public static List<String> printCategory(String inputString){

        if(inputString == null){
            throw new IllegalArgumentException("invaid data");
        }

        String keyword = "category:";
        int keywordLength = "category:".length();
        boolean flag = true;
        int index = 0;
        List<String> category = new ArrayList<String>();

        while(flag){
            int categoryIndex = inputString.indexOf(keyword, index);
            if(categoryIndex == -1){
                flag = false;
                break;
            }
            else{
                index = inputString.indexOf(" ", categoryIndex);
                category.add(inputString.substring(categoryIndex+keywordLength, index));
                System.out.println(category);
            }
        }
        return category;
    }

    public static String addDollar(String inputString){
        int length = inputString.length();
        if(inputString == null || inputString.length() <= 1){
            throw new IllegalArgumentException("invalid value");
        }
        if(length == 2) {
            return appendDollar(inputString) + inputString.charAt(1);
        }
        return appendDollar(inputString) + addDollar(inputString.substring(1));
    }

    private static String appendDollar(String inputString){
        return inputString.charAt(0) + "$" ;
    }

    public static void main(String[] args){
        //String test = "hello there yogi";
        //System.out.println(test.indexOf("there"));
        //String task = "There are five different types of foundations out of the many category:makeup There are five different types of foundations out of the many There are five different types of category:apparel foundations out of the many" +
                //"foundations out of the many There are five different types category:dance five different types of foundations out";
        //System.out.println(printCategory(task));
        //System.out.println(addDollar("ab"));
        //System.out.println(addDollar("abc"));
        //System.out.println(addDollar("abcd"));

        //System.out.println(nearestTwentyOne(19, 21));
        //System.out.println(nearestTwentyOne(21, 19));
        //System.out.println(nearestTwentyOne(19, 22));
        //System.out.println(nearestTwentyOne(32, 22));

        //System.out.println(repeatChar("The"));
        //System.out.println(repeatChar("AAbb"));
        //System.out.println(repeatChar("Hi-There"));

        //System.out.println(starKill("cd*zq"));
        //System.out.println(starKill("ab**cd"));
        //System.out.println(starKill("wacy*xko"));
        //System.out.println(starKill("gmsi***qpa"));

        System.out.println(longestStreak("hayyeu"));
        System.out.println(longestStreak("XPNzzzddOOOxx"));
        System.out.println(longestStreak(""));
    }
}