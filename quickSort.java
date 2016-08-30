package ds;

import java.util.Arrays;

/*
 * ��������--��������
 */
public class quickSort {
	/*public static void qSort1(int [] a, int low, int high){
	    if(a.length == 0) return ;
	    
		int i = low;
		int j = high;
        //轴ѡa[0]
		int x = a[i];
		if(i >= j ) return;
		while(i < j){
			while(i < j && a[j] > x) j--;
			//     a[j] > x
			if(i < j) a[i++] = a[j]; 
			while(i < j && a[i] < x) i++;
			if(i < j) a[j--] = a[i];
		}
		a[i] = x;
		// i将数据分割两部分，<= x ; > x
		qSort(a, low, i - 1);
		qSort(a, i + 1, high);
	}*/
	
	public int partition(int [] a, int i, int j){
	    int key = a[i];
	    while(i < j){
            while(i < j && a[j] >= key) j--;
            if(i < j) a[i++] = a[j]; 
            
            while(i < j && a[i] <= key) i++;
            if(i < j) a[j--] = a[i];
        }
        a[i] = key;
        return i;
	}
	public void qSort(int [] a, int low, int high){
	    if(a.length == 0) return ;
	    if(low < high){
	        int middle = partition(a, low, high);
	        System.out.println("index：" + middle);
            System.out.println(Arrays.toString(a));
	        qSort(a, middle, middle - 1);
	        qSort(a, middle + 1, high);
	    }
	}
	public static void show(int [] a){
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
	    int a [] = {1, 2, 2, 3,2, 2, 2, 5, 4, 2};
		//qSort1(a, 0, a.length - 1 );
		//show(a);
		quickSort sort = new quickSort();
		sort.qSort(a, 0 , a.length - 1);
		show(a);
	}
}
