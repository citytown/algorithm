package com.planone.test;

import java.util.Random;

import com.planone.entity.OrderedArray;

public class TestOrderedArray {

	public static void main(String[] args) {
		OrderedArray array = new OrderedArray(10);
		
		for(int i=0;i<10;i++){
			int value = new Random().nextInt(19+1);
			array.insert(value);
		}
		array.display();
		array.find(12);
		array.insert(30);
		array.display();
		array.delete(15);
		array.delete(30);
		array.display();
		
	}
}
