//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。 
//
// 请找出其中最小的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 中的所有整数都是 唯一 的 
// nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转 
// 
// Related Topics 数组 二分查找 
// 👍 310 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2; //向下取整保证 mid < right
            if (nums[mid] < nums[right]) { //后半部分递增，目标在 [left,mid]
                right = mid;
            } else if (nums[mid] > nums[right]) { //后半部分无序，目标在 (mid,right]
                left = mid + 1;
            }else{
                //不会出现 nums[mid] == nums[right] 的情况，因为 mid<right，且无重复元素
            }
        }
        return nums[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
