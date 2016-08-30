package ds;
import java.util.Scanner;

public class SortMerge {

	/*
	 * i have no idea, just define i point to the s, j point to the m + 1, then
	 * proceed to compare the array[i] and array[j], tmp store the smaller.
	 * MergSort like two link in DataStructure written by yanweimin.
	 */
	static void Merge(int[] array, int[] tmp, int s, int m, int e) {
		// when start merger, we use the tmp array store the sorted element
		/*
		 * System.out.println(s + "  " + m + "   " + e); show(array);
		 */
		// point to the start and end of the array
		// version-1
		/*
		 * int j,k,i; for(j = m + 1,i = s, k = s; i <= m && j <= e; k++){ if
		 * (array[i] < array[j]) tmp[k] = array[i++]; else tmp[k] = array[j++];
		 * }
		 */
		// version_2 ;k pos store the current small element
		int i = s, j = m + 1, k = s;
		while (i <= m && j <= e) {
			if (array[i] < array[j]) {
				tmp[k++] = array[i++];
			} else {
				tmp[k++] = array[j++];
			}

		}
		// if right part haved add to the tmp, so left part copy to the tmp
		// directly
		while (i <= m) {
			tmp[k++] = array[i++];
		}
		// as the above
		while (j <= e) {
			tmp[k++] = array[j++];
		}

		// copy the sorted tmp to the original array; my idea by myself
		for (int r = s; r <= e; r++) {
			array[r] = tmp[r];
			// System.out.print(array[r] + "  ");
		}
	}

	/*
	 * s start of the array e the end of the array
	 */
	static void MSort(int[] array, int s, int e) {

		int[] tmp = new int[array.length];
		/*
		 * when s < e , we can start merge if s== e ,we need not do anything
		 */
		// if (s == e) return ;
		if (s < e) {
			int m = (s + e) / 2;
			MSort(array, s, m);
			MSort(array, m + 1, e);
			Merge(array, tmp, s, m, e);
		}
		// here alse can return array , just modify the return type to int array
		// just like static int [] array
	}

	public static void MergSort(int[] array) {
		show(array);
		MSort(array, 0, array.length - 1);
		show(array);
	}

	public static void show(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = { 49, 38, 65, 97, 76, 13, 27 };
		
	/*	Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int [] arr = new int[n];
		for(int i =0 ; i < arr.length; i++){
			arr[i] = s.nextInt();
		}
		MergSort(arr);*/
		MergSort(array);
		
		
	}
}
