package ds;

/**
 * shell sort 
 * none stable
 * 时间复杂度见 严蔚敏数据结构
 * @author fqx
 *
 */
public class ShellSort {

    static void print(int [] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    static void shellInsertSort(int[] a, int dk) {
        for (int i = dk; i < a.length; i++) {
            int tmp = a[i];
            int j = 0;
            //改进网上的版本；这个j >=0测试均成功
            //当dk = 1 演化为直接插入排序
            for (j = i - dk; j >= 0  && a[j] > tmp; j -= dk) {
                a[j + dk] = a[j];
            }
            a[j + dk] = tmp;
            print(a);
        }
        
    }

    void shellSort(int[] a) {
        int dk = a.length / 2;
        while (dk >= 1) {
            shellInsertSort(a, dk);
            dk /= 2;
        }
        
    }

    public static void main(String[] args) {
        int[] a = { 3, 1, 5, 7, 2, 4, 9,6};
        // ShellInsertSort(a,8,1); //直接插入排序
        new ShellSort().shellSort(a);
    }
}
