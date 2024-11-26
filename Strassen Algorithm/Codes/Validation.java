public class Validation {
    public static boolean isValidateDimensions(int rowA, int columnA, int rowB, int columnB) {
        if (rowA < 1 || columnA < 1 || rowB < 1 || columnB < 1)
            return false;
        return columnA == rowB;
    }

    public static int maxDimension(int rowA, int columnA, int columnB) {
        return Math.max(rowA, Math.max(columnA, columnB));
    }

    public static int roundingUpToNextPowerTwo(int x) {
        return (int) Math.pow(2, Math.ceil(Math.log(x) / Math.log(2)));
    }
}
