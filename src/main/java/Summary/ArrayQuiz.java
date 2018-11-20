package Summary;

public class ArrayQuiz {
    public static void main(String[] args){
        int[][] data = new int[10][5];

        for(int k=0; k<10; k++) {
            for (int i = 0; i < 5; i++) {
                data[k][i] = i+k;
            }
        }

        for(int k=0; k<10; k++) {
            for (int i = 0; i < 5; i++) {
                System.out.print(data[k][i]);
            }
            System.out.println("");
        }
    }
}
