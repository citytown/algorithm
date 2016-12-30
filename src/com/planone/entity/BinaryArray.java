package com.planone.entity;

public class BinaryArray {

	/**
	 * 使用二分法进行数组的插入和删除和查找
	 */
	
	int[] array;
	int maxSize;
	int nElems;
	
	public BinaryArray(int maxSize){
		array = new int[maxSize];
		this.maxSize = maxSize;
		nElems = 0;
	}
	
	public boolean insert(int value) {
		if (nElems == maxSize) {   //数组已满则不插入
			System.out.println("数组容量超出，无法再插入后面数字");
			return false;
		} else {
			if(nElems==0){
				array[0] = value;
				nElems++;
				return true;
			}
			int start = 0;
			int end = nElems - 1;
			if (value < array[start]) {
				move(start);
				array[start] = value;
				nElems++;
				return true;
			}
			if (value > array[end]) {
				array[nElems-1] = value;
				nElems++;
				return true;
			}
			int middle = start + (end - start) / 2;
			while (!(array[middle] > value && array[middle - 1] < value)
					&& !(array[middle] < value && array[middle + 1] > value)) {
				if (array[middle] > value) { // 在小的一端继续二分
					end = middle - 1;
					middle = start + (end - start) / 2;
				} else { // 在大的一端继续二分
					start = middle + 1;
					middle = start + (end - start) / 2;
				}
			}
			if (array[middle] > value) { // 插入的位置是middle的后一位
				move(middle);
				array[middle] = value;
				nElems++;
				return true;
			} else { // 插入的位置是middle前一位
				move(middle + 1);
				array[middle + 1] = value;
				nElems++;
				return true;
			}
		}
	}
	
	//插入时候对数组做的移动操作
	public void move(int index){
		for(int n = nElems-1;n>index;n--){
			array[n+1] = array[n];
		}
	}
	
	public void delete(int value){
		
	}
	//非迭代方式的二分查找
	public void Search(int value){
		if(value<array[0]||value>array[nElems-1]||array[0]>array[nElems]){
			System.out.println("寻找的值不在该数组中");
		}else{
			int low = 0;
			int high = nElems-1;
			while(low<high){
				int middle = low +(high-low)/2;
				if(value<array[middle]){
					high = middle-1;
				}else if(value>array[middle]){
					low = middle+1;
				}else{
					System.out.println("要寻找的值在数组中的第"+(middle+1)+"位");
					break;
				}
			}
		}
	}
	
	//迭代方式的二分查找
	public int iterateSearch(int start,int end,int value){
		int middle = start+(end-start)/2;
		if(end>=start){
			if(array[middle]>value){
				return iterateSearch(start,middle-1,value);
			}else if(array[middle]<value){
				return iterateSearch(middle+1, end, value);
			}else{
				return middle+1;
			}
		}else{
			return -1;
		}
	}
	
	public void display(){
		System.out.println();
		for(int i=0;i<nElems;i++){
			System.out.print(array[i]+"   ");
		}
		System.out.println();
	}
}
