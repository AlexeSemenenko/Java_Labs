public class ColOperations<privat> {

    public static void serchEvenElemCol(Integer[][] matrix){
        int counter = 0;
        for(int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] % 2 == 0){
                    counter++;
                }
            }
            if (counter == matrix.length){
                System.out.println("All items in the column " + j + " are even");
            }
            counter = 0;
        }
        System.out.println();
    }

    public static void negativeElemMainDiagonal(Integer[][] matrix){
        int sum = 0;
        int range;
        if(matrix.length <= matrix[0].length){
            range = matrix.length;
        } else{
            range = matrix[0].length;
        }

        for(int i = 0; i < range; i++){
            for(int j = 0; j < range; j++){
                if(i == j) {
                    if (matrix[i][j] < 0) {
                        sum = sumElem(j, matrix);
                        System.out.println("Column " + i +
                                " has negative element on main diagonal and its sum = " + sum);
                        sum = 0;
                    }
                }
            }
        }
    }

    private static int sumElem(int col, Integer[][] matrix){
        int sum = 0;
        for(int j = col; j < col + 1; j++){
            for(int i = 0; i < matrix.length; i++){
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
