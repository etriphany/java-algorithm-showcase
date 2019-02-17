package com.etriphany.algorithms.ds.tree;

public class Node implements Comparable<Node> {

    public Node right;

    public Node left;

    public Integer data;

    public Node(Integer data) {
        this.data = data;
    }


    @Override
    public int compareTo(Node node) {
        if(this.data == null) {
            return -1;
        }
        return this.data.compareTo(node.data);
    }
}