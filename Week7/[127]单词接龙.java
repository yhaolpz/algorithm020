//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 669 👎 0


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) return 0;
        wordSet.remove(beginWord);
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("size=" + size);
            while (size-- > 0) {
                String str = queue.poll();
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char oldChar = chars[i];
                    for (char newChar = 'a'; newChar <= 'z'; newChar++) {
                        if (oldChar == newChar) continue;
                        chars[i] = newChar;
                        String newStr = String.valueOf(chars);
                        if (wordSet.contains(newStr)) {
                            if (newStr.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(newStr)) {
                                queue.offer(newStr);
                                visited.add(newStr);
                            }
                        }
                        chars[i] = oldChar;
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
