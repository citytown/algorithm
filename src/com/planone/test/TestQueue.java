package com.planone.test;

import org.junit.Test;

import com.planone.entity.Deque;
import com.planone.entity.PriorityQueue;

public class TestQueue {

	public static void main(String[] args) {
		 PriorityQueue queue = new PriorityQueue(10);
		 queue.insert(20);
		 queue.insert(40);
		 queue.insert(70);
		 queue.insert(60);
		 queue.insert(50);
		 queue.listQueue();
		 
		 
	}
	
	/**
	 * 测试双端队列
	 */
	@Test
	public void testDeque(){
		Deque deque = new Deque(10);
		deque.insertLeft(10);
		deque.insertLeft(20);
		deque.insertLeft(30);
		deque.insertLeft(40);
		deque.insertLeft(50);
		deque.insertRight(100);
		deque.insertRight(90);
		deque.insertRight(80);
		deque.insertRight(70);
		deque.insertRight(60);
		deque.deleteRight();
		deque.deleteRight();
		deque.insertLeft(110);
		while(!deque.isEmpty()){
			int out = deque.deleteRight();
			System.out.print(out +"  ");
		}
	}
}
