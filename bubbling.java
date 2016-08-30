package ds;
/**
 * 不要被那些所谓的边界值吓到，要分清事实
 * @author fqx
 *
 */
public class bubbling {
    //升序排列
	public void BubberSort(int [] a){
		for (int i = 0; i < a.length - 1; i++) {
		    //每两个数比较 都是 右 <= 左；
		    //一轮结束后，就有一个数的位置固定了（在高位）
		    //所以一轮比较结束后，剩余的未比较的长度是变化的如下循环条件
			for (int j = 0; j < a.length - 1 - i; j++) {
				if(a[j + 1] > a[j]){
				    int tmp = a[j];
				    a[j] = a[j+1];
				    a[j + 1] = tmp;
				}
			}
			show(a);
		}
	}
	
	public void bubble_1(int [] a){
	    int i = a.length - 1;
	    while(i  > 0){
	        //j 最大只能取到 len-2：因为 a[j] 要与a[j+1]比较
	        int pos = 0;
            for (int j = 0; j < i; j++) {
                if(a[j] > a[j+1]){
                    pos = j;
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
            i = pos;
            System.out.println("i " + i);
            show(a);
        }
	    
	    
	}
	public void show(int [] a){
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		bubbling b = new bubbling();
		int [] a = {3,0,4,2,6,9,5,10,1};
		b.BubberSort(a);
        b.show(a);

	}
}
