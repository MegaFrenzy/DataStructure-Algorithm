package recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-13 15:29
 */
public class BFS {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(new BFS().ladderLength("hit", "cog", list));
    }
    //LeetCode127. 单词接龙
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        int step = 0;
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            step++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String str0 = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if (visited[j] || !canConvert(str0, wordList.get(j))) {
                        continue;
                    }
                    //拿wordList中第i个与需求做比较，不是str0
                    if (wordList.get(j).equals(endWord)) {
                        return ++step;
                    }
                    visited[j] = true;
                    queue.offer(wordList.get(j));
                }
            }
        }
        return 0;
    }
    private boolean canConvert(String str, String template) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != template.charAt(i)) {
                if (++count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
