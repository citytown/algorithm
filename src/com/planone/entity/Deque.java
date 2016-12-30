package com.planone.entity;

/**
 * 定义双端队列
 * @author citytown
 *
 */
public class Deque {
	public int[] array;
	
	public int lfront;  //左边队头队尾指针
	public int lrear;
	public int rfront;  //右边对头队尾指针;
	public int rrear;
	
	public int maxSize;
	public int nElems;
	
	public Deque(int size){
		this.maxSize = size;
		this.array = new int[maxSize];
		this.nElems = 0;
		this.lfront = -1;
		this.lrear = -1;
		this.rfront = maxSize;
		this.rrear = maxSize;
		
	}
	//左入队
	public void insertLeft(int value){
		if(!isFull()){
			do{
				if(lrear == maxSize-1){
					lrear =-1;
				}
				lrear++;
			}while(array[lrear]!=0);
			array[lrear] =value;
			nElems++;
		}else{
			System.out.println("队已满，数值无法再进队");
		}
	}
	
	//左出队
	public int deleteLeft(){
		if(!isEmpty()){
			do{
				if(lfront == maxSize-1){
					lfront = -1;
				}
				lfront++;
			}while(array[lfront]  == 0);
			nElems--;
			int out = array[lfront];
			array[lfront] = 0;
			return out;
		}else{
			return -1;
		}
	}
	
	//右入队
	public void insertRight(int value){
		if(!isFull()){
			do{
				if(rrear == 0){
					rrear = maxSize;
				}
				rrear--;
			}while(array[rrear]!=0);
			array[rrear] =value;
			nElems++;
		}else{
			System.out.println("队已满，数值无法再进队");
		}
	}
	
	//右出队
	public int deleteRight(){
		if(!isEmpty()){
			do{
				if(rfront == 0){
					rfront = maxSize;
				}
				rfront--;
			}while(array[rfront]  == 0);
			nElems--;
			int out = array[rfront];
			array[rfront] = 0;
			return out;
		}else{
			return -1;
		}
	}
	//判断对空
	public boolean isEmpty(){
		return nElems == 0;
	}
	
	//判断堆满
	public boolean isFull(){
		return nElems == maxSize;
	}
}
