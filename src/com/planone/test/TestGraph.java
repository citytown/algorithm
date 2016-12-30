package com.planone.test;

import org.junit.Test;

import com.planone.entity.Graph;

public class TestGraph {

	@Test
	public void testDFSAndBFS(){
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");
		
		graph.addEdge(0,3);
		graph.addEdge(3,6);
		graph.addEdge(6,7);
		graph.addEdge(1,4);
		graph.addEdge(6,4);
		graph.addEdge(2,5);
		graph.addEdge(5,7);
		
		System.out.print("Visit by DFS:");
		graph.dfs();
		//graph.bfs();
	}
	
	/**
	 * 测试生成无向图最小生成树
	 */
	@Test
	public void testMiniSpanTree(){
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(1,3);
		graph.addEdge(2,4);
		graph.addEdge(0,3);
		graph.addEdge(0,4);
		graph.addEdge(3,4);
		graph.addEdge(1,2);
		graph.addEdge(1,4);
		graph.addEdge(2,3);
		graph.miniSpanTree();
	}
	
	/**
	 * 测试有向图的拓扑的顺序
	 */
	@Test
	public void testTopo(){
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");
		graph.addDirectedEdge(0,3);
		graph.addDirectedEdge(3,6);
		graph.addDirectedEdge(6,7);
		graph.addDirectedEdge(1,4);
		graph.addDirectedEdge(4,6);
		graph.addDirectedEdge(2,5);
		graph.addDirectedEdge(5,7);
		System.out.println("拓扑结构：");
		graph.topo();

	}
}
