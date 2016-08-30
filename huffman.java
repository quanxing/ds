package ds;

import offer.HierarchicalTrees60;
import offer.TreeNode23;

import java.util.*;

public class huffman {
    private static TreeNode23 min = null, secMin = null;

    /**
     * @param list
     *            O(n)的时间内实现同时找到最小和次小的值
     *            list会不断的删除元素
     */
    public static void min(LinkedList<TreeNode23> list) {
        int i = 0;
        int n = list.size();
        // 奇数
        if ((n & 1) != 0) {
            min = secMin = list.get(i);
            i++;
        } else {
            if (list.get(0).data > list.get(1).data) {
                min = list.get(0);
                secMin = list.get(1);
            } else {
                min = list.get(1);
                secMin = list.get(0);
            }
            i += 2;
        }
        for (; i < n; i += 2) {
           TreeNode23 tmpMax =null;
           TreeNode23 tmpMin = null;
           
           if(list.get(i).data < list.get(i+1).data){
               tmpMax = list.get(i+1);
               tmpMin = list.get(i);
           }else{
               tmpMax = list.get(i);
               tmpMin = list.get(i+1);
           }
           
           //secMin < min 这个地方想了很久
           if(tmpMin.data <secMin.data){
               min = secMin;
               secMin = tmpMin;
               
           }else{
               if(tmpMin.data < min.data){
                   min = min.data < tmpMax.data ? min:tmpMax;
               }
           }
           //
           if(secMin.data < tmpMax.data && tmpMax.data < min.data){
               min = tmpMax;
           }
        }
    }

    public static TreeNode23 createHuffman(int[] arr) {
        LinkedList<TreeNode23> list = new LinkedList<TreeNode23>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new TreeNode23(arr[i]));
        }
        /*
         * 每一次重新找到最小和次小
         */
        
        TreeNode23 root = null;
        while(list.size() > 1){
            min(list);
            
            root = new TreeNode23(secMin.data + min.data);
            root.left = secMin;
            root.right = min;
            
            list.add(root);
            list.remove(min);
            list.remove(secMin);
            
        }
        System.out.println(secMin.data+" " +min.data);
        
        return root;
    }

    public static void main(String[] args) {
        int[] weight = { 8, 6, 5, 3, 1, 15 };
        
        createHuffman(weight);
        
        TreeNode23 huffTree = createHuffman(weight);
        //分层遍历
        ArrayList<ArrayList<Integer>> list = new HierarchicalTrees60().PrintHierarchicalOrder(huffTree);
        System.out.println(list);
    }
}
