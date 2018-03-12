package com.jumfens.Tree;

import org.junit.Test;

public class MaxDistenceOfTree {

    public static void main(String[] args) {
        NodeWithDis root = new NodeWithDis(6);
        NodeWithDis n1 = new NodeWithDis(3);
        NodeWithDis n2 = new NodeWithDis(1);
        NodeWithDis n3 = new NodeWithDis(5);
        NodeWithDis n4 = new NodeWithDis(2);
        NodeWithDis n5 = new NodeWithDis(9);

        root.left = n1;root.right=n2;
        n1.left=n3;n1.right=null;
        n2.left=n5;n2.right=null;
        n3.left=null;n3.right=n4;
        n4.left=null;n4.right=null;
        n5.left=null;n5.right=null;

        getMaxDistence(root);
        System.out.println("maxDis = "+maxDis);
    }

    static int maxDis = 0;

    private static void getMaxDistence(NodeWithDis root) {
        if(root==null)
            return;

        if(root.left==null)
            root.leftDis=0;
        if(root.right==null)
            root.rightDis=0;

        if(root.left!=null)
            getMaxDistence(root.left);
        if(root.right!=null)
            getMaxDistence(root.right);

        if(root.left!=null)
            root.leftDis = (root.left.leftDis>root.left.rightDis?root.left.leftDis:root.left.rightDis) +1 ;

        if(root.right!=null)
            root.rightDis = (root.right.leftDis>root.right.rightDis?root.right.leftDis:root.right.rightDis) +1 ;

        if(root.leftDis+root.rightDis>maxDis)
            maxDis=root.leftDis+root.rightDis;
    }
}
