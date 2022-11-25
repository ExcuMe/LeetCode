package code;


import com.sun.jmx.remote.internal.ArrayQueue;
import lombok.Data;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: wuyujie
 * @Date: 2022-07-03-19:07
 * @Description: 二叉树算法——深度优先遍历和广度优先遍历
 */
public class BinaryTree {


    @Data
    public static class TreeNode{
        String value;
        TreeNode leftNode;
        TreeNode rightNode;


        public TreeNode(String value) {
            this. value = value;
        }

        public TreeNode(String value, TreeNode leftNode, TreeNode rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    /**
     * 深度优先遍历（递归）
     * @param node
     */
    public void dfsWithRecursive(TreeNode node){
        if (null == node){
           return;
        }
        dfsWithRecursive(node.leftNode);
        dfsWithRecursive(node.rightNode);
    }

    /**
     * 深度优先遍历（非递归）
     * 需要辅助数据结构：栈
     * @param node
     */
    public void dfs(TreeNode node){
        if (null == node){
            // 空树
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            //先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
            if (treeNode.rightNode != null){
                stack.push(treeNode.rightNode);
            }
            if(treeNode.leftNode != null){
                stack.push(treeNode.leftNode);
            }
        }
    }

    /**
     * 广度优先遍历（非递归）
     * 辅助数据结构：队列
     * @param node
     */
    public void bfs(TreeNode node){
        if(node == null){
            // 空树
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode.leftNode != null)
                queue.offer(treeNode.leftNode);
            if(treeNode.rightNode != null)
                queue.offer(treeNode.rightNode);
//            lists.add(tree.val);
        }
    }



}
