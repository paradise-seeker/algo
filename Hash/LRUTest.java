/**
 * 基于 散列 + 双向链表 实现LRU
 * 
 * @author hxl 2018-12-22
 */

class LRU {
	private Node head; // 双向链表头结点
	private Node tail; // 双向链表尾节点
	private Node[] nodes; // 散列数组
	private int capacity; // 缓存大小
	private int count; // 计数器

	public LRU(int capacity) {
		this.capacity = capacity;
		this.nodes = new Node[10];
		this.head = new Node(-1);// 带头节点
		this.tail = head;
	}
  // 地址映射函数，确定数据存储地址
	public int hash(int data) {
		return data % 10;
	}
  // 缓存查询
	public void queryCache(int data) {
		int index = hash(data);

		Node hasNode = queryNode(index, data);

		if (hasNode == null) {
			Node node = new Node(data);
			// 缓存已满，删除第一个数据节点
			if (count >= capacity)
				delNode(head.next);
			// 双向链表添加新节点
			addNode(node);
			// 拉链添加新节点
			addNodeHeng(index, node);
			++count;
		} else {
			// 数据在缓存中，移动到双链表尾部，同步散列拉链更新
			delNode(hasNode);
			addNode(hasNode);
			addNodeHeng(index, hasNode);
		}
	}
  // 双向链表添加节点
	public void addNode(Node node) {
		node.next = tail.next;
		if (tail.next != null) {
			tail.next.pre = node;
		}
		tail.next = node;
		node.pre = tail;

		tail = node;
	}
  // 拉链添加结点
	public void addNodeHeng(int index, Node node) {
		if (nodes[index] == null) {
			nodes[index] = node;
			return;
		}
		Node nodeH = nodes[index];

		while (nodeH.hnext != null) {
			nodeH = nodeH.hnext;
		}
		nodeH.hnext = node;
	}
  // 基于散列查询数据节点
	public Node queryNode(int index, int data) {
		if (nodes[index] == null)
			return null;

		Node node = nodes[index];

		while (node != null) {
			if (node.data == data) {
				return node;
			}
			node = node.hnext;
		}
		return null;
	}
  // 删除结点
	public void delNode(Node node) {
		Node preNode = node.pre;

		preNode.next = node.next;
		if (node.next != null)
			node.next.pre = preNode;

		if (node == tail) {
			tail = preNode;
		}

		delNodeHeng(hash(node.data), node);
	}
  // 拉链删除结点
	public void delNodeHeng(int index, Node node) {
		if (node == nodes[index]) {
			nodes[index] = node.hnext;
			return;
		}

		Node node1 = nodes[index];
		while (node1 != null) {
			if (node1.hnext == node) {
				node1.hnext = node.hnext;
				break;
			}
			node1 = node1.hnext;
		}
	}
 // 集中测试赋值
	public void inputData(int... array) {
		for (int i = 0; i < array.length; ++i) {
			queryCache(array[i]);
		}
	}
  // 打印双向链表
	public void print() {
		Node node = head.next;
		while (node != null) {
			System.out.print(node.data + " ");

			node = node.next;
		}
		System.out.println();
	}
  // 打印散列拉链
	public void print1() {
		for (int i = 0; i < 10; ++i) {
			Node node = nodes[i];
			System.out.print("index" + i + "---");
			while (node != null) {
				System.out.print(node.data + " ");
				node = node.hnext;
			}
			System.out.println();
		}
	}
  private class Node {
		private Node pre;// 双向链表前驱结点
		private Node next;// 双向链表后继结点
		private int data;
		private Node hnext;// 散列拉链结点

		public Node(int data) {
			this.data = data;
		}
	}
}

public class LRUTest {
	public static void main(String[] args) {
		LRU lru = new LRU(10);
		lru.inputData(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		lru.print();
		lru.print1();
	}
}
