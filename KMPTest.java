package ds;
/** 
 * Java实现KMP算法 
 *  
 * 思想：每当一趟匹配过程中出现字符比较不等，不需要回溯i指针，  
 * 而是利用已经得到的“部分匹配”的结果将模式向右“滑动”尽可能远  
 * 的一段距离后，继续进行比较。 
 *  
 * 时间复杂度O(n+m) 
 *  
 * @author xqh 
 *  
 */  
public class KMPTest {  
    public static void main(String[] args) {  
        String s = "abbabbbbcab"; // 主串  
        String t = "bbcab"; // 模式串  
        char[] ss = s.toCharArray();  
        char[] tt = t.toCharArray();  
        System.out.println(KMP_Index(ss, tt)); // KMP匹配字符串  
    }  
  
    /** 
     * 获得字符串的next函数值--改进版本
     *  
     * @param t 
     *            字符串 
     * @return next函数值 
     */  
    public static int[] next(char[] t) {  
        int[] next = new int[t.length];
        
        next[0] = -1;
        int i = 0; 
        //如果第一个字符就不匹配的话，直接两者都后移一位
        //j 是next数组的值 也是next数组的下标
        int j = -1;
        while (i < t.length - 1) {  
            if (j == -1 || t[i] == t[j]) {
                //从第j开始比较且相等，那么下一个i就要与下一个j比较了 ||j == -1
                i++;  
                j++;  
                //如果不相等那么确实应该从j处开始比较，
                if (t[i] != t[j]) {
                    next[i] = j;  
                } else {  
                    //T[i]与第j个位置比较且相等的话，比较了还是失配，那么就让其与next[j]比较
                    next[i] = next[j];
                }  
            } else {  
                //失配了的话，从第j 再重新开始比较,就要与next[j]比较
                j = next[j];
            }  
        }  
        return next;  
    }  
  
    /** 
     * KMP匹配字符串 
     *  
     * @param s 
     *            主串 
     * @param t 
     *            模式串 
     * @return 若匹配成功，返回下标，否则返回-1 
     */  
    public static int KMP_Index(char[] s, char[] t) {
        //next数组
        int[] next = next(t); 
        //主串第一个字字符  
        int i = 0;
        //模式串第一个字符
        int j = 0;
        
        while (i < s.length && j < t.length) {
            //-1表示前面没有匹配的p1--pk != pj-k+1--pj-1
            if (j == -1 || s[i] == t[j]) {  
                i++;  
                j++;  
            } else {  
                j = next[j];
            }  
        }
        //主串没走完，模式串走完了说明没有找到匹配模式
        if (j < t.length) {  
            return -1;  
        } else  
            //模式串完成了，说明中间某个位置开始匹配模式
            return i - t.length; // 返回模式串在主串中的头下标  
    }  
}  