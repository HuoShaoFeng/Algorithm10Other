package com.jumfens.Tree;

import java.util.Stack;

public class TraverseTree {

    public static void main(String[] args) {
        Node root = new Node(6);
        Node n1 = new Node(3);
        Node n2 = new Node(1);
        Node n3 = new Node(5);
        Node n4 = new Node(2);
        Node n5 = new Node(9);

        root.left = n1;root.right=n2;
        n1.left=n3;n1.right=null;
        n2.left=n5;n2.right=null;
        n3.left=null;n3.right=n4;
        n4.left=null;n4.right=null;
        n5.left=null;n5.right=null;

        System.out.println("先序：");
        preOrderRecur(root);
        System.out.println();
        preOrderUnRecur(root);

        System.out.println();
        System.out.println("中序：");
        inOrderRecur(root);
        System.out.println();
        inOrderUnRecur(root);

        System.out.println();
        System.out.println("后序：");
        postOrderRecur(root);
        System.out.println();
        postOrderUnRecur(root);
    }


    //先序递归遍历
    public  static void preOrderRecur(Node root){
        if(root==null)
            return;
        System.out.print(root.data+", ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    //中序递归遍历
    public  static void inOrderRecur(Node root){
        if(root==null)
            return;
        inOrderRecur(root.left);
        System.out.print(root.data+", ");
        inOrderRecur(root.right);
    }

    //后序递归遍历
    public  static void postOrderRecur(Node root){
        if(root==null)
            return;
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        System.out.print(root.data+", ");
    }

    //先序非递归遍历
    public static void preOrderUnRecur(Node root){
        if(root!=null){
            Stack<Node> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()){
                root = stack.pop();

                System.out.print(root.data+"- ");

                if(root.right!=null)
                    stack.push(root.right);
                if(root.left!=null)
                    stack.push(root.left);
            }
        }
    }

    //中序非递归遍历
    public static void inOrderUnRecur(Node root) {
        if(root!=null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || root!=null){
                if(root!=null){
                    stack.push(root);
                    root = root.left;
                }else{
                    root = stack.pop();
                    System.out.print(root.data+", ");
                    root = root.right;
                }
            }
        }
    }

    //后序非递归
    private static void postOrderUnRecur(Node root) {
        if(root!=null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty()){
                root=s1.pop();
                s2.push(root);
                if(root.left!=null)
                    s1.push(root.left);
                if(root.right!=null)
                    s1.push(root.right);
            }
            while (!s2.isEmpty()){
                System.out.print(s2.pop().data+", ");
            }
        }


    }

}
