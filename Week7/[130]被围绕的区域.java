//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 442 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        //并查集关注 O ，将边界上的 O 都联通，剩下的 O 都填 X 即可
        if (board.length == 0) {
            return;
        }
        int rows = board.length, cols = board[0].length;
        int dummyNode = rows * cols;
        UnionFind find = new UnionFind(dummyNode + 1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X') {
                    continue;
                }
                int node = i * cols + j;
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    find.union(dummyNode, node);
                } else {
                    if (i > 0 && board[i - 1][j] == 'O') {
                        find.union((i - 1) * cols + (j), node);
                    }
                    if (i < rows - 1 && board[i + 1][j] == 'O') {
                        find.union((i + 1) * cols + (j), node);
                    }
                    if (j > 0 && board[i][j - 1] == 'O') {
                        find.union((i) * cols + (j - 1), node);
                    }
                    if (j < cols - 1 && board[i][j + 1] == 'O') {
                        find.union((i) * cols + (j + 1), node);
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X' || find.isSameRoot(dummyNode, i * cols + j)) {
                    continue;
                }
                board[i][j] = 'X';
            }
        }
    }

    static class UnionFind {
        int count;
        int[] parent;

        UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void union(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
                count--;
            }
        }

        int findRoot(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        boolean isSameRoot(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            return rootP == rootQ;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
