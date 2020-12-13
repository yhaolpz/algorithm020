//给你一个整数数组 nums ，和一个整数 target 。 
//
// 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]
// ）。 
//
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 二分查找 
// 👍 1098 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            if (nums[left] <= nums[mid]) { //前半段递增
                if (nums[left] <= target && target < nums[mid]) { //目标在 [left,mid)
                    right = mid - 1;
                } else { // 目标在(mid,right]
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[right]) { //后半段递增,注意：nums[mid] == nums[right] 其实不会成立，因为 mid 向下取整且无重复元素
                if (nums[mid] < target && target <= nums[right]) { //目标在 (mid,right]
                    left = mid + 1;
                } else { //目标在 [left,mid)
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
