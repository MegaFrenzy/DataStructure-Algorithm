package recursion;


import java.util.*;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-09 12:23
 */


public class Template {
    public static void main(String[] args) {

    }
//    public void recur(int level, int param) {
//        // [TEMPLATE]
//        // terminator
//        if (level > MAX_LEVEL) {
//            // process result
//            return;
//        }
//
//        // process current logic
//        process(level, param);
//
//        // drill down
//        recur( level: level + 1, newParam);
//
//        // restore current status
//
//    }


//    def BFS(graph, start, end):
//    visited = set()
//        queue = []
//        queue.offer([start])
//
//        while queue:
//            node = queue.poll()
//            visited.add(node)
//
//            process(node)
//            nodes = generate_related_nodes(node)
//		      queue.offer(nodes)
//
//       # other processing work
//	     ...

//    DFS递归写法
//    visited = set()
//
//    def dfs(node, visited):
//            if node in visited: # terminator
//    	          # already visited
//    	          return
//
//            visited.add(node)
//
//            # process current node here.
//            ...
//            for next_node in node.children():
//                if next_node not in visited:
//                  dfs(next_node, visited)
//
//    DFS非递归写法
//    def DFS(self, tree):
//
//            if tree.root is None:
//                return []
//
//            visited, stack = [], [tree.root]
//
//            while stack:
//                node = stack.pop()
//                visited.add(node)
//
//                process (node)
//                nodes = generate_related_nodes(node)
//		          stack.push(nodes)
//
//            # other processing work
//	...
}
