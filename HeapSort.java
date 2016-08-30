package ds;

import java.util.Arrays;

/**
 * 无论大小根堆，最小（最大）的值肯定在根元素也即数组中0的位置
 * 最大根堆（最小）的时间复杂度logN，调整n/2;建立二叉堆的时间复杂度的上界O(N*logN);
 * 但是可以证明得最紧的上界是o(N);
 * 求得一个最大/最小值后的 调整的时间复杂度为 O(logN);
 * @author fqx
 *
 */
public class HeapSort {
    //big heap
	/*
	 * s,m is the key wait to sort;  array[s]--array[m]
	 * start from the last non terminate node array[s];
	 */
	public static void adjust(int [] array, int s, int m){
		//save array[s] to variable   rc;
		int rc = array[s];
		//for (int i = 2 * s + 1; i < m; i = i * 2 + 1) {
		int i = 2 * s + 1;
		while(i <= m){
			//step 1:find ith node's child nodes, choose the max,
			if ( i < m && array[i] < array[i + 1]) i++;
			// step2:the max compare with the ith node,
			if (rc >= array[i]){
				break;
			}
			// step3:finally then change the position.
			array[s] = array[i];
			s = i;
			i = 2 * s + 1;
		}
		array[s] = rc;
		show(array);
	}
	
    public void sortHeap(int [] array){
    	for (int i = (array.length - 1) / 2; i >= 0; --i) {
			adjust(array, i, array.length - 1);
		}
    }
	
    public static void show(int [] array){
    	for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
    	System.out.println();
    }
    
	public static void main(String[] args) {
		int [] key = {49, 38, 65, 97, 76, 13, 27, 50};
		show(key);
		new HeapSort().sortHeap(key);
		System.out.println(Arrays.toString(key));
		
		System.out.println(Math.ceil(7/2.0));
	}
}
