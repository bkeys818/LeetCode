package MaximumElementAfterDecreasingAndRearranging;

import java.util.Arrays;
import java.util.Set;

public class MaximumElementAfterDecreasingAndRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int result = 1;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] >= result + 1) result++;
        return result;
    }
}

// [2,4,6,7]
// [