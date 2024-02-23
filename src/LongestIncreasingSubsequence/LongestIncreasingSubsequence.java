package LongestIncreasingSubsequence;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] subseqLengths = new int[n];
        int maxLength = 0;
        for (int i = n - 1; i >= 0; i--) {
            int thisMaxLength = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j])
                    thisMaxLength = Math.max(thisMaxLength, 1 + subseqLengths[j]);
            }
            subseqLengths[i] = thisMaxLength;
            maxLength = Math.max(maxLength, subseqLengths[i]);
        }
        return maxLength;
    }
}