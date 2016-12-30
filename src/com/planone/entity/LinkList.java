package com.planone.entity;

public class LinkList {

	public Link first;
	
	public LinkList(){
		this.first = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	//无首结点的头插法
	public void insertFirst(int key,int value){
		Link link = new Link(key, value);
		link.next = first;
		first = link;
	}
	
	//无首结点的尾插法
	public void insertEnd(int key,int value){
		Link link = new Link(key, value);
		
	}
	
	//有首结点的头插法和尾插法
	public void insertWithHead(Link link){
		if(isEmpty()){
			first.next = link;
		}else{
			link.next = first.next;
			first.next = link;
		}
	}
	
	public Link deleteFirst(){
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	//删除指定的结点
	public Link delteOne(int key){
		Link currenLink = first;
		Link preLink = first;
		while(currenLink != null){
			if(currenLink.key == key){
				preLink.next = currenLink.next;
				currenLink = currenLink.next;
				return currenLink;
			}else{
				preLink = currenLink;
				currenLink = currenLink.next;
			}
		}
		return null;
	}
	
	//寻找指定的结点
	public Link findOne(int key){
		Link currenLink = first;
		while(currenLink != null){
			if(currenLink.key == key){
				return currenLink;
			}else{
				currenLink = currenLink.next;
			}
		}
		return null;
	}
	
	
	public void displayLinkList(){
		System.out.println("Start to list the link:");
		Link currentLink = first;
		while(currentLink != null){
			currentLink.displayLink();
			currentLink = currentLink.next;
			System.out.print("-->");
		}
		System.out.print("linkList is end!");
		System.out.println();
	}
}
