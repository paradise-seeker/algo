/*
 *   基于数组实现的顺序栈
 *
 */
 
public class ArrayStack {
	private int[] items; // 数组
	private int count; // 栈中元素个数
	private int n; // 栈的大小

  // 初始化数组，申请一个大小为 n 的数组空间
	public ArrayStack(int n) {
		this.items = new int[n];
		this.count = 0;
		this.n = n;
	}
  // 入栈操作
	public boolean push(int item) {
		if (count == n) {
			return false;
		}

		items[count] = item;
		++count;
		return true;
	}
  // 出栈操作
	public int pop() {
		int temp;

		if (count == 0)
			return -1;
		temp = items[count-1];
		--count;
		return temp;
	}
}
