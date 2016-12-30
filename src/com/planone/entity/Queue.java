package com.planone.entity;

public class Queue {

	int[] array;
	int front;  //队头指针
	int rear; //队尾指针
	int nElems; //数组长度
	int maxSize;
	
	public Queue(int size){
		maxSize = size;
		array = new int[size];
		front =0;
		rear = -1;
		nElems = 0;
	}
	
	//入队
	public void insert(int value){
		array[++rear] = value;
		nElems ++;
	}
	
	//出队
	public int remove(){
		nElems --;
		return array[front++];
	}
	
	//查看队头元素
	public int peekFront(){
		return array[front];
	}
	
	//查看队尾元素
	public int peekRear(){
		return array[rear];
	}
	
	//队为空
	public boolean isEmpty(){
		return nElems == 0;
	}
	
	//队满
	public boolean isFull(){
		return nElems == maxSize;
	}
}
