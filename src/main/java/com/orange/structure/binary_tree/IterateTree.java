package com.orange.structure.binary_tree;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树/红黑树遍历
 */
public class IterateTree {




    public NodeTree root;
    private List<NodeTree> list=new ArrayList<NodeTree>();
    public IterateTree(){
        init();
    }
    //树的初始化:先从叶节点开始,由叶到根
    public void init(){
        NodeTree x=new NodeTree("X",null,null);
        NodeTree y=new NodeTree("Y",null,null);
        NodeTree d=new NodeTree("d",x,y);
        NodeTree e=new NodeTree("e",null,null);
        NodeTree f=new NodeTree("f",null,null);
        NodeTree c=new NodeTree("c",e,f);
        NodeTree b=new NodeTree("b",d,null);
        NodeTree a=new NodeTree("a",b,c);
        root =a;
    }
    //定义节点类：
    private class NodeTree{
        private String data;
        private NodeTree left;//定义指向左子树的指针
        private NodeTree right;//定义指向右子树的指针
        public NodeTree(String data,NodeTree lchild,NodeTree rchild){
            this.data=data;
            this.left=lchild;
            this.right=rchild;
        }
    }

    /**
     *  前序遍历
     *  @author jingShuai
     */

    //递归
    public void recursionFront(NodeTree nodeTree) {
        if(null == nodeTree) {
            return ;
        }
        System.out.println(nodeTree);
        recursionFront(nodeTree.left);
        recursionFront(nodeTree.right);
    }
    public void IteratorFront(NodeTree nodeTree){
        System.out.println(nodeTree);
        stack.push(nodeTree);
        while(!stack.isEmpty()) {
            NodeTree curr = stack.pop();
            System.out.println(curr);
            if(null != curr.right) {
                stack.push(curr.right);
            }
            if(null != curr.left) {
                stack.push(curr.left);
            }
        }
    }

    /**
     * 中序遍历
     * 先左 后中 再右
     */
    //递归
    public void recursionMiddle(NodeTree nodeTree) {
        if(null == nodeTree) {
            return ;
        }
        recursionMiddle(nodeTree.left);
        System.out.println(nodeTree);
        recursionMiddle(nodeTree.right);

    }
    private Stack<NodeTree> stack = new Stack<>();

    //循环
    public void iteratorMiddle(NodeTree nodeTree) {
        stack.push(nodeTree);
        NodeTree curr = nodeTree.left;
        while(null != curr) {
            stack.push(curr);
            curr = curr.left;
        }

        while(!stack.isEmpty()) {
            NodeTree current = stack.pop();
            System.out.println(current.data);
            if(null != current.right) {
                stack.push(current.right);
                current = current.right.left;
                while(null != current) {
                    stack.push(current);
                    current = current.left;
                }
            }
        }

    }
    /**
     * 另一种方式是西安
     */
    public void IteratorMiddle2(NodeTree root){
        NodeTree curr = root;

        while(!stack.isEmpty() || curr != null) {

            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.println(curr.data);
            curr = curr.right;

        }
    }

    /**
     * 后序遍历
     * 先左 后右  再中
     */
    //递归
    public void recursionBehind(NodeTree nodeTree) {
        if(nodeTree == null) {
            return ;
        }
        recursionBehind(nodeTree.left);
        recursionBehind(nodeTree.right);
        System.out.println(nodeTree);
    }

    /**
     * 有问题，后面再改再看
     * @param nodeTree
     */
    public void iteratorBehind(NodeTree nodeTree){
        stack.push(nodeTree);
        NodeTree curr = nodeTree;
        while(!stack.isEmpty()) {

            while(null != curr.left){
                stack.push(curr.left);
                curr = curr.left;
            }
            curr = stack.pop();

            if(curr.right == null) {
                System.out.println(curr.data);
            } else {
                curr = curr.right;
                stack.push(curr);
            }

        }

    }

}
