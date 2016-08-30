package ds;

import java.util.*;

/**
 * 基数排序：目前实现对数字的排序 实现对字符串的排序？ or 其他类型的数据呢？
 * 
 * @author fqx
 *
 */
public class RadixSort {
    /**
     * 升序排列数组中值
     * 
     * @param array
     * @return
     */
    public static int[] asc(int[] array) {
        if (array == null || array.length == 0)
            return null;
        int index = 1; // 最大数字位数（如100为3位数字，2000为4位数字）
        // 取得最大数字位数
        for (int i = 0; i < array.length; i++) {
            int length = Integer.toString(array[i]).length();
            if (index < length) {
                index = length;
            }
        }
        return sort(array, 0, index);
        // return sort(array, index);
    }

    /**
     * 
     * @param array
     *            数组
     * @param index
     *            最大的位数
     * @return
     */
    public static int[] sort(int[] array, int index) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        // 每轮循环都比较一位数字
        for (int i = 0, rate = 1; i < index; i++) {
            // 每次的都要清空列表,重新存放桶里面的数据.
            //定义10个桶，重新清空。每比较完成一次，都会重新存放数据
            for (int ii = 0; ii < 10; ii++) {
                list.add(new ArrayList<Integer>());
            }

            // 分配
            for (int j = 0; j < array.length; j++) {
                // 桶编号bucket_index
                // 如果出现高位为0（没有值）【 23 ，123】
                // 默认放在的0的队列中 因为数字没有以0开头的
                //
                int bucket_index = (array[j] / rate) % 10;
                list.get(bucket_index).add(array[j]);
            }
            // 收集 常数时间
            int k = 0;
            for (int j = 0; j < list.size(); j++) {
                for (int j2 = 0; j2 < list.get(j).size(); j2++) {
                    array[k++] = list.get(j).get(j2);
                }
            }
            rate *= 10;
            list.clear();
        }
        return array;
    }

    /**
     * 递归的方法--对别人的写的小改进
     * 
     * @param array
     *            数组
     * @param exponent
     *            起始位数(代码中实际意义为：10的exponent次方。起始位数即为10的0次方，所以为个位)
     * @param index
     *            最大数字位数（如100为3位数字，2000为4位数字）
     * @return
     */

    private static int[] sort(int[] array, int exponent, int index) {

        int length = array.length;
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        if (index == ++exponent) {
            return array;
        }

        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList<Integer>());
        }
        // 分配
        for (int i = 0; i < length; i++) {
            int num = (int) ((array[i] / Math.pow(10, exponent)) % 10);
            list.get(num).add(array[i]);
        }
        // 收集
        for (int k = 0, i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                array[k++] = list.get(i).get(j);
            }
        }
        // 若还有更高位数，则按照下一位数进行排序
        return sort(array, exponent, index);
    }

    /**
     * 实现了利用 基排序 对 String 的排序
     * 
     * @param array
     * @return
     */

    public static String[] asc(String[] array) {
        if (array == null || array.length == 0)
            return null;
        int index = 1; // 最大数字位数（如100为3位数字，2000为4位数字）
        // 取得最大数字位数
        for (int i = 0; i < array.length; i++) {
            int length = array[i].length();
            if (index < length) {
                index = length;
            }
        }
        // return sort(array, 0, index);
        return sort(array, index);
    }

    /**
     * 
     * @param array
     *            数组
     * @param index
     *            最大的位数
     * @return
     */
    public static String[] sort(String[] array, int index) {
        // 定256个桶

        List<List<String>> list = new ArrayList<List<String>>();
        // 每轮循环都比较一位数字
        for (int i = 0; i < index; i++) {
            // 每次的都要清空列表,重新存放桶里面的数据.
            for (int ii = 0; ii < 256; ii++) {
                list.add(new ArrayList<String>());
            }

            // 分配
            for (int j = 0; j < array.length; j++) {
                // 桶编号bucket_index
                // 此处也要低位 --- 高位比较
                // 高位出现空格的话，那么将他们收集在255的位置，不影响其他的元素排序位置
                int bucket_index = 255;
                if (i < array[j].length()) {
                    bucket_index = array[j].charAt(array[j].length() - 1 - i);
                }
                list.get(bucket_index).add(array[j]);
            }
            // 收集 常数时间
            int k = 0;
            for (int j = 0; j < list.size(); j++) {
                for (int j2 = 0; j2 < list.get(j).size(); j2++) {
                    array[k++] = list.get(j).get(j2);
                }
            }
            list.clear();
        }
        return array;
    }

    public static void main(String[] args) {

        int[] data = { 73, 22, 93, 867494, 43, 55, 123, 8978, 10000, 14, 28,
                65, 39, 81, 33, 100, 567 };
        int[] result = asc(data);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        
        System.out.println();
        String[] ar = { "cap", "to", "cat", "card", "two", "too", "up", "boat",
                "boot" };
        String[] result_11 = asc(ar);
        for (int i = 0; i < result_11.length; i++) {
            System.out.print(result_11[i] + " ");
        }
    }
}
