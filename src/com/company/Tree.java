package com.company;

public class Tree {
    private TreeNode root;
    public void insert(int value){
        if (root == null){
            root = new TreeNode(value);
        }
        else{
            root.insert(value);
        }
    }

    public void traverse(){
        root.traverse();
    }

    public void delete(int value){
        root = delete(root,value);
    }
    public TreeNode delete(TreeNode subtreeRoot, int value){
        if (subtreeRoot == null){
            return subtreeRoot;
        }
        if (value < subtreeRoot.data){
            subtreeRoot.setLeft(delete(subtreeRoot.getLeft(),value));
        }
        else if(value > subtreeRoot.getData()){
            subtreeRoot.setRight(delete(subtreeRoot.getRight(),value));
        }else{
            //case 1 and 2: node to delete has ) or 1 children
            if (subtreeRoot.getLeft() == null){
                return subtreeRoot.getRight();
            }else if(subtreeRoot.getRight() == null){
                return subtreeRoot.getLeft();
            }

            //case 3: node to delete has 2 children
            subtreeRoot.setData(subtreeRoot.getRight().min());

            subtreeRoot.setRight(delete(subtreeRoot.getRight(),subtreeRoot.getData()));
        }
        return subtreeRoot;
    }

    public static void main(String[] args) {
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        intTree.traverse();
        System.out.println();
        intTree.delete(15);
        intTree.traverse();
        System.out.println();
    }
}
