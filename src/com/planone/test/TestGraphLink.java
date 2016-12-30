package com.planone.test;

import com.planone.entity.GraphLink;
import com.planone.entity.Link;

/**
 * 测试邻接表的图
 * @author citytown
 *
 */
public class TestGraphLink {
	public static void main(String[] args) {
		GraphLink graphLink = new GraphLink();
		graphLink.insert(graphLink.arrayLinkList[0],new Link(1, 1));
		graphLink.insert(graphLink.arrayLinkList[0],new Link(2, 2));
		graphLink.insert(graphLink.arrayLinkList[0],new Link(4, 4));
		graphLink.insert(graphLink.arrayLinkList[0],new Link(3, 3));
		graphLink.display(graphLink.arrayLinkList[0]);
	}
}
