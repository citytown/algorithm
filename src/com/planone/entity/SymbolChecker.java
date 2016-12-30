package com.planone.entity;

/*
 * 利用栈检查符号是否正常
 */

public class SymbolChecker {

	//检查符号是否正常
	public boolean check(CharStack stack,String str){
		for(int i=0;i<str.length();i++){
			char temp = str.charAt(i);
			switch (temp) {
			case '{':
			case '(':
			case '[':
				if(!stack.isFull()){					
					stack.push(temp);
					break;
				}else{
					System.out.println("栈满，出现无法插入！");
					return false;
				}
			case '}':
			case ')':
			case ']':
				if(stack.isEmpty()){
					System.out.println("栈为空，当前出现错误的位置："+(i+1)+"位!");
					return false;
				}
				if((temp == '}'&& stack.peak() == '{') || (temp == ')'&& stack.peak() == '(')
						|| (temp == ']'&& stack.peak() == '[')){
					stack.pop();
					break;
				}else{
					System.out.println("符号匹配出现错误，错误的位置在第"+(i+1)+"位");
					return false;
				}
			}
		}
		if(stack.isEmpty()){
			System.out.println("全部匹配正确！");
			return true;
		}else{
			System.out.println("最后一行符号填写完整！");
			return false;
		}
	} 	
}
