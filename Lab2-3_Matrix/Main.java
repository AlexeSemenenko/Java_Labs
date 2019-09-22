import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int row;
        int col;
        Scanner scn = new Scanner(System.in);

        try {
            System.out.println("Enter the number of rows: ");
            row = scn.nextInt();
            System.out.println("Enter the number of columns: ");
            col = scn.nextInt();
            Integer[][] testMatrix = new Integer[row][col];

            System.out.println("Your matrix: ");
            Matrix.fillMatrix(testMatrix);
            Matrix.showMatrix(testMatrix);
            ColOperations.serchEvenElemCol(testMatrix);
            ColOperations.negativeElemMainDiagonal(testMatrix);
        } catch (Throwable ex) {
            System.out.print("Invalid input!");
        }
    }
}

