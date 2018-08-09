package com.orange.structure.binary_tree;


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
    //循环
    // 中  左  右
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

    //循环--自己写的，太麻烦了
//    public void iteratorMiddle(NodeTree nodeTree) {
//        stack.push(nodeTree);
//        NodeTree curr = nodeTree.left;
//        while(null != curr) {
//            stack.push(curr);
//            curr = curr.left;
//        }
//
//        while(!stack.isEmpty()) {
//            NodeTree current = stack.pop();
//            System.out.println(current.data);
//            if(null != current.right) {
//                stack.push(current.right);
//                current = current.right.left;
//                while(null != current) {
//                    stack.push(current);
//                    current = current.left;
//                }
//            }
//        }
//
//    }
    /**
     * 排序： 左 中  右
     *
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
     * 后续排序
     * 这个方式是前序排序的一种变形，前序是 中 左 右。。这个是中  右  左，然后通过stack反序输出
     * @param nodeTree
     */
    public void iteratorBehind(NodeTree nodeTree){
        stack.push(nodeTree);
        Stack<NodeTree> outPut =  new Stack<>();
        NodeTree curr ;
        while(!stack.isEmpty()) {

            curr = stack.pop();
            outPut.push(curr);

            if(null != curr.left){
                stack.push(curr.left);
            }
            if(null != curr.right) {
                stack.push(curr.right);
            }
        }
        while (outPut.size() > 0) {

            System.out.println(outPut.pop().data);
        }

    }

    /**
     * -----后序排序（***********这个方法不需要记）
     * 这个是一种方法，实际排序是 中  右  左，通过stack反序输出。
     * @param nodeTree
     */
    public void iteratorBehind2(NodeTree nodeTree){
        Stack<NodeTree> stack = new Stack<>();
        Stack<NodeTree> output = new Stack<>();//构造一个中间栈来存储逆后序遍历的结果
        NodeTree node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        System.out.println(output.size());
        while (output.size() > 0) {

            System.out.println(output.pop().data);
        }
    }

}
