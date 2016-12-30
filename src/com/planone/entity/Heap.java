package com.planone.entity;

import java.util.List;

/**
 * 理解堆的含义，并且实现堆的操作
 * @author citytown
 *
 */
public class Heap {
	
	public Node[] heapArray;
	public int maxSize;
	public int size;
	
	

	public Heap(int maxSize) {
		heapArray = new Node[maxSize] ;
		this.size = 0;
		this.maxSize = maxSize;
	}

	//完全二叉树增加一个节点，向上筛选
	public void insert(Node node){
		if(size == maxSize){
			System.out.println("数组已满，无法插入");
		}else{
			if(size == 0){
				heapArray[size++] = node;
			}else{
				heapArray[size++] = node;
				trickleUp(size-1);
			}
		}
	}
	
	//删除最大节点，就是根节点，则把最后一个节点放到根节点，然后向下筛选
	public Node deleteRoot(){
		if(size == 0){
			System.out.println("堆为空删除结束");
			return null;
		}else{
			heapArray[0] = heapArray[--size];
			trickleDown(0);
		}
		return heapArray[0];
		
	}
	
	//修改值
	public void change(int index,int newValue){
		int oldValue = heapArray[index].getId();
		heapArray[index].setId(newValue);
		int parent = (index-1)/2;
		if(newValue>heapArray[parent].getId()){
			trickleUp(index);
		}else{
			trickleDown(index);
			
		}
	}
	
	//遍历
	public void traverse(){
		for(int i = 0;i<size;i++){
			if(heapArray[i] != null){
				System.out.print(heapArray[i].getId());
			}else{
				System.out.print("--");
			}
			System.out.print("  ");
		}
		
	}
	
	
	//向上筛选
	public void trickleUp(int index){
		Node temp = heapArray[index];
		int parent = (index-1)/2;
		while(index>0 && heapArray[parent].getId()<temp.getId()){
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		heapArray[index] = temp;
	}
	
	//向下筛选
	public void trickleDown(int index){
		Node top = heapArray[index];
		int largeChild;
		while(index < size/2){
			if(heapArray[2*index+2] != null && (heapArray[2*index+2].id > heapArray[2*index+1].id)){
				largeChild = 2*index+2;
			}else{
				largeChild = 2*index+1;
			}
			if(top.getId()>heapArray[largeChild].getId()){   //如果大于索引位置最大子节点，则退出循环
				break;
			}
			heapArray[index] = heapArray[largeChild];
			index = largeChild;
		}    //至少有一个子节点
		heapArray[index] = top;
	}
	
}
