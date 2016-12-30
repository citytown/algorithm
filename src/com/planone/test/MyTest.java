package com.planone.test;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.Test;

import com.planone.entity.CharStack;
import com.planone.entity.Hanoi;
import com.planone.entity.SymbolChecker;

public class MyTest{
	
	/*
	 * 检查符号是否匹配
	 */
	@Test
	public void testSymbol(){
		CharStack stack = new CharStack(15);
		SymbolChecker check = new SymbolChecker();
		System.out.println("请输入你要匹配的字符串：");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		check.check(stack, str);
	}
	
	@Test
	public void testLinkedStack(){
		LinkedList<String> list = new LinkedList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		for(String temp:list){
			System.out.println(temp);
		}
		
	}
	
	@Test
	/**
	 * 测试汉诺塔问题
	 */
	public void testHanoi(){
		/*Hanoi hanoi = new Hanoi();
		hanoi.hanoiSort(3, "第一个盘子", "第二个盘子", "第三个盘子");*/
		String a = "    bbbb    ";
		if(a.trim().length()>1){
			System.out.println(a.length());
		}
	}
}
