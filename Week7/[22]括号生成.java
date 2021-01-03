//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1497 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, n, 0, 0, "");
        return ans;
    }

    private void dfs(List<String> ans, int n, int leftCount, int rightCount, String path) {
        if (path.length() == 2 * n) {
            ans.add(path);
            return;
        }
        if (leftCount < n) {
            dfs(ans, n, leftCount + 1, rightCount, path + "(");
        }
        if (rightCount < leftCount) {
            dfs(ans, n, leftCount, rightCount + 1, path + ")");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
