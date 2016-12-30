package com.planone.entity;

public class SortAlgorithm {

	//冒泡排序
	public void bubblesort(GeneralArray array){
		for(int i=0;i<array.nElems;i++){
			for(int j=i+1;j<array.nElems;j++){
				if(array.array[i]>array.array[j]){
					int temp=array.array[i];
					array.array[i] = array.array[j];
					array.array[j] = temp;
				}
			}
		}
	}
	
	//选择排序
	public void selectSort(GeneralArray array){
		for(int i=0;i<array.nElems;i++){
			int min = i;
			int j=0;
			for(j=i+1;j<array.nElems;j++){
				if(array.array[min]>array.array[j]){
					min = j;
				}
			}
			int temp = array.array[min];
			array.array[min] = array.array[i];
			array.array[i] = temp;
			
		}
	}
	
	
	//插入排序时，比较的时候是从0位开始比较
	public void insertSort(GeneralArray array){
		int i;
		int k;
		int temp = array.array[0];
		int min = 0;
		for(i=1;i<array.nElems;i++){
			for(k=0;k<i;k++){
				if(array.array[i]<array.array[k]){
					temp = array.array[i];
					min = k;
					break;
				}
			};
			for(int j=i;j>k;j--){
				array.array[j] = array.array[j-1];
			}
			array.array[min] = temp;
		}
	}
	
	//插入排序时，选择有当前位置后面以为开始比较
	public void otherInsertSort(GeneralArray array){
		int min;
		int i;
		int out;
		for(i=1;i<array.nElems;i++){
			int temp = array.array[i];
			out =i;
			while(out>0&&(temp<array.array[out-1])){
				array.array[out] = array.array[out-1];
				 out--;
			}
			array.array[out] = temp;
		}
	}
	
	//快速排序
	public void quickSort(GeneralArray array){
		int start = 0;
		int end = array.nElems-1;
		int index = end;   //基准元素当前的位置
		int value = array.array[end];
		for(int i=start;i<array.nElems;i++){
			if(array.array[i]>value){
				exchangeElement(array,index,i);
				index = i;
			}
		}
	}
	
	//数组中交换两个值的位置
	public void exchangeElement(GeneralArray array,int index,int i){
		int value = array.array[index];
		for(int x = index;x>i;x--){
			array.array[x] = array.array[x-1];
		}
		array.array[i] = value;
	}
	
	//归并排序原理
	public GeneralArray merge(GeneralArray arrayA,GeneralArray arrayB,GeneralArray arrayC){
		int size = arrayA.nElems+arrayB.nElems;
		arrayC = new GeneralArray(size);
		int currentA = 0,currentB = 0,currentC = 0;
		while(currentA<arrayA.nElems && currentB < arrayB.nElems){
			if(arrayA.array[currentA]<arrayB.array[currentB]){
				arrayC.array[currentC++] =arrayB.array[currentB++];
			}else{
				arrayC.array[currentC++] =arrayA.array[currentA++];
			}
		}
		while(currentA<arrayA.nElems){
			arrayC.array[currentC++]=arrayA.array[currentA++];
		}
		while(currentB<arrayB.nElems){
			arrayC.array[currentC++]=arrayA.array[currentB++];
		}
		return arrayC;
	}
	
	public void mergeSort(GeneralArray array,int start,int end,GeneralArray temp){
		if(start == end){
			return;
		}else{
			int middle = (start+end)/2;
			mergeSort(array,start,middle,temp);
			mergeSort(array, middle+1, end,temp);
			merge(array, start, end,middle,temp);
		}
	}
	
	public void merge(GeneralArray array,int start,int end ,int middle,GeneralArray temp){
		int lowerIndex = start;
		int upperIndex = middle+1;
		int i = 0;
		while(lowerIndex<=middle && upperIndex <=end){
			if(array.array[lowerIndex]>array.array[upperIndex]){
				temp.array[i++] = array.array[upperIndex++];
			}else{
				temp.array[i++] = array.array[lowerIndex++];
			}
		}
		while(lowerIndex<=middle){              //后半段已空，则将前半段全部复制过来
			temp.array[i++] = array.array[lowerIndex++];
		}
		while(upperIndex<=end){             //前半段已空。
			temp.array[i++] = array.array[upperIndex++];
		}
		//把缓存的值赋值回来
		for(int j = 0 ;j<i;j++){
			array.array[start+j] = temp.array[j];
		}
	}
	
	
	//划分
	public int partion(GeneralArray array,int pivot){    // pivot作为枢纽值
		int start = -1;
		int end = array.nElems-1;
		
		int startIndex =start;
		int endIndex = end;
		while(true){
			while(startIndex <end && array.array[++startIndex]<pivot){
				;
			} //寻找左边最大值 
			while(endIndex >start && array.array[--endIndex]>pivot){
				;
			}   //寻找右边最小值
			if(startIndex<endIndex){
				 swap(array, startIndex, endIndex);
			}else{
				break;
			}
		}
		swap(array, startIndex, end);
		return startIndex;
	}
	
