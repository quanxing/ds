package ds;

import java.util.Stack;

import offer.TreeNode23;
import offer.TreeOperate23;

enum pointTag {
    Link, Thread
};

class ThTreeNode {
    int data;
    ThTreeNode rchild;
    ThTreeNode lchild;
    pointTag ltag;
    pointTag rtag;

    ThTreeNode(int data) {
        this.data = data;
        rchild = null;
        lchild = null;
        rtag = pointTag.Link;
        ltag = pointTag.Link;
    }
}

public class ThreadTree {

    /**
     * 线索化二叉树--中序
     * 
     * @param root
     */
    static ThTreeNode pre = null;

    public static void InorderThread(ThTreeNode root) {
        /*
         * ThTreeNode thrt = new ThTreeNode(0); thrt.ltag = pointTag.Link;
         * thrt.rtag = pointTag.Thread; thrt.rchild = thrt;
         * 
         * if(root == null){ thrt.lchild = thrt; }else{ pre = thrt; thrt.lchild
         * = root; InThreading(root);
         * 
         * pre.rchild = thrt; pre.rtag = pointTag.Thread; thrt.rchild = pre; }
         */
        if (root != null) {
            InThreading(root);
        }
    }

    /**
     * 中序线索化二叉树
     * 
     * @param node
     * @param pre
     */
    private static void InThreading(ThTreeNode node) {
        // TODO Auto-generated method stub
        if (node != null) {
            InThreading(node.lchild);
            if (node.lchild == null) {
                node.ltag = pointTag.Thread;
                node.lchild = pre;
            }
            if (pre != null && pre.rchild == null) {
                pre.rtag = pointTag.Thread;
                pre.rchild = node;
            }
            pre = node;
            InThreading(node.rchild);
        }
    }

    /**
     * 中序线索化后的 二叉树中序遍历
     * 
     * @param p
     */
    public static void InOrderThreadTraverse(ThTreeNode p) {
        // 根节点
        while (p != null) {
            while (p.ltag == pointTag.Link) {
                p = p.lchild;
            }
            System.out.println(p.data);

            while (p.rtag == pointTag.Thread) {
                p = p.rchild;
                System.out.println(p.data);
            }
            p = p.rchild;
        }
    }

    /**
     * 前序二叉树序列化
     * 
     * @param root
     */
    public static void preOrderThread(ThTreeNode root) {
        if (root != null) {
            preThreading(root);
        }
    }

    /**
     * 前序线索化二叉树core code
     * 
     * @param root
     */
    private static void preThreading(ThTreeNode p) {
        // TODO Auto-generated method stub

        if (p != null) {
            /*
             * 先处理当前节点
             */
            // 前驱
            if (p.lchild == null) {
                p.ltag = pointTag.Thread;
                p.lchild = pre;
            }
            // 后继
            if (pre != null && pre.rchild == null) {
                pre.rtag = pointTag.Thread;
                pre.rchild = p;
            }
            // 记住前驱节点
            pre = p;

            if (p.ltag == pointTag.Link) {
                preThreading(p.lchild);
            }
            if (p.rtag == pointTag.Link) {
                preThreading(p.rchild);
            }
        }

    }

    private static void preThreadingTraverse(ThTreeNode root) {
        while (root != null) {
            System.out.println(root.data);
            if (root.ltag == pointTag.Link) {
                root = root.lchild;
            } else {
                root = root.rchild;
            }
        }
    }

    /**
     * 后序线索化二叉树core code
     * 
     * @param root
     */
    private static void postThreading(ThTreeNode p) {
        // TODO Auto-generated method stub

        if (p != null) {

            if (p.ltag == pointTag.Link) {
                postThreading(p.lchild);
            }

            if (p.rtag == pointTag.Link) {
                postThreading(p.rchild);
            }

            /*
             * 先处理当前节点
             */
            // 前驱
            if (p.lchild == null) {
                p.ltag = pointTag.Thread;
                p.lchild = pre;
            }
            // 后继
            if (pre != null && pre.rchild == null) {
                pre.rtag = pointTag.Thread;
                pre.rchild = p;
            }

            // 记住前驱节点
            pre = p;

        }

    }

    // 后序线索化遍历
    private static void postThreadingTraverse(ThTreeNode root) {

        ThTreeNode parent = null;
        ThTreeNode p = root;

        // 找到第一个即将打印的节点
        while (true) {
            while (p.ltag == pointTag.Link) {
                p = p.lchild;
            }
            if (p.rtag == pointTag.Thread) {
                break;
            } else {
                p = p.rchild;
            }
        }

        while (p != root) {

            System.out.println(p.data);

            parent = getParent(root, p);
            // 根节点
            if (parent == null) {
            } else if (parent.rchild == p || parent.lchild == p
                    && parent.rtag == pointTag.Thread) {
                p = parent;
            } else if (parent.rtag == pointTag.Link) {
                p = parent.rchild;
                while (true) {
                    while (p.ltag == pointTag.Link) {
                        p = p.lchild;
                    }
                    if (p.rtag == pointTag.Thread) {
                        break;
                    } else {
                        p = p.rchild;
                    }
                }

            }
        }

    }

    private static ThTreeNode getParent(ThTreeNode root, ThTreeNode x) {
        // 中序遍历查找
        ThTreeNode parent = null;
        boolean found = false;
        Stack<ThTreeNode> s = new Stack<ThTreeNode>();
        ThTreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur.ltag == pointTag.Link) {
                s.push(cur);
                
                parent = cur;
                cur = cur.lchild;
                
                if (cur != null && cur.data == x.data) {
                    found = true;
                    break;
                }

            }
            if (found) {
                break;
            } else {
                if (!s.isEmpty()) {
                    ThTreeNode top = s.pop();
                    // System.out.println(top.data);
                    parent = top;
                    if (top.rtag == pointTag.Link) {
                        cur = top.rchild;
                        if (cur.data == x.data) {
                            break;
                        }
                    }
                }
            }

        }
        return parent;
    }

    /**
     * 前序创建二叉树
     * 
     * @param a
     * @param i
     * @return
     */
    public ThTreeNode create(int[] a, int i) {
        // -1 null node
        if (a.length < 0 || i < 0 || i >= a.length)
            return null;
        if (a[i] == -1) {
            return null;
        }

        ThTreeNode T;
        T = new ThTreeNode(a[i]);
        T.lchild = create(a, 2 * i + 1);
        T.rchild = create(a, 2 * i + 2);
        return T;
    }

    public static void main(String[] args) {
        int[] a = { 8, 5, 12, 4, 7, -1, -1, 9, 3, -1, -1, -1, -1, -1, -1, -1,
                -1, 10 };
        /*
         * 8 5 12 4 79 3 10
         */

        ThTreeNode root = null;
        root = new ThreadTree().create(a, 0);
        /*
         * InorderThread(root); InOrderThreadTraverse(root);
         */
        /*
         * preOrderThread(root); preThreadingTraverse(root);
         */
        postThreading(root);
        System.out.println("dsf");
        postThreadingTraverse(root);

    }
}
