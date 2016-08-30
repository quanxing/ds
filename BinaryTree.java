package ds;
import java.util.ArrayList;
import java.util.Date;

/*
 * �������Ҫ��--20160317
 * һ������������������
 * 1��������
 * 2����ν���
 * 3������+������ 
 * 4�������ĸ߶ȣ���ȣ�ÿһ��Ŀ��
 * 
 */


public class BinaryTree {

	private Node root;
	static char ch[];
	static int i = 0;
	static int[] a = { 2, 1, 12, 45, 21, 6, 111 };

	public BinaryTree() {
		root = null;
	}

	private class Node {
		private Node left;
		private Node right;
		private int data;

		/* ���캯�� */
		public Node(int data) {
			this.left = null;
			this.right = null;
			this.data = data;
		}
		public Node(char data){
			this.left = null;
			this.right = null;
			this.data = data;
		}
	}

	/* ������ --����һ���� */
	public Node Create() {
		Node node = null;
		if (i < ch.length - 1) {
			if (ch[i++] == '#') {
			}
			node = new Node(ch[i++] - '0');
			node.left = Create();
			node.right = Create();
		}
		return node;
	}

	/* ����ط�������*/
	public void create(Node node) {

		if (i < ch.length) {
			if (ch[i] == '#') {
				node.left = null;
				i++;
			}
			if (root == null) {
				root = new Node(ch[i] - '0');
				i++;
				node = root;
			}

			node.left = new Node(ch[i] - '0');
			i++;
			create(node.left);
			node.right = new Node(ch[i] - '0');
			i++;
			create(node.right);

		}
	}

	/* ���ķ�ת */
	public void InvertTree(Node node) {
		if (node == null) {
			return;
		} else {
			Node tmp = node.right;
			node.right = node.left;
			node.left = tmp;
			InvertTree(node.left);
			InvertTree(node.right);
		}
	}

	/**
	 * ǰ�����
	 * 
	 * @param node
	 */
	public void preOrder(Node node) {
		if (node != null) {
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	/**
	 * �������
	 * 
	 * @param node
	 */
	public void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}

	/**
	 * �������
	 * 
	 * @param node
	 */
	public void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.data);
		}
	}

	/*�Ⲣ���Ƕ���������-->��������˸ĳ��˶����������� */
	public void BinarySortTree(Node node, int data) {
		if (root == null) {
			root = new Node(data);// �Ƚ�����ڵ㡣
		} else {
			if (data < node.data) {
				if (node.left == null) {
					node.left = new Node(data);
				} else {
					BinarySortTree(node.left, data);
				}
			} else {
				if (node.right == null) {
					node.right = new Node(data);
				} else {
					BinarySortTree(node.right, data);
				}
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.ch = "12#3##45###".toCharArray();
		System.out.println(ch);
		System.out.println("����������");
		/* ����ǵݹ��������������ķ���������Node ���͵� */
		 bt.root = bt.Create();
		 bt.preOrder(bt.root);

		System.out.println("��һ�ֽ����������ķ���");
		/* ������ͼ����һ��û�з���ֵ�ģ��� */
		/*
		 * bt.root = null; bt.create(bt.root); bt.preOrder(bt.root);
		 */

		System.out.println("��������������");
		/* �����ǽ���һ�Ŷ��������� */
		bt.root = null;
		for (int i = 0; i < a.length; i++) {
			bt.BinarySortTree(bt.root, a[i]);
		}
		bt.inOrder(bt.root);


	}
}
