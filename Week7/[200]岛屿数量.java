//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 928 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int dummyNode = grid.length * grid[0].length; //0 的集合
        UnionFind unionFind = new UnionFind(dummyNode + 1);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int node = i * grid[0].length + j;
                if (grid[i][j] == '0') {
                    unionFind.union(dummyNode, node);
                } else {
                    if (i > 0 && grid[i - 1][j] == '1') {
                        unionFind.union((i - 1) * grid[0].length + j, node);
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == '1') {
                        unionFind.union((i + 1) * grid[0].length + j, node);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        unionFind.union(i * grid[0].length + j - 1, node);
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
                        unionFind.union(i * grid[0].length + j + 1, node);
                    }
                }
            }
        }
        return unionFind.count - 1;
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
