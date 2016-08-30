package ds;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BucketSort {

    /**
     * bucket sort ,
     * the size of bucket equals the 
     * max number of the array which store the element
     *  
     * @param arr 数组
     */
	private static void bucketSort(double[] arr) {
		// TODO Auto-generated method stub
		//init 10 bucket
		ArrayList [] arrList = new ArrayList[10];
		// here allocate 10 arrayList store some number respectively.
		for (int i = 0; i < arrList.length; i++) {
			int tmp = (int)Math.floor(10*arr[i]) % arrList.length;
			if(null == arrList[tmp]){
				arrList[tmp] = new ArrayList();
			}
			arrList[tmp].add(arr[i]);
		}
		
		// evoke the Collections.sort Method  to Sort the 10 ArrayList
		for (int i = 0; i < arrList.length; i++) {
			if(null != arrList[i]){
				Collections.sort(arrList[i]);
			}
		}
		
		// get each ArrayList elements ,restore to the arr []
		int count = 0;
		for (int i = 0; i < arrList.length; i++) {
			if(null != arrList[i]){
				for (int j = 0; j < arrList[i].size(); j++) {
					arr[count++] = (double) arrList[i].get(j);
				}				
			}
		}
	}

	@SuppressWarnings("unused")
	private static void show(double[] arr){
		for (double d : arr) {
			System.out.print(d + "  ");
		}
		System.out.println();
	}
	
	/*
	 * when the data is three 232,433,454,...
	 * or 89,43,54,23,....
	 * how deal with these array
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double []arr = {0.78,0.17,0.39,0.26,0.72,0.94,0.21,0.12,0.23,0.68};
		bucketSort(arr);
		show(arr);
	}

}