	//划分
	public int partion(GeneralArray array,int start,int end,int pivot){
		int startIndex =start-1;
		int endIndex = end;
		while(true){
			while(array.array[++startIndex]<pivot){   //不必要为startIndex限定范围
				;
			} //寻找左边最大值 
			while(endIndex > start && array.array[--endIndex]>pivot){    //不能划等于号，有可能导致--endIndex为-1而出错 
				;
			}   //寻找右边最小值
			if(startIndex<endIndex){
				swap(array,startIndex,endIndex);
			}else{
				break;
			}
		}
		swap(array,startIndex,end);
		return startIndex;
	}
	
	//由划分引出快速排序
	public void QuickSort(GeneralArray array,int start,int end){
		if(end-start<=0){
			return;
		}else{
			int pivot = array.array[end];
			int partion = partion(array, start, end, pivot);
			QuickSort(array, start, partion-1);
			QuickSort(array, partion+1, end); 

		}
	} 
//----------------------------------------------------------------------------------------//	
	//优化快速排序，当子数组小于3的时候，使用手动排序，同时使用三数据取中来平衡两边子数组
	//相比于一般排序，在划分的时候不用判断是否处于最右端
	public void QuickSort1(GeneralArray array,int start,int end){
		if(end-start<=2){
			manual(array,start,end);
		}else{
			int pivot = searchPivot(array,start,end);
			int partion = partion1(array, start, end, pivot);
			QuickSort1(array, start, partion-1);
			QuickSort1(array, partion+1,end);
		}
	}
	
	//划分
		public int partion1(GeneralArray array,int start,int end,int pivot){
			int startIndex =start;          //首位一定是三分划分的最小位，无需从start开始
			int endIndex = end-1;			//末位一定是最大位，所以也无需是写入
			while(true){
				while(array.array[++startIndex]<pivot){
					;
				} //寻找左边最大值 
				while(array.array[--endIndex]>pivot){
					;
				}   //寻找右边最小值
				if(startIndex<endIndex){
					swap(array,startIndex,endIndex);
				}else{
					break;
				}
			}
			swap(array,startIndex,end-1);
			return startIndex;
		}
	
	public int searchPivot(GeneralArray array,int start,int end){
		int middle= start+(end-start)/2;
		if(array.array[start]>array.array[middle]){
			swap(array,start,middle);
		};
		if(array.array[middle]>array.array[end]){
			swap(array,middle,end);
		};
		if(array.array[start]>array.array[end]){
			swap(array,start,end);
		};
		swap(array,middle,end-1);    //放在n-1位有特别的意思
		return array.array[end-1];
	}
	
	public void manual(GeneralArray array,int start,int end){
		if(end-start == 0){
			return;
		}else if(end-start == 1){
			if(array.array[start]>array.array[end]){
				swap(array,start,end);
			}
		}else{
			int middle = (end+start)/2;
			if(array.array[start]>array.array[middle]){
				swap(array,start,middle);
			};
			if(array.array[middle]>array.array[end]){
				swap(array,middle,end);
			};
			if(array.array[start]>array.array[end]){
				swap(array,start,end);
			};
		}
	}
	
	public void swap(GeneralArray array,int start,int end){
		int temp = array.array[start];
		array.array[start] = array.array[end];
		array.array[end] = temp;
	}
	
	
	//希尔排序
	public void shell(GeneralArray array){
		int gap = array.nElems/2;
		while(gap>0){
			for(int i = gap;i<array.nElems;i++ ){
				int k = i;
				while(k-gap>=0){
					if(array.array[k]<array.array[k-gap]){
						swap(array,k,k-gap);
					}
					k = k-gap;
				}
			}
			
			gap = gap/2;
		}
	}
	
}
