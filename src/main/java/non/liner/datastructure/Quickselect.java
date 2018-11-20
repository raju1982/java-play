package non.liner.datastructure;

//Quickselect is a selection algorithm to find the k-th smallest element in an unordered list.
public class Quickselect {

    public static int search(int[] input, int low, int high, int searchIndex){
        if(low >= high){
            return low;
        }

        int pivotIndex = getPivotIndex(input, low, high);
        if(pivotIndex < searchIndex){
            return search(input, pivotIndex+1, high, searchIndex);
        }
        else{
            return search(input, low, pivotIndex-1, searchIndex);
        }
    }

    private static int getPivotIndex(int[] input, int low, int high){
        int pivot = input[low];
        int h = high;
        int l = low;
        while(l<=h){
            while(input[l]<=pivot && l<h){
                l++;
            }
            while(input[h]>pivot){
                h--;
            }
            if(l<h){
                swap(input, l, h);
            }
        }

        swap(input, low,h);
        return h;
    }

    private static void swap(int[] input, int low, int high){
        int tmp = input[low];
        input[low] = input[high];
        input[high] = tmp;
    }

    public static void main(String[] args){
        int[] input = new int[]{5,79,0,42,13,65,7,40,56,89,2};
        //{0,2,5,7,13,40,42,56,65,79,89}
        //5th smallest = 13'
        //2th smallest = 2
        //8th smallest = 56
        System.out.println(input[search(input, 0, input.length-1, 4)]);
        System.out.println(input[search(input, 0, input.length-1, 1)]);
        System.out.println(input[search(input, 0, input.length-1, 7)]);
    }


}
