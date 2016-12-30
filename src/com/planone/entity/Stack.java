package com.planone.entity;

public class Stack {


	int[] stackArray;
	int maxSize;
	int top;
	
	
	
	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public Stack(int maxSize){
		stackArray = new int[maxSize];
		this.maxSize = maxSize;
		top = -1;        //当前数组长度
	}
	
	//进栈
	public void push(int value){
		stackArray[++top] = value;
	}
	
	//出栈
	public int pop(){
		return stackArray[top--];
	}
	
	//查看元素
	public int peak(){
		return stackArray[top];
	} 
	
	//判断栈空
	public boolean isEmpty(){
		return top==-1;
	}
	
	
	//判断栈满
	public boolean isFull(){
		return top==maxSize-1;
	}
}
