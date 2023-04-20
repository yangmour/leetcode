//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2249 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange2(int[] nums, int target) {

        int[] res = new int[]{-1, -1};

        if (nums == null || nums.length == 0) return res;


        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                res[0] = mid;
                res[1] = mid;

                left = mid;
                while (left > 0 && target == nums[--left]) {
                    res[0] = left;
                }

                right = mid;
                while (right < nums.length - 1 && target == nums[++right]) {
                    res[0] = right;
                }
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public int search(int[] nums, int target, boolean flag) {
        int left = 0;
        int right = nums.length - 1;
        int res = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid] || flag && target <= nums[mid]) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[]{-1, -1};
        int left = search(nums, target, true);
        int right = search(nums, target, false) - 1;

        if (left <= right && right < nums.length && nums[left] == target && target == nums[right]) {
            res[0] = left;
            res[1] = right;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
