package com.example.javapractise.core;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

   static class Node {
        Node left;
        Node right;
        Integer i;

        Node(Integer i) {
            this.i = i;
            left = null;
            right = null;
        }
    }

    static Node root;

    public static void addElement(Integer i) {

        if (root == null) {
            System.out.println("root " + i);
            root = new Node(i);
            return;
        }
        addElementRec(root, new Node(i));
    }

    static void addElementRec(Node root, Node node) {
        if (root.i >= node.i) {
            if (root.left == null) {

                System.out.println(" -> left inserted: "+node.i);
                root.left = node;
                return;
            } else {
                addElementRec(root.left, node);
            }
        } else {
            if (root.right == null) {

                System.out.println(" -> right inserted: "+node.i);
                root.right = node;
                return;
            } else {

                addElementRec(root.right, node);
            }
        }
    }

    static void findMax() {
        if (root == null) {
            return;
        }

        Node right = root.right;
        if (right != null) {
            while (right.right != null) {
                right = right.right;
            }
            System.out.println("Max " + right.i);
        } else {
            System.out.println("max is root " + root.i);
        }
    }

    static void findMin() {
        if (root == null) {
            return;
        }

        Node left = root.left;
        if (left != null) {
            while (left.left != null) {
                left = left.left;
            }
            System.out.println("Max " + left.i);
        } else {
            System.out.println("max is root " + root.i);
        }
    }

    static void find(int i) {
        if (root == null) {
            System.out.println("not found.");
        }
        if (root.i == i) {
            System.out.println("found at root");
        }

        if (root.i > i) {
            Node left = root.left;

            if (left != null) {
                if (left.i == i) {
                    System.out.println("found at left" + left.i);
                } else {
                    while (left.i != i) {
                        left = left.left;
                    }
                    System.out.println("found at left " + left.i + " " + i);
                }
            }
        } else {
            Node right = root.right;

            if (right != null) {
                if (right.i == i) {
                    System.out.println("found at right" + right.i);
                } else {
                    while (right.i != i) {
                        right = right.right;
                    }
                    System.out.println("found at right " + right.i + " " + i);
                }
            }
        }
    }

    static boolean findRec(Node current, int i) {

        if (current == null) {
            return false;
        }

        if (current.i == i) {
            return true;
        }

        if (current.i > i) {
            return findRec(current.left, i);
        } else {
           return findRec(current.right, i);
        }
    }

    public static void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            System.out.println("nodes.size() first " + nodes.size());
            Node node = nodes.remove();
            System.out.println("nodes.size() " + nodes.size());

            System.out.print(" " + node.i);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right!= null) {
                nodes.add(node.right);
            }
        }
    }


    static void traversePreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.i);
        if (root.left != null) {
            traversePreOrder(root.left);
        }
        if (root.right != null) {
            traversePreOrder(root.right);
        }
    }

    static void traversePostOrder(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            traversePreOrder(root.left);
        }
        if (root.right != null) {
            traversePreOrder(root.right);
        }
        System.out.println("post order  : " + root.i);
    }


    public static void main(String[] args) {
        addElement(8);
        addElement(3);
        addElement(10);
        addElement(1);
        addElement(6);

        traversePreOrder(root);

        traversePostOrder(root);

        findMax();
        findMin();

        find(10);

        System.out.println("findRec " + findRec(root, 5));


        traverseLevelOrder();
    }
}
