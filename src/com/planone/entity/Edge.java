package com.planone.entity;

/**
 * 带权图的边的定义
 * @author citytown
 *
 */
public class Edge {
	public Vertex srcVertex;//起始点
	public Vertex destVertex;//终点
	public int distance;//两点之间的权值
	
	
	public Edge(Vertex srcVertex, Vertex destVertex, int distance) {
		super();
		this.srcVertex = srcVertex;
		this.destVertex = destVertex;
		this.distance = distance;
	}
	
	
	
}
