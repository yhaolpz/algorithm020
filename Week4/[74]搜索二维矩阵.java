//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：matrix = [], target = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 0 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 287 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        //寻找行
        int left = 0, right = matrix.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2; //下面有 left=mid 语句，所以 mid 要向上取整保证 left!=mid 防止死循环
            if (matrix[mid][0] == target) {
                return true;
            } else if (target > matrix[mid][0]) { //目标区间在 [mid,right]
                left = mid;
            } else { //目标区间在 [left,mid)
                right = mid - 1;
            }
        }
        int n = left; //找到行
        //寻找列
        left = 0;
        right = matrix[n].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[n][mid] == target) {
                return true;
            } else if (target > matrix[n][mid]) { //目标区间在 (mid,right]
                left = mid + 1;
            } else { //目标区间在 [left,mid)
                right = mid - 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
