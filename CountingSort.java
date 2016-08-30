package ds;

/**
 * 计数排序   所有测试数据  都处于   0到k之间 == 分配的临时数组 
 *   首先不能出现负数
 *   其次不能直接对浮点数进行计数排序
 * @author fqx
 *
 */
public class CountingSort {
  //计数排序  
    static void counting_sort(int A[],int length_A,int B[],int k)  
    {  
        int []C = new int[1000];//C是临时数组  
        //此时C[i]包含等于A[i]的元素个数  
        for(int i=1;i<=length_A;i++)  
            C[A[i]]++;
        // 此时C[i]包含小于或者等于i的元素个数
        for(int i=1;i<=k;i++)  
            C[i]=C[i]+C[i-1];  
        //C[i]成为即将存放i值的位置，不过再存放到B[I]中
        for(int i=length_A;i>=1;i--)//从length_A到1逆序遍历是为了保证相同元素排序后的相对顺序不改变  
        {                           //如果从1到length_A,则相同元素的相对顺序会逆序，但结果也是正确的  
            B[C[A[i]]]=A[i];
            C[A[i]]--;  
        }  
    }  
    public static void main(String[] args) {
        int A[]={-1,2,6,5,4,8,9,7,1,10,3};//1到10,十个测试数据  
        int [] B= new int[11];  
        int k=10;//所有测试数据都处于0到k之间  
        counting_sort(A,10,B,k);  
        for(int i=1;i<11;i++)  
            System.out.print(B[i] + " ");  
    }
}
