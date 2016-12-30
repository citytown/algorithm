package com.planone.test;

import com.planone.entity.CharStack;

public class StringRev {

	public String reverse(String input){
		String out="";
		CharStack  stack = new CharStack(input.length());
		for(int i=0;i<input.length();i++){
			if(!stack.isFull()){
				stack.push(input.charAt(i));
			}
		}
		while(!stack.isEmpty()){
			char temp=stack.pop();
			out = out+temp;
		}
		return out;
	}
}
