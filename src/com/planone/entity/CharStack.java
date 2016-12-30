package com.planone.entity;

public class CharStack {

	char[] charArray;
	int maxSize;
	int top;
	
	public CharStack(int size){
		this.maxSize = size;
		charArray = new char[maxSize];
		top = -1;
	}
	
	//进栈
	public void push(char value){
		charArray[++top] = value;
	}
		
	//出栈
	public char pop(){
		return charArray[top--];
	}
		
	//查看元素
	public char peak(){
		return charArray[top];
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
