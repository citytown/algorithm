package com.planone.entity;

/**
 * 使用邻接表的方式来创建图
 * @author citytown
 *
 */
public class GraphLink {

	private final static int MAXSIZE = 6;
	public LinkList[] arrayLinkList;
	
	public GraphLink(){
		arrayLinkList = new LinkList[MAXSIZE];
		for(int i =0;i<MAXSIZE;i++){
			arrayLinkList[i].first = new Link(i, i);
		}
	}
	
	public void  insert(LinkList linkList,Link link){
		linkList.insertWithHead(link); 
	}
	
	public void display(LinkList linkList){
		linkList.displayLinkList();
	}
}
