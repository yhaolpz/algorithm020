//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 注意数组中可能存在重复的元素。 
//
// 示例 1： 
//
// 输入: [1,3,5]
//输出: 1 
//
// 示例 2： 
//
// 输入: [2,2,2,0,1]
//输出: 0 
//
// 说明： 
//
// 
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。 
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 212 👎 0


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
            } else {
                //出现 nums[mid] == nums[right] 的情况，但是 mid<right，所以一定是重复元素
                //由于要找最小的一个数，重复的话直接往前继续走就是了
                right--;
            }
        }
        return nums[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
