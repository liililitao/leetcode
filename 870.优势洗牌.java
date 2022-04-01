import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=870 lang=java
 *
 * [870] 优势洗牌
 */

// @lc code=start
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        LinkedList<Node> listB = new LinkedList<>();
        for(int i = 0; i < B.length; i++){
            listB.add(new Node(B[i],i));
        }
        Collections.sort(listB,new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                return n1.value - n2.value;
            }
        });
        // 遍历A即可，将B数组作为输出容器，因为B的信息已经都存在LinkedList里了，这里B数组已经没用了
        for(int i = 0; i < A.length; i++){
            if(A[i] > listB.getFirst().value){
                B[listB.removeFirst().index] = A[i];
            }else{
                B[listB.removeLast().index] = A[i];
            }
        }
        return B;
    }
}
class Node{
    int value;
    int index;
    public Node(int value, int index){
        this.value = value;
        this.index = index;
    }
}
// @lc code=end

