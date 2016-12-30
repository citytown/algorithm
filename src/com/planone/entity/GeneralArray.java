package com.planone.entity;

public class GeneralArray {

	public int[] array;
	int maxSize;
	public int nElems;
	int[] array2;
	int maxSize2;
	int nElems2;
	
	public GeneralArray(int maxSize){
		array = new int[maxSize];
		this.maxSize = maxSize;
		nElems = 0;        //当前数组长度
	}
	
	public GeneralArray(int maxSize,int maxSize2){
		array = new int[maxSize];
		this.maxSize = maxSize;
		nElems = 0;        //当前数组长度
		array2 = new int[maxSize2];
		this.maxSize2 = maxSize2;
		nElems2 = 0;        //当前数组长度
	}
	
	public void insert(int value){
		if(nElems == maxSize){
			System.out.println("数组已满，无法继续插入");
		}else{
			array[nElems] = value;
		}
		nElems++;
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
	
	
	//组合两个数组
	public void merge(){
		for(int i=0;i<nElems2;i++){
			for(int j=0;j<nElems;j++){
				if(array2[i]<array[j]){
					nElems++;
					for(int x=nElems;x>j;x++){
						array[x] = array[x-1];
					}
					array2[i] = array[j];
				}
			}
		}
	}
	
	//删除重复项
	public void noDup(){
		for(int i=0;i<nElems;i++){
			for(int j=i+1;j<nElems;j++){
				if(array[i] == array[j]){
					for(int x=j;x<nElems-1;x++){
						array[x]=array[x+1];
					}
					nElems--;
				}
			}
		}
	}
	
	//删除重复项第二种算法，把它赋值给另外一个数组
	public void noDup2(){
		int i,j;
		for(i=0;i<nElems;i++){
			boolean flag = false;
			for(j=0;j<nElems2;j++){
				if(array[i] == array2[j]){
					flag = true;
					break;
				}
			}
			if(!flag){
				array2[j] =array[i];
				nElems2++;
			}
		}
		nElems = nElems2;
		array = array2;
	}
	
}
