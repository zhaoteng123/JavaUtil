package com.test.zt;

/**
 * 排序算法学习
 * @author 赵腾
 *
 */
public class SortTest {
	
	/**
	 *快速插入排序
	 *a[i]为待排序元素，与他之前的元素逐次比较，如果小于前面的元素，
	 *则将前面的元素后移，
	 *因为每次只有一个待排序元素，所以最多只会移动一个位置，
	 *所以可以用temp保存待排序元素即可保证数据不会丢失
	 *升序
	 * @param arr 待排序数组
	 */
	public void insertSort(int[] arr) {
		if(arr!=null&&arr.length>0) {
			for(int i=1;i<arr.length;i++) {
				int j = 0;
				int temp = arr[i];
				for(j=i-1;j>=0;j--){
					if(arr[j]>temp) { 
						arr[j+1] = arr[j];
					}else {
						break; //重点，会影响后面arr[++j]中j的值；
					}
				}
				arr[++j] = temp;
			}
		}
	}
	
	/**
	 * 希尔排序
	 * 先选取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。
	 * 所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；
	 * 然后，取第二个增量d2<d1重复上述的分组和排序，直至所取得增量dt=1（dt<dt-1<o<d2<d1），
	 * 即所有记录放在同一组中进行直接插入排序为止。该方法实质上是一种分组插入方法。
	 * @param arr
	 */
	public void shellSort(int[] arr) {
		if(arr!=null&&arr.length>0) {
			int len = arr.length;
			int d=0;
			int temp ;
			for(d=len/2;d>=1;d=d/2) {
				for(int i=d;i<len;i+=d) {
					temp = arr[i] ;
					int j = 0;
					for(j=i-d;j>=0;j-=d) {
						if(temp<arr[j]) { //不能和arr[i]比较 ，因为后面 交换过数据，会导致arr[i]的值发生改变
							arr[j+d] = arr[j];
						}else {
							break; //重点，会影响后面arr[j+d]后的索引下标的值；
						}
					}
					arr[j+d] = temp;
				}
			}
		}
	}
	
	/**
	 * 堆排序
	 * @param arr
	 */
	public void heapSort(int[] arr) {
		//先将arr调整为大顶堆或小顶对
		
	}
	
	/**
	 * 最牛批的排序算法，高级多线程排序
	 * @param arr
	 */
	public void mostValueSort(int[] arr) {
		if(arr!=null&&arr.length>0) {
			for(int i=0;i<arr.length;i++) {
				final int temp = arr[i];
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(temp);
							System.out.println(temp);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		}
	}
	
	/**
	 * 将数组调整为顶堆（大顶堆或小顶堆）
	 * @param arr 待调整数组
	 */
	public void changeArrayToRootHeap(int[] arr) {
		if(arr!=null&&arr.length>0) {
			int len = arr.length ;
			//计算堆的层数:log2(n) >= level,n为元素个数，再向上取整
			//int level = ((Double)Math.ceil(Math.log(len))).intValue();
			//从最后一个非叶子节点开始调整
			int lastNonLeaf = len/2 - 1; //获取最后一个非叶子节点
			int lChild = 0; //左子节点序号
			int rChild = 0; //右子节点序号
			int temp = 0; //临时存放元素的值
			//先从前往后调整一次
			for(int i=lastNonLeaf;i>=0;i--) {
				lChild = 2*i + 1;
				rChild = 2*i + 1 + 1;
				//和左子节点比较
				if(arr[i]>arr[lChild]) {
					temp = arr[i];
					arr[i] = arr[lChild];
					arr[lChild] = temp;
				}
				//和右子节点比较
				if(arr[i]>arr[rChild]) {
					temp = arr[i];
					arr[i] = arr[rChild];
					arr[rChild] = temp;
				}
			}
			//从后往前调整过，再从前往后调整一遍，根节点无需再调整
			for(int j = 0 + 1;j<=lastNonLeaf;j++) {
				lChild = 2*j + 1 ;
				rChild = 2*j + 1 + 1 ;
				//和左子节点比较
				if(arr[j]>arr[lChild]) {
					temp = arr[j];
					arr[j] = arr[lChild];
					arr[lChild] = temp;
				}
				//和右子节点比较
				if(arr[j]>arr[rChild]) {
					temp = arr[j];
					arr[j] = arr[rChild];
					arr[rChild] = temp;
				}
			}
		}
	}
	
	/**
	 * 冒泡排序
	 * 冒泡排序的基本思想是，通过相邻元素之间的比较和交换，将排序码较小的元素逐渐从底部移向顶部。
	 * 由于整个排序的过程就像水底下的气泡一样逐渐向上冒，因此称为冒泡算法。（貌似从后往前比较更形象）
	 * @param args
	 */
	public void BubbleSort(int[] arr) {
		if(arr!=null&&arr.length>0) {
			int temp = 0;
			for(int j=0;j<arr.length;j++) {
				for(int i = arr.length-1;i>j;i--) {
					if(arr[i]<arr[i-1]) {
						temp = arr[i];
						arr[i] = arr[i-1];
						arr[i-1] = temp;
					}
				}
			}
		}
	}
	
	/**
	 * 快速排序，未写完
	 * 第一步：再待排序的n个记录中任取一个记录，以该记录的排序码为准，将所有记录都分成两组，第一组都小于该数，第二组都大于该数
	 * 第二步：采用相同的方法对左、右两组分别进行排序，直到所有记录都排到相应的位置为止。
	 * @param arr
	 */
	public void fastSort(int[] arr) {
		if(arr!=null&&arr.length>0) {
			int temp = 0;
			int len = arr.length;
			int base = 0;  //取第一个元素为基准元素
			int match = len-1; //match和base之间有一定关系
			//基准元素和最后一个元素比较
			for(int i=0;i<len;i++) {
				if(arr[base] > arr[match]) {
					//交换元素
					temp = arr[base];
					arr[base] = arr[match];
					arr[match] = temp;
					//计算base和match之间的关系
					temp = base;
					base = match;
					match = i+1;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		SortTest sortTest = new SortTest();
		int[] arr1 = {5,2,6,8,4,1,7,9,3,10};
		int[] arr2 = {5,2,6,8,4,1,7,9,3,10,-11};
		int[] arr3 = {5,2,6,8,4,1,7,-9,3,11,10};
		int[] arr4 = {3,-1,2,7,-9,1,8,-5,6};
		int[] arr5 = {3,-1,2,7,-9,1,8,-5,6};
		//快速插入排序
		sortTest.insertSort(arr1);
		for(int i=0;i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		System.out.println("------------------👆快速插入排序");
		//希尔排序
		sortTest.shellSort(arr2); 
		for(int i=0;i<arr2.length;i++) {
			System.out.println(arr2[i]); 
		} 
		System.out.println("------------------👆希尔排序");
		
		//sortTest.mostValueSort(arr3);
		//将数组转换为小顶堆
		sortTest.changeArrayToRootHeap(arr3);
		for(int i=0;i<arr3.length;i++) {
			System.out.println(arr3[i]); 
		} 
		System.out.println("------------------👆将数组转换为小顶堆");
		//冒泡排序
		sortTest.BubbleSort(arr4);
		for (int i = 0; i < arr4.length; i++) {
			System.out.println(arr4[i]); 
		}
		System.out.println("------------------👆冒泡排序");
		
		//快速排序
		sortTest.fastSort(arr5);
		for (int i = 0; i < arr5.length; i++) {
			System.out.println(arr5[i]); 
		}
		System.out.println("------------------👆快速排序");
	}

}
