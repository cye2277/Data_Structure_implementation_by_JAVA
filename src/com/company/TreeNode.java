package com.company;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int value){
        this.data = value;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void insert(int value){
        if (value == data){
            return;
        }
        if (value < data){
            if (left == null){
                left = new TreeNode(value);
            }else{
                left.insert(value);
            }
        }
        else{
            if (right == null){
                right = new TreeNode(value);
            }else{
                right.insert(value);
            }
        }
    }

    public void traverse(){
        if (left != null){
            left.traverse();
        }
        System.out.println(data+",");
        if (right != null){
            right.traverse();
        }
    }

    public int min(){
        if (left == null){
            return data;
        }else{
            return left.min();
        }
    }

    public int max() {
        if (right == null) {
            return data;
        } else {
            return right.max();
        }
    }

}
