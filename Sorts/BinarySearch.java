/**
 * 简单的二分查找
 * 
 * @author hxl
 * 2018-12-18
 */

public class BinarySearch {
	public static int bsearch(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;

   //循环条件
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] == value) {
				return mid;
			} else if (a[mid] < value) {
				low = mid + 1;
			} else if (a[mid] > value) {
				high = mid - 1;
			}
		}
		return -1;
	}
}
