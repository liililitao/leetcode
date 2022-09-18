import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    //啊哈哈哈，我就是个天才！！！其实思想还是运用队列，只不过从二叉树变成了N叉树
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        queue.offer(root);//入队
        while(!queue.isEmpty()) {//当队列非空时
            List<Integer> list = new ArrayList<>();
            int l = queue.size();//上一层的个数
            for(int i = 0; i < l; i++) {//把上一层的都加进来，并且出一个入N个
                Node node = queue.poll();//出队
                list.add(node.val);//加到list中
                //核心代码：children是一个列表，记录了所有的孩子
                for(int j = 0; j < node.children.size(); j++) {
                    queue.offer(node.children.get(j));//所有的孩子都入队
                }
            }
            res.add(list);//一层
        }
        return res;
    }
}
// @lc code=end

