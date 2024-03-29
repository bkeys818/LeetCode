package SearchInsertPosition;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (end + start) / 2;
            if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid;
        }
        return nums[start] < target ? start + 1 : start;
    }
}