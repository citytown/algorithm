package com.planone.entity;

public class OrderedArray {

	int[] array;
	int maxSize;
	int nElems;
	
	public OrderedArray(int maxSize){
		array = new int[maxSize];
		this.maxSize = maxSize;
		nElems = 0;        //当前数组长度
	}
	
	
	
	public int getnElems() {
		return nElems;
	}



	public void setnElems(int nElems) {
		this.nElems = nElems;
	}



	public void insert(int value){
		if(nElems==maxSize){
			System.out.println("数组已满，无法插入");
		}else{
			int j;
			for(j=0;j<nElems;j++){
				if(array[j]>value){
					break;
				}
			}
			for(int k=nElems;k>j;k--){
				array[k]=array[k-1];
			}
			array[j]=value;
			nElems++;
		}
	}
	
	public void delete(int value){
		int i;
		for(i=0;i<nElems;i++){
			if(array[i]==value){
				for(int j=i;j<nElems-1;j++){
					array[j]=array[j+1];
				}
				break;
			}
			
		}
		if(i==nElems){
			System.out.println("数组中不存在该元素");
			System.out.println();
		}else{
			nElems--;
		}
	}
	
	public void find(int value){
		int i;
		for(i=0;i<nElems;i++){
			if(array[i]==value){
				System.out.print("该元素在数组中的第"+(i+1)+"位");
				System.out.println();
				break;
				}
			}
		if(i==nElems){
			System.out.print("数组中不存在该元素");
			System.out.println();
		}
	}
	
	public void display(){
		System.out.println();
		for(int i=0;i<nElems;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	//非迭代方式的二分查找
	public boolean Search(int value){
		if(value<array[0]||value>array[nElems-1]||array[0]>array[nElems-1]){
			System.out.println("寻找的值不在该数组中");
			return false;
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
					return true; 
				}
			}
			System.out.println("数组中不存在该值！");
			return false;
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
	
}
