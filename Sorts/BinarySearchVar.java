/**
 * 二分查找变种问题
 * 
 * @author hxl
 * 2018-12-18
 */

public class BinarySearchVar {
	//查找第一个值等于给定值的元素
	public static int bsearchFirst(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
            if (a[mid] < value) {
				low = mid + 1;
			}
            else if (a[mid] > value) {
				high = mid - 1;
			}
            else{
            	if(mid==0||a[mid-1]!=value) 
            		return mid;
            	high=mid-1;
            }
		}
		return -1;
	}
	//查找最后一个值等于给定值的元素
	public static int bsearchLast(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
            if (a[mid] < value) {
				low = mid + 1;
			}
            else if (a[mid] > value) {
				high = mid - 1;
			}
            else{
            	if(mid==n-1||a[mid+1]!=value) 
            		return mid;
            	low=mid+1;
            }
		}
		return -1;
	}
	//查找第一个值大于等于给定值的元素
	public static int bsearch_01(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
				if((mid==0)||(a[mid-1]<value)) 
					return mid;
				high=mid-1;
			}
            else {
				low=mid+1;
			}
        }
		return -1;
	}
	//查找最后一个值小于等于给定值的元素
	public static int bsearch_02(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
            	high=mid-1;
			}
            else {
				if((mid==n-1)||(a[mid+1]>value)) 
					return mid;
				low=mid+1;
			}
        }
		return -1;
	}
}
