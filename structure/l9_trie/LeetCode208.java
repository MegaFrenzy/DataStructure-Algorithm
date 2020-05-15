package l9_trie;

/**
 * @Description: 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-14 22:18
 */
public class LeetCode208 {

    class Trie {

        private boolean isEnd ;
        private Trie[] next;
        /** Initialize your data structure here. */
        public Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie root = this;
            char[] w = word.toCharArray();
            int idx ;
            for (int i = 0; i < w.length; i++) {
                idx = w[i] - 'a';
                if (root.next[idx] == null) {
                    root.next[idx] = new Trie();
                }
                root = root.next[idx];
            }
            root.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie root = this;
            char[] w = word.toCharArray();
            int idx;
            for (int i = 0; i < w.length; i++) {
                idx = w[i] - 'a';
                if (root.next[idx] == null) {
                    return false;
                }
                root = root.next[idx];
            }
            return root.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie root = this;
            char[] c = prefix.toCharArray();
            int idx;
            for (int i = 0; i < c.length; i++) {
                idx = c[i] - 'a';
                if (root.next[idx] == null) {
                    return false;
                }
                root = root.next[idx];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
