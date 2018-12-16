/**
 * 计数排序-考生成绩排序
 * 
 * @author hxl
 */

class CountingSort {
	// 计数排序，a是数组，n是数组大小。假设数组存储的都是非负整数
	public static void countingSort(int[] a, int n) {
		if (n <= 1)
			return;

		int i;
		// 查找数组中数据的范围
		int max = a[0];
		for (i = 1; i < n; ++i) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		int[] c = new int[max + 1];// 申请一个计数数组c，下标大小[0,max]
		// 计算每个元素的个数，放入c中
		for (i = 0; i < n; ++i) {
			++c[a[i]];
		}
		// 依次累加
		for (i = 1; i < max; ++i) {
			c[i] = c[i] + c[i - 1];
		}
		// 临时数组，存储排序后的结果
		int[] temp = new int[n];
		// 计算排序关键步骤,若重头开始取则不是稳定排序算法
		for (i = n - 1; i >= 0; --i) {
			int index = c[a[i]] - 1;
			temp[index] = a[i];
			--c[a[i]];
		}
		// 结果拷贝
		for (i = 0; i < n; ++i) {
			a[i] = temp[i];
		}
	}
}
