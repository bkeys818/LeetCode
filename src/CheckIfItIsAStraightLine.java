public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaX = getDiff(coordinates[1], coordinates[0], 0),
                deltaY = getDiff(coordinates[1], coordinates[0], 1);
        for (int i = 2; i < coordinates.length; i++) {
            // (ay1-ay2) / (ax1-ax2) = (by1-by2) / (bx1-bx2)
            //    ΔY1    /    ΔX1    =    ΔY2    /    ΔX2
            // == ΔY1 * ΔX2 = ΔY2 * ΔX1
            if (deltaY * getDiff(coordinates[i], coordinates[0], 0) !=
                    deltaX * getDiff(coordinates[i], coordinates[0], 1)) {
                return false;
            }
        }
        return true;
    }

    public int getDiff(int[] a, int[] b, int pos) {
        return a[pos] - b[pos];
    }
}