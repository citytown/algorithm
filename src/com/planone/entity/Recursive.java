package com.planone.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于递归函数的几个问题解法
 * @author citytown
 *
 */
public class Recursive {

	/**
	 * 求一个数的乘方
	 */
	
	public int Involution(int buttom,int top){
		if(buttom == 0 && top == 0){
			System.out.println("mistake");
			return -1;
		}
		if((buttom ==0 && top !=0) || (buttom!=0 && top==0)){
			return 1;
		}
		int result = 0;
		if(top/2 == 1){
			result = buttom * buttom;
		}else{
			result = Involution(buttom,top/2)*Involution(buttom,top/2);
		}
		if(top%2 == 1){
			result = result *buttom;
		}
		return result;
		
	}
	
	/**
	 * 背包问题的迭代方法和非迭代方法
	 */
	public  List<Integer> backQuestion(List<Integer> array,int index,int result){
		List<Integer> fitArray = new ArrayList<>();
		int temp = result;
		for(int i= index;i<array.size();i++){
			temp  = temp - array.get(i);
			if(temp >0){
				fitArray.add(array.get(i));
			}else if(temp == 0){
				fitArray.add(array.get(i));
				return fitArray;
			}else{
				return backQuestion(array, index+1, result);
			}
		}
		return null;
	}
	
	
	/**
	 * 排队组合问题，不计顺序，递归与非递归
	 */
	public void swap(int i,int j){
		int temp = j;
		j= i;
		i = temp;
	}
}
