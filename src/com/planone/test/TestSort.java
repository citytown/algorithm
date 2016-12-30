package com.planone.test;


import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

import com.planone.entity.BinaryArray;
import com.planone.entity.GeneralArray;
import com.planone.entity.OrderedArray;
import com.planone.entity.SortAlgorithm;
import com.planone.entity.Stack;
import com.planone.util.quickSort;

public class TestSort {
    
	@Test
	public void testAllSort(){
		GeneralArray array = new GeneralArray(100,100);
		
		for(int i=0;i<100;i++){
			array.insert(new Random().nextInt(10));
		}
		array.display();
		//SortAlgorithm algorithm = new SortAlgorithm();
		//SimpleDateFormat sdf = new SimpleDateFormat("YYY-mm-DD hh:mm:ss");
		//String starttime = sdf.format(new Date());
		//System.out.println("开始时间是："+starttime);
		//algorithm.bubblesort(array);
		//algorithm.selectSort(array);
		//algorithm.insertSort(array);
		//algorithm.otherInsertSort(array);
		//String endtime = sdf.format(new Date());
		//System.out.println("结束时间是："+endtime);
		//删除重复项
		array.noDup2();
		array.display();
	}
	
	@Test
	public void testBinarySearch(){
		OrderedArray array = new OrderedArray(10);
		for(int i=0;i<10;i++){
			array.insert(new Random().nextInt(10));
		}
		array.display();
		//非迭代方法查找
		//array.Search(8);
		//迭代方法查找
		int index = array.iterateSearch(0, array.getnElems(),5);
		if(index==-1){
			System.out.println("该数组没有可以寻找的值");
		}else{
			System.out.println("该值在数组中的第"+index+"位！");
		}
	}
	
	/**
	 * 测试使用二分法进行插入，删除，查找
	 */
	@Test
	public void testBinaryArray(){
		BinaryArray array = new BinaryArray(10);
		for(int i=0;i<10;i++){
			array.insert(new Random().nextInt(50));
		}
		
		array.display();
	}
	
	/**
	 * 测试栈
	 */
	@Test
	public void testStack(){
		Stack stack = new Stack(10);
		for(int i=0;i<10;i++){
			if(!stack.isFull()){
				stack.push(new Random().nextInt(50));
			}
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+"  ");
		}
	}
	
	/**
	 * 测试字母倒序
	 */
	@Test
	public void testRev(){
		System.out.print("请输入一行字母：");
		Scanner scanner = new Scanner(System.in);
		String input =scanner.nextLine();
		StringRev rev = new StringRev();
		String output = rev.reverse(input);
		System.out.print("反序后的单词为：");
		System.out.println(output);
	}
	
	
	@Test
	//测试归并排序
	public void testMergeSort(){
		GeneralArray array = new GeneralArray(16);
		GeneralArray temp = new GeneralArray(16);
		for(int i = 0;i<15;i++){
			array.insert((int) (Math.random()*100+1));
		}
		array.display();
		SortAlgorithm sort = new SortAlgorithm();
		//GeneralArray sortArray = new GeneralArray(array.nElems);
		sort.mergeSort(array, 0, array.nElems-1,temp);
		array.display();
	}
	
	//测试划分
	@Test
	public void testPartion(){
		GeneralArray array = new GeneralArray(16);
		array.insert(1);
		array.insert(3);
		array.insert(11);
		array.insert(7);
		array.insert(9);
		array.insert(2);
		array.insert(4);
		array.insert(6);
		array.insert(8);
		array.insert(10);
		array.insert(5);
		array.insert(5);
		array.display();
		SortAlgorithm sort = new SortAlgorithm();
		int index = sort.partion(array, 5);
		array.display();
		System.out.println("index is:"+index);
	}
	
	@Test
	//测试快速排序
	public void testQuickSort(){
		GeneralArray array = new GeneralArray(50);
		for(int i = 0;i<30;i++){
			array.insert((int) (Math.random()*100+1));
		}
		array.display();
		SortAlgorithm sort = new SortAlgorithm();
		sort.QuickSort(array, 0, array.nElems-1);
		//sort.QuickSort1(array, 0, array.nElems-1);
		array.display();
	}
	
	//测试希尔排序
	@Test
	public void testShellSort(){
		GeneralArray array = new GeneralArray(50);
		for(int i = 0;i<50;i++){
			array.insert((int) (Math.random()*100+1));
		}
		array.display();
		SortAlgorithm sort = new SortAlgorithm();
		sort.shell(array);
		array.display();
	}
	
}
