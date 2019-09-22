import java.util.Random;

public class Matrix {

    public static void fillMatrix(Integer[][] matrix){
        Random random = new Random();

        for(int i = 0; i < matrix.length; i++) {
           for (int j = 0; j < matrix[0].length; j++) {
               matrix[i][j] = random.nextInt(100 + 100) - 100;
           }
        }
    }

    public static void showMatrix(Integer[][] matrix){
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("   " + matrix[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
