//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 864 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0; //指向0
        int j = 0; //指向非0
        while (i < nums.length-1 && j < nums.length-1) {
            while (nums[i] != 0 && i < nums.length - 1) {
                i++;
            }
            while (nums[j] == 0 && j < nums.length - 1) {
                j++;
            }
            if (i < j) { //非0在后才需要换
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else{ //否则略过这个非0
                j++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
