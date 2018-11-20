package non.liner.datastructure;


import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class Search {

    public static int binarySearch(int[] data, int input){
        if(data == null){
           throw new IllegalArgumentException("invalid input value.");
        }
        int min = 0;
        int max = data.length-1;
        int counter = 0;
        int mid = 0;
        while(min<=max) {
            counter++;
            mid = min + ((max-min)/2);
            System.out.println("min: " + min + " max:" + max + " mid:" + mid + " data[mid]:" + data[mid]);
            if(data[mid] == input){
                return mid;
            }
            if(data[mid]>input){
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        return -1;
    }

    public static int interpolationSearch(int[] data, int input){
        int min = 0;
        int max = data.length-1;
        int mid = 0;
        while(min<=max){
            mid = min + ((max - min)/(data[max] - data[min]))*(input-data[min]);
            System.out.println("min: " + min + " max:" + max + " mid:" + mid + " data[mid]:" + data[mid]);
            if(data[mid] == input){
                return mid;
            }
            if(data[mid]>input){
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        return -1;
    }



    public static void main(String[] args){
        System.out.println(binarySearch(new int[] {2,5,7,12,15,20,23,25,27,29,30}, 15));
        System.out.println(binarySearch(new int[] {2,5,7,12,15,20,23,25,27,29,30}, 23));
        System.out.println(binarySearch(new int[] {2,5,7,12,15,20,23,25,27,29,30}, 22));

        System.out.println(interpolationSearch(new int[] {2,5,7,12,15,20,23,25,27,29,30}, 15));
        System.out.println(interpolationSearch(new int[] {2,5,7,12,15,20,23,25,27,29,30}, 23));
        System.out.println(interpolationSearch(new int[] {2,5,7,12,15,20,23,25,27,29,30}, 22));
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "invalid input value.")
    public void binarySearchTest(){
        binarySearch(null,12);
    }

}
