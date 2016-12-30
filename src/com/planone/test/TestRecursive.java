package com.planone.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.planone.entity.Recursive;

/**
 * 测试递归函数三个小问题
 * @author citytown
 *
 */
public class TestRecursive {

	//一个数的n乘方问题
	@Test
	public void testInvolution(){
		Recursive recursive = new Recursive();
		int result = recursive.Involution(2,10);
		System.out.println(result);
	}
	
	@Test
	public void testBackQuestion(){
		Recursive recursive = new Recursive();
		List<Integer> resourceArray = new ArrayList<>();
		resourceArray.add(9);
		resourceArray.add(4);
		resourceArray.add(5);
		resourceArray.add(7);
		resourceArray.add(8);
		List<Integer> fitArray = new ArrayList<>();
		fitArray = recursive.backQuestion(resourceArray, 0, 20);
		System.out.println(fitArray.size());
		int i=0,j=12;
		recursive.swap(i,j);
		System.out.println(j);
		
	}
}
