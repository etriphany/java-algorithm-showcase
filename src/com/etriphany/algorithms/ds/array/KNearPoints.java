package com.etriphany.algorithms.ds.array;

import java.util.Arrays;

/**
 * Given an array of points solution the K nearest points of a given reference point
 */
public class KNearPoints {

    public static final Point[] SAMPLE = {
            new Point(-2, 1), new Point(3, 2), new Point(1, 0), new Point(1, -2),
            new Point(-5, 4), new Point(-5, 7), new Point(4, 5), new Point(-3, -2)

    };

    public static void main(String[] args) {

        KNearPoints instance = new KNearPoints();
        instance.compute(SAMPLE, new Point(0,0), 2);
        System.out.println("\n ---");
        instance.compute(SAMPLE, new Point(5,8), 1);
    }

    public void compute(Point[] points, Point ref, int k) {

        // Compute the Euclidean Distance
        for (int i = 0; i < points.length; ++i) {
            points[i].dist = Math.sqrt((Math.pow(points[i].x - ref.x, 2) + Math.pow(points[i].y - ref.y, 2)));
        }

        // Create a heap with size of k
        Point[] heap = Arrays.copyOf(points, k);

        // Find max heap
        int maxHeapIndex = findMaxHeapIndex(heap);

        // Pick all smallest distances using the heap as reference
        for (int i = 0; i < points.length; ++i) {
            if (points[i].dist < heap[maxHeapIndex].dist) {
                // When max heap is changed, find max again
                heap[maxHeapIndex] = points[i];
                maxHeapIndex = findMaxHeapIndex(heap);
            }
        }

        // Print K points (unsorted output)
        for(int i = 0; i < heap.length; ++i) {
            System.out.print(String.format("Point(%d,%d) ", heap[i].x, heap[i].y));
        }
    }

    public int findMaxHeapIndex(Point[] values) {
        double max = 0.0;
        int index = 0;
        for(int i = 0; i < values.length; ++i) {
            if(values[i].dist > max) {
                max = values[i].dist;
                index = i;
            }
        }
        return index;
    }
}

class Point {

    public int x;
    public int y;
    public double dist;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
