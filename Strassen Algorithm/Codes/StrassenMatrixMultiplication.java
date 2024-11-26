public class StrassenMatrixMultiplication {
    public static double[][] strassenMultiply(double[][] A, double[][] B) {
        int n = A.length;
        if (n == 1) {
            double[][] C = new double[1][1];
            C[0][0] = A[0][0] * B[0][0];
            return C;
        } else {
            int newSize = n / 2;
            double[][] A11 = new double[newSize][newSize];
            double[][] A12 = new double[newSize][newSize];
            double[][] A21 = new double[newSize][newSize];
            double[][] A22 = new double[newSize][newSize];
            double[][] B11 = new double[newSize][newSize];
            double[][] B12 = new double[newSize][newSize];
            double[][] B21 = new double[newSize][newSize];
            double[][] B22 = new double[newSize][newSize];

            MatrixCalculation.splitMatrix(A, A11, 0, 0);
            MatrixCalculation.splitMatrix(A, A12, 0, newSize);
            MatrixCalculation.splitMatrix(A, A21, newSize, 0);
            MatrixCalculation.splitMatrix(A, A22, newSize, newSize);

            MatrixCalculation.splitMatrix(B, B11, 0, 0);
            MatrixCalculation.splitMatrix(B, B12, 0, newSize);
            MatrixCalculation.splitMatrix(B, B21, newSize, 0);
            MatrixCalculation.splitMatrix(B, B22, newSize, newSize);

            double[][] M1 = strassenMultiply(MatrixCalculation.addMatrices(A11, A22), MatrixCalculation.addMatrices(B11, B22));
            double[][] M2 = strassenMultiply(MatrixCalculation.addMatrices(A21, A22), B11);
            double[][] M3 = strassenMultiply(A11, MatrixCalculation.subtractMatrices(B12, B22));
            double[][] M4 = strassenMultiply(A22, MatrixCalculation.subtractMatrices(B21, B11));
            double[][] M5 = strassenMultiply(MatrixCalculation.addMatrices(A11, A12), B22);
            double[][] M6 = strassenMultiply(MatrixCalculation.subtractMatrices(A21, A11), MatrixCalculation.addMatrices(B11, B12));
            double[][] M7 = strassenMultiply(MatrixCalculation.subtractMatrices(A12, A22), MatrixCalculation.addMatrices(B21, B22));

            double[][] C11 = MatrixCalculation.addMatrices(MatrixCalculation.subtractMatrices(MatrixCalculation.addMatrices(M1, M4), M5), M7);
            double[][] C12 = MatrixCalculation.addMatrices(M3, M5);
            double[][] C21 = MatrixCalculation.addMatrices(M2, M4);
            double[][] C22 = MatrixCalculation.addMatrices(MatrixCalculation.subtractMatrices(MatrixCalculation.addMatrices(M1, M3), M2), M6);

            return MatrixCalculation.mergeMatrices(C11, C12, C21, C22);
        }
    }
}
