import java.util.Arrays;

class KthLargest {

    private int[] nums;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.nums = nums.length > 0 ? mergeSort(nums, 0, nums.length - 1) : nums;
        this.k = k;
    }

    public int add(int val) {
        int [] updated = new int[nums.length + 1];
        int i = findInsertionIndex(val);
        for (int j = 0; j < i; j++) {
            updated[j] = nums[j];
        }
        updated[i] = val;
        for (int j = i; j < nums.length; j++) {
            updated[j + 1] = nums[j];
        }
        nums = updated;
        return nums[k-1];
    }

    private int findInsertionIndex(int val) {
        int low = 0, high = nums.length;
        while (low < high) {
            var mid = (low + high) / 2;
            if (nums[mid] > val) low = mid + 1;
            else high = mid;
        }
        return low;
    }


    private int[] mergeSort(int[] arr, int min, int max) {
        if (min == max) {
            return new int[] { arr[min] };
        }
        int mid = (max + min) / 2;
        int[] left = mergeSort(arr, min, mid);
        int[] right = mergeSort(arr, mid + 1, max);
        return mergeSortedArrays(left, right);
    }
    private int[] mergeSortedArrays(int[] a, int[] b) {
        int[] sorted = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while(j < a.length && k < b.length) {
            if (a[j] > b[k]) {
                sorted[i++] = a[j++];
            } else {
                sorted[i++] = b[k++];
            }
        }
        while(j < a.length) {
            sorted[i++] = a[j++];
        }
        while(k < b.length) {
            sorted[i++] = b[k++];
        }
        return sorted;
    }

    public static void main(String[] args) {
//      [[2,[0]],[-1],[1],[-2],[-4],[3]]
        KthLargest test = new KthLargest(2, new int[] { 0 });
        System.out.println(Arrays.toString(test.nums));
        System.out.println(test.add(-1)); // -1
        System.out.println(test.add(1)); // 0
        System.out.println(test.add(-2)); // 0
        System.out.println(test.add(-4)); // 0
        System.out.println(test.add(3)); // 1
    }
}
