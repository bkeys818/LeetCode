public class RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k < 1) return;
        int[] temps = new int[k];
        System.arraycopy(nums, nums.length - k, temps, 0, k);
        for (int i = 0; i < nums.length; i++) {
            int j = i % k;
            int temp = temps[j];
            temps[j] = nums[i];
            nums[i] = temp;
        }
    }
}