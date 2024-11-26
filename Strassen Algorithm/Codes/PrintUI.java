import java.util.Scanner;

public class PrintUI {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printUI() {
        try {
            System.out.println("Dimension A");
            System.out.print("Matrix A row: ");
            int rowA = scanner.nextInt();
            System.out.print("Matrix A column: ");
            int columnA = scanner.nextInt();
            System.out.println("\nDimension B");
            System.out.print("Matrix B row: ");
            int rowB = scanner.nextInt();
            System.out.print("Matrix B column: ");
            int columnB = scanner.nextInt();

            if (Validation.isValidateDimensions(rowA, columnA, rowB, columnB)) {
                double[][] A = new double[rowA][columnA];
                double[][] B = new double[rowB][columnB];

                // Get Elements Of Matrices
                System.out.println();
                for (int i = 0; i < rowA; i++) {
                    for (int j = 0; j < columnA; j++) {
                        System.out.printf("A[%d][%d]: ", (i+1), (j+1));
                        A[i][j] = scanner.nextDouble();
                    }
                }
                System.out.println();
                for (int i = 0; i < rowB; i++) {
                    for (int j = 0; j < columnB; j++) {
                        System.out.printf("B[%d][%d]: ", (i+1), (j+1));
                        B[i][j] = scanner.nextDouble();
                    }
                }

                // Calculate Strassen
                int maxDim = Validation.maxDimension(rowA, columnA, columnB);
                System.out.printf("\nMax Dimension Between %d, %d, %d: %d", rowA, columnA, columnB, maxDim);
                int nextPowerOfTwo = Validation.roundingUpToNextPowerTwo(maxDim);
                System.out.println("\nNext Power Of Two: " + nextPowerOfTwo);

                double[][] C = new double[nextPowerOfTwo][nextPowerOfTwo];
                double[][] D = new double[nextPowerOfTwo][nextPowerOfTwo];
                for (int i = 0; i < rowA; i++)
                    for (int j = 0; j < columnA; j++)
                        C[i][j] = A[i][j];
                for (int i = 0; i < rowB; i++)
                    for (int j = 0; j < columnB; j++)
                        D[i][j] = B[i][j];
                System.out.println("\nA:");
                printMatrix(C, nextPowerOfTwo, nextPowerOfTwo);
                System.out.println("\nB:");
                printMatrix(D, nextPowerOfTwo, nextPowerOfTwo);

                double[][] result = StrassenMatrixMultiplication.strassenMultiply(C, D);
                System.out.println("\nResult:");
                printMatrix(result, nextPowerOfTwo, nextPowerOfTwo);
                System.out.println("\nResult:");
                printMatrix(result, rowA, columnB);
            } else
                throw new Exception();
        } catch (Exception e) {
            System.out.println("\nInvalid!");

            scanner.nextLine();
            System.out.print("Continue?(y/n) ");
            String userInput = scanner.nextLine();
            if (userInput.equals("y"))
                printUI();
        }
    }

    private static void printMatrix(double[][] A, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                System.out.print(A[i][j] + "   ");
            System.out.println();
        }
    }
}
