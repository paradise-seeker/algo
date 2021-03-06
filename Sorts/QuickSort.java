/**
 * 快速排序
 *
 * Author: hxl
 */

public class QuickSort{
	// 快速排序，a是数组，n表示数组的大小
	public static void quickSort(int []a,int n){
		quickSortDivide(a,0,n-1);
	}
	// 快速排序递归函数，p,r为下标
	public static void quickSortDivide(int []a,int p,int r){
		if(p>=r) return ;
		
		int q=partition(a,p,r); // 获取分区点
		quickSortDivide(a,p,q-1);
		quickSortDivide(a,q+1,r);
	}
	
	public static int partition(int []a,int p,int r){
		int pivot=a[r];
		int i=p;
		
		for(int j=p;j<r;++j){
			if(a[j]<pivot){
		    int tmp = a[i];
		        a[i] = a[j];
		        a[j] = tmp;
		    ++i;
			}
		}
		int temp=a[i];
		a[i]=a[r];
		a[r]=temp;
		
		return i;
	}
}
