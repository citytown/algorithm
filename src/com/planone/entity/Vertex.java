package com.planone.entity;

/*
 * 图的顶点定义
 */
public class Vertex {
	
	public int index;
	public String label;
	public boolean visited;
	
	public Vertex(String label) {
		super();
		this.label = label;
		this.visited = false;
	}


}
