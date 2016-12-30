package com.planone.entity;

import java.util.Random;

public class TestHeap {

	public static void main(String[] args) {
		Heap heap = new Heap(10);
		for(int i = 0;i<10;i++){
			int temp = new Random().nextInt(100)+1;
			Node node = new Node(temp);
			heap.insert(node);
		}
		heap.traverse();
		Heap heap2 = new Heap(10);
		for(int i=0;i<10;i++){
			Node temp = heap.deleteRoot();
			heap2.insert(temp);
		}
		System.out.println();
		heap2.traverse();
	}
}
