package class10;

import java.util.Stack;

/**
 * 非递归方式遍历二叉树
 */
public class Code03_UnRecursiveTraversalBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int v) {
			value = v;
		}
	}
	/**
	 * ==先序==遍历 非递归方式 使用栈结构
	 * @param head 头结点
	 */
	public static void pre(Node head) {
		System.out.print("pre-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>(); // 弹出顺序：头 左 右
			stack.push(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.value + " ");
				// 先入栈右子树，后被弹出
				if (head.right != null) {
					stack.push(head.right);
				}
				// 后入栈左子树，先被弹出
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}

	/**
	 * 非递归方式==中序==遍历二叉树（栈）
	 * @param cur
	 */
	public static void in(Node cur) {
		System.out.print("in-order: ");
		if (cur != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || cur != null) {
				if (cur != null) { // 依次先把最左元素入栈
					stack.push(cur);
					cur = cur.left;
				} else { // 出栈打印，并把当前结点的右子树入栈
					cur = stack.pop();
					System.out.print(cur.value + " ");
					cur = cur.right;
				}
			}
		}
		System.out.println();
	}

	/**
	 * 非递归方式==后序==遍历二叉树（双栈好理解，类似先序遍历）
	 * @param head
	 */
	public static void pos1(Node head) {
		System.out.print("pos-order: ");
		if (head != null) {
			Stack<Node> s1 = new Stack<Node>(); // s1弹出顺序：头 右 左
			Stack<Node> s2 = new Stack<Node>(); // s2弹出顺序：左 右 头
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop(); // s1弹出顺序：头 右 左
				s2.push(head); // s1栈弹出元素后放进s2栈，最后依次弹出s2实现逆序
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}
			// 左 右 头
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}
		}
		System.out.println();
	}

	public static void pos2(Node h) {
		System.out.print("pos-order: ");
		if (h != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(h);
			Node c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) {
					stack.push(c.left);
				} else if (c.right != null && h != c.right) {
					stack.push(c.right);
				} else {
					System.out.print(stack.pop().value + " ");
					h = c;
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		pre(head);
		System.out.println("========");
		in(head);
		System.out.println("========");
		pos1(head);
		System.out.println("========");
		pos2(head);
		System.out.println("========");
	}

}
