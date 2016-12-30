package com.planone.entity;


public class PriorityQueue {

	int[] array;
	int maxSize;
	int nElems;
	
	public PriorityQueue(int size){
		this.maxSize = size;
		array = new int[maxSize];
		nElems = 0;
	}
	
	//队满
	public boolean isFull(){
		return nElems == maxSize;
	} 
	
	//队空
	public boolean isEmpty(){
		return nElems ==0;
	}
	
	//繁琐进队,数组越大，则优先级越大，越排在前面
	public void insert(int value){
		int i;
		if(nElems==0){
			array[nElems++] = value;
		}else{
			for(i=nElems-1;i>=0;i--){
				if(value>array[i]){
					array[i+1] = array[i];
				}else{
					break;
				}
			}
			array[++i] =value;
			nElems++;
		}
	}
	
	//简单出队
	public int deleteSimple(){
		return array[--nElems];
	}
	
	//简单入队
	public void insertSimple(int value){
		array[nElems++] = value;
	}
	
	//繁琐出队
	public int delete(){
		int min = nElems-1;
		for(int i = min-1;i>=0;i--){
			if(array[min]>array[i]){
				min = i;
			}
		}
		return array[min];
	}
	
	
	//遍历队
	public void listQueue(){
		for(int i=0;i<nElems;i++){
			System.out.print(array[i]+"  ");
		}
	}
}
