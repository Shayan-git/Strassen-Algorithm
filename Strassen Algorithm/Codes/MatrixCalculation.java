public class MatrixCalculation {
    public static double[][] addMatrices(double[][] A, double[][] B) {
        int n = A.length;
        double[][] C = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }

    public static double[][] subtractMatrices(double[][] A, double[][] B) {
        int n = A.length;
        double[][] C = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }

    public static void splitMatrix(double[][] A, double[][] B, int iA, int jA) {
        for (int i1 = 0, i2 = iA; i1 < B.length; i1++, i2++)
            for (int j1 = 0, j2 = jA; j1 < B.length; j1++, j2++)
                B[i1][j1] = A[i2][j2];
    }

    public static double[][] mergeMatrices(double[][] C11, double[][] C12, double[][] C21, double[][] C22) {
        int n = C11.length * 2;
        double[][] C = new double[n][n];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                C[i][j] = C11[i][j];
                C[i][j + n / 2] = C12[i][j];
                C[i + n / 2][j] = C21[i][j];
                C[i + n / 2][j + n / 2] = C22[i][j];
            }
        }
        return C;
    }
}
