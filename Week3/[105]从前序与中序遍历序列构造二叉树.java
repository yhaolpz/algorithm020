//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 782 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderCache = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderCache.put(inorder[i], i);
        }
        return build(inorderCache,
                inorder, 0, inorder.length - 1,
                preorder, 0, inorder.length - 1);
    }

    private TreeNode build(Map<Integer, Integer> inorderCache,
                           int[] inorder, int inLeft, int inRight,
                           int[] preorder, int preLeft, int preRight) {
        if (inLeft > inRight || preLeft > preRight) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preLeft]);
        int index = inorderCache.get(preorder[preLeft]);
        int leftCount = index - inLeft;
        node.left = build(inorderCache,
                inorder, inLeft, index - 1,
                preorder, preLeft + 1, preLeft + leftCount);
        node.right = build(inorderCache,
                inorder, index + 1, inRight,
                preorder, preLeft + leftCount + 1, preRight);
        return node;
    }

    //前：【根、左、右】
    //中：【左、根、右】
}
//leetcode submit region end(Prohibit modification and deletion)
