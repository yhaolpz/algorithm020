//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 494 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    private boolean isEnd;
    private Trie[] next;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.next[index] == null) {
                cur.next[index] = new Trie();
            }
            cur = cur.next[index];
        }
        cur.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie != null && trie.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie trie = searchPrefix(prefix);
        return trie != null;
    }

    public Trie searchPrefix(String prefix) {
        Trie cur = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (cur.next[index] == null) {
                return null;
            }
            cur = cur.next[index];
        }
        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
