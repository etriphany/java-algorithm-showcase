package com.etriphany.algorithms.ds.tree;

/**
 * Given the binary tree:
 *
 *                             1
 *                   2                    3
 *             4          5         6           7
 *
 * The output must be:
 *
 * (a) Inorder (Left, Root, Right) : 4 2 5 1 6 3 7
 * (b) Preorder (Root, Left, Right) : 1 2 4 5 3 6 7
 * (c) Postorder (Left, Right, Root) : 4 5 2 6 7 3 1
 */
public class DeepFirstTraversal {

    public  static final Node SAMPLE;

    static {
        SAMPLE  = new Node(1);
        // 1st level
        SAMPLE.left = new Node(2);
        SAMPLE.right = new Node(3);
        // 2nd level
        SAMPLE.left.left = new Node(4);
        SAMPLE.left.right = new Node(5);
        SAMPLE.right.left= new Node(6);
        SAMPLE.right.right= new Node(7);
    }

    public static void main(String[] args) {
        DeepFirstTraversal instance = new DeepFirstTraversal();

        instance.inorder(SAMPLE);
        System.out.println("\n---");
        instance.preorder(SAMPLE);
        System.out.println("\n---");
        instance.postorder(SAMPLE);
    }

    // Inorder
    public void inorder(Node node) {
        // Stop condition
        if(node == null) {
            return;
        }

        // Traverse left-subtree (recursive)
        inorder(node.left);

        // Visit root/parent
        System.out.print(node.data + " ");

        // Traverse right-subtree (recursive)
        inorder(node.right);
    }

    public void preorder(Node node) {
        // Stop condition
        if(node == null) {
            return;
        }

        // Visit root/parent
        System.out.print(node.data + " ");

        // Traverse left-subtree (recursive)
        preorder(node.left);

        // Traverse right-subtree (recursive)
        preorder(node.right);
    }

    public void postorder(Node node) {
        // Stop condition
        if(node == null) {
            return;
        }

        // Traverse left-subtree (recursive)
        postorder(node.left);

        // Traverse right-subtree (recursive)
        postorder(node.right);

        // Visit root/parent
        System.out.print(node.data + " ");
    }
}
