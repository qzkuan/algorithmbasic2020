package class16;

import java.util.HashSet;
import java.util.Stack;

public class Code02_DFS {

	/**
	 * 图的深度优先遍历
	 * 使用栈和set辅助实现
	 * @param node 出发图节点
	 */
	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		System.out.println(node.value);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}
	
	
	

}
