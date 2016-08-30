package ds;
public class InsertSort {

	public static void insertSort(double[] list) {
	    
		for (int i = 1; i < list.length; i++) {
			// ֻ�� i С�ڴ�������������Сֵ���Ž���������ƶ�
		    //稳定的排序算法
			if (list[i] < list[i - 1]) {
				double tmp = list[i];
				list[i] = list[i - 1]; //yidong
				int j;
				for (j = i - 2; j >= 0 && tmp < list[j]; j--) {
				    list[j + 1] = list[j];
					/*if (tmp < list[j]) {
						list[j + 1] = list[j];
					}else{
						break;
					}*/
				}
				list[j + 1] = tmp;
			}
		}
	}
	
	public static void insertSort1(double[] list) {

		/*for (int i = 1; i < list.length; i++) {
			double tmp = list[i];
			int k;
			for (k = i - 1; k >= 0 && list[k] > tmp; k--) {
				list[k + 1] = list[k];
			}
			list[k + 1] = tmp;
		}*/
	    
	    //Arrays.sort()
	    int off = 0;
	    int len = list.length;
	    for(int i = 0; i < list.length; i++){
	        for(int j = i; j > 0 && list[j - 1] > list[j]; j--){
	            swap(list, j, j-1);
	        }
	    }
	}

	private static void swap(double[] list, int j, int i) {
        // TODO Auto-generated method stub
        double tmp = list[i];
        list[j] = list[i];
        list[i] = tmp;
    }

    public static void main(String[] args) {
		double[] list = { 1, 9, 4.5, 6.6, 5.7, -4.5 };
		insertSort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + "  ");
		}
		
		insertSort1(list);
		System.out.println("\n=======");
		for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "  ");
        }
	}
}
