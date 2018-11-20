package jobreadyprogrammer.assignment;

public class ArrayPlay {

    public static boolean isAnagram(String a, String b){
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        if(aArray.length != bArray.length){
            return false;
        }
        char[][] repo = new char[aArray.length+1][bArray.length+1];
        for(int i=0; i<aArray.length; i++){
            repo[i+1][0] = aArray[i];
        }
        for(int i=0; i<bArray.length; i++){
            repo[0][i+1] = bArray[i];
        }

        for(int i=1; i<repo.length; i++){
            for(int j=1; j<repo[i].length; j++){
               if(repo[i][0] == repo[0][j]){
                   repo[i][j] = 1;
               }
            }
        }

        for(int i=0; i<repo.length; i++){
            for(int j=0; j<repo[i].length; j++){
                System.out.print(repo[i][j]);
            }
            System.out.print("\n");
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(isAnagram("hello", "olelh"));
        //System.out.println(isAnagram("hello", "olefh"));
    }


}
