//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 411 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderCache = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderCache.put(inorder[i], i);
        }
        return build(inorderCache,
                inorder, 0, inorder.length - 1,
                postorder, 0, inorder.length - 1);
    }

    private TreeNode build(Map<Integer, Integer> inorderCache,
                           int[] inorder, int inLeft, inRight,
                           int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postRight]);
        int index = inorderCache.get(postorder[postRight]);
        int leftCount = index - inLeft;
        node.left = build(inorderCache,
                inorder, inLeft, index - 1,
                postorder, postLeft, postLeft + leftCount - 1);
        node.right = build(inorderCache,
                inorder, index + 1, inRight,
                postorder, postLeft + leftCount, postRight - 1);
        return node;
    }


    //中【左、根、右】
    //后【左、右、根】
}
//leetcode submit region end(Prohibit modification and deletion)
