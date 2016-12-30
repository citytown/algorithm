package com.planone.entity;

/**
 * 汉诺塔问题
 * @author citytown
 *
 */
public class Hanoi {
	public void hanoiSort(int sum,String a,String b,String c){
		if(sum == 1){
			System.out.println(a+"——>"+c);
		}else{
			hanoiSort(sum-1, a, c, b);
			System.out.println(a+"——>"+c);
			hanoiSort(sum-1, b, a, c);
		}
	}
}
