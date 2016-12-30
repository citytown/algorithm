package com.planone.test;

import org.junit.Test;

import com.planone.entity.Link;
import com.planone.entity.LinkList;

public class TestLink {

	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.insertFirst(1,1);
		list.insertFirst(2,2);
		list.insertFirst(3,3);
		list.insertFirst(4,4);
		list.displayLinkList();
		Link temp = list.delteOne(5);
		if(temp == null){
			System.out.println("链表中没有该键值对");
		}else{
			System.out.print("删除的结点是:");
			temp.displayLink();
		}
		list.displayLinkList();
	}
	
	@Test
	public void testInsertEnd(){
		LinkList list = new LinkList();
		list.insertEnd(1,1);
		list.insertEnd(2,2);
		list.insertEnd(3,3);
		list.insertEnd(4,4);
		list.insertEnd(5,5);
		list.displayLinkList();
		
	}
}
