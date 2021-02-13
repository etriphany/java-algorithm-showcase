package com.etriphany.algorithms.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Given the binary tree:
 *
 *                             1
 *                   2                    3
 *             4          5          6          7
 *
 * The output must be: 1 2 3 4 5 6 7
 *
 */
public class BreadthFirstTraversal {

    private static final Node SAMPLE;

    static {
        // Root
        SAMPLE = new Node(1);
        // 1st level
        SAMPLE.left = new Node(2);
        SAMPLE.right = new Node(3);
        // 2nd level
        SAMPLE.left.left = new Node(4);
        SAMPLE.left.right = new Node(5);
        SAMPLE.right.left = new Node(6);
        SAMPLE.right.right = new Node(7);
    }


    public static void main(String[] args) {
        BreadthFirstTraversal instance = new BreadthFirstTraversal();

        instance.compute_A(SAMPLE);
        System.out.println("\n------");
        instance.compute_B(SAMPLE);
    }

    // Approach A (re enter the tree for each level) => O(n * levels)
    private void compute_A(Node root) {
        int treeHeight = 4; // ignore tree height computation

        // We must use a loop that call the "print" method for each level.
        // If we try to implement it using a single method
        // the 1st left branch will be fully printed
        // before we reach its sibling right node
        for(int level = 1; level <= treeHeight; ++level) {
            compute_A(root, level);
        }
    }

    private void compute_A(Node node, int level) {
        if(node == null) {
            return;
        }

        if(level == 1) {
            // Stop condition reached, print node data
            System.out.print(node.data + " ");
        }
        else {
            // Move deeper on binary tree, but decrease the level
            compute_A(node.left, level - 1);
            compute_A(node.right, level - 1);
        }
    }

    // Approach B (using a supporting FIFO structure) => O(n)
    private void compute_B(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>(); // SqrtBinaySearch with PriorityQueue and see what happens
        queue.offer(root);

        while(queue.peek() != null) {

            Node node = queue.poll();
            System.out.print(node.data + " ");

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
    }

}
