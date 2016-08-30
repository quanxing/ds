package ds;
public class SelectSort {
    /**
     * 选择排序就是默认第一个为最小的；
     * 然后从后面依次找到最小的值，拿第i小的值交换。
     * 这样保证了最低端的数字先固定。
     * @param list
     */
	public static void selectSort(double [] list) {
		double min;
		int index;
		for (int i = 0; i < list.length - 1; i++) {
			min = list[i];
			index = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[j] < min){
					min = list[j];
					index = j;
				}
			}
			//若当前的index数字就是最小的，就不用交换了.
			if (index != i){
				list[index] = list[i];
				list[i] = min;
			}
		}
	}
	public static void main(String[] args) {
		double []list = {1,9,4.5,6.6,5.7,-4.5};
		selectSort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + "  ");
		}
	}
}
