package com.planone.entity;

public class Link {

	public int key;
	public int value;
	public Link next;
	
	public Link(int key,int value) {
		this.key = key;
		this.value = value;
	}
	
	public void displayLink(){
		System.out.print("{"+key+","+value+"}");
	}
	
}
