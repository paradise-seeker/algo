/**
 * 基于链表模拟实现LRU缓存
 * 
 * @author hxl
 * 2018-12-01
 */

class SingleLinkedList {
	final static int ACCOUNT = 10; // 缓存大小
	static int occupyed; // 已占用缓存
	static SingleLinkedList head; // 头指针
	static SingleLinkedList tail; // 尾指针

	int data;
	SingleLinkedList next;

	public SingleLinkedList(int data) {
		this.data = data;
	}

	public static boolean isEmpty(SingleLinkedList pNode) {
		return pNode == null ? true : false;
	}

	public static SingleLinkedList queryNode(int data) {
		SingleLinkedList node = head;

		while (node != null) {
			if (node.data == data) {
				return node;
			}
			node = node.next;
		}
		return null;
	}

	public static SingleLinkedList queryNode(SingleLinkedList pNode) {
		return SingleLinkedList.queryNode(pNode.data);
	}

	public static boolean hasNode(int data) {
		return SingleLinkedList.queryNode(data) == null ? false : true;
	}

	public static boolean hasNode(SingleLinkedList pNode) {
		return SingleLinkedList.hasNode(pNode.data);
	}

	public static boolean hasOccupyAll() {
		return occupyed < ACCOUNT ? false : true;
	}

	public static void addNode(SingleLinkedList pNode) {
		if (isEmpty(pNode)) {
			return;
		}
		if (head == null)
			tail = pNode;

		pNode.next = head;
		head = pNode;

		++occupyed;
	}

	public static void delNode(SingleLinkedList pNode) {
		SingleLinkedList node = head;

		while (node != null) {
			if (node.next == pNode) {
				node.next = pNode.next;
				break;
			}
			node = node.next;
		}

		if (pNode == tail) {
			tail = node;
		}
    --occupyed;
	}

	public static void judgeAdd(int data) {
    //判断缓存是否已被占满，占满则删除尾结点
		if (hasOccupyAll()) {
			delNode(tail);
		}
    //添加新结点到头部
		addNode(new SingleLinkedList(data));
	}

	public static void insertHead(SingleLinkedList node) {
		if (node != head) {
			node.next = head;
			head = node;
		}
	}

	// 缓存命中查询
	public static void queryCache(int data) {
		SingleLinkedList node;
    //数据不存在于缓存链表，直接添加
		if (!SingleLinkedList.hasNode(data)) {
			SingleLinkedList.judgeAdd(data);
			return;
		}
    //存在则将数据结点从原位置删除并插入头部
		node = SingleLinkedList.queryNode(data);
		SingleLinkedList.delNode(node);
		SingleLinkedList.insertHead(node);
	}

	// 遍历所有结点
	public static void travelList() {
		SingleLinkedList node = head;

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}

public class LRU {
	public static void main(String[] args) {
		// 1
		SingleLinkedList.queryCache(1);
		// 2,1
		SingleLinkedList.queryCache(2);
		// 3,2,1
		SingleLinkedList.queryCache(3);
		// 2,3,1
		SingleLinkedList.queryCache(2);
	}
}
