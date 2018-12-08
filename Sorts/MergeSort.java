/**
 * 归并排序
 *
 * Author: hxl
 */

public class MergeSort{
	 // 归并排序算法, a是数组，n表示数组大小
	public static void mergeSort(int []a,int n){
		mergeSortDivide(a,0,n-1);
	}
	//分解
	public static void mergeSortDivide(int []a,int p,int r){
		if(p>=r)
			return ;
		// 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
		int q=p+((r-p)>>1);
	  // 分治递归
		mergeSortDivide(a,p,q);
		mergeSortDivide(a,q+1,r);
		// 将A[p...q]和A[q+1...r]合并为A[p...r]
		merge(a,p,q,r);
	}
	//合并
	public static void merge(int []a,int p,int q,int r){
		int []temp=new int[r-p+1]; // 申请一个大小跟a[p...r]一样的临时数组
		
		int i=p;
		int j=q+1;
		int k=0;  // 初始化变量i, j, k
		
		while(i<=q&&j<=r){
			if(a[i]<=a[j]){
				temp[k++]=a[i++];
			}
			else{
				temp[k++]=a[j++];
			}
		}
		
		while(i<=q){
			temp[k++]=a[i++];
		}
		while(j<=r){
			temp[k++]=a[j++];
		}
		
	/*	// 判断哪个子数组中有剩余的数据
	    int start = i;
	    int end = q;
	    if (j <= r) {
	      start = j;
	      end = r;
	    }

	    // 将剩余的数据拷贝到临时数组temp
	    while (start <= end) {
	      temp[k++] = a[start++];
	    }*/
		
		for(i=p;i<=r;++i){
			a[i]=temp[i-p];
		}
	}
 }
}
