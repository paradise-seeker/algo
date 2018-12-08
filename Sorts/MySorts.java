/**
 * 冒泡排序、插入排序、选择排序
 *
 * Author: hxl
 */

class MySorts{
	//冒泡排序，a表示数组，n表示数组大小
	public static void bubbleSort(int []a,int n){
		if(n<=1) return ;
		
		for(int i=0;i<n;++i){
			//提前退出标志位
			boolean flag=true;
			for(int j=0;j<n-i-1;++j){
				if(a[j]>a[j+1]){ //数据交换
			       int temp=a[j];
				   a[j]=a[j+1];
				   a[j+1]=temp;
				   
				   flag=false;//表示有数据交换
				 }
			}
			if(flag) break; //没有数据交换，提前退出
		}
	}
	//插入排序，a表示数组，n表示数组大小
	public static void insertionSort(int[] a, int n) {
		if (n <= 1)  return;
		
		for (int i = 1; i < n; ++i) {
			int value = a[i];
			int j = i - 1;
			//查找插入的位置
			for (; j >= 0; --j) {
				if (a[j] > value) {
					a[j + 1] = a[j];  //数据移动
				} else {
					break;
				}
			}
			a[j + 1] = value;       //插入数据
		}
	}
	// 选择排序，a表示数组，n表示数组大小
	public static void SelectionSort(int []a,int n){
		if(n<=1) return ;
		
		for(int i=0;i<n-1;++i){
			// 查找最小值
			int minIndex=i;
			for(int j=i+1;j<n;++j){
				if(a[minIndex]>a[j]){
					minIndex=j;
				}
			}
			//交换
			int temp=a[i];
			a[i]=a[minIndex];
			a[minIndex]=temp;
			}
	}
}
