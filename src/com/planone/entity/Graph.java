package com.planone.entity;

import java.util.Map;

public class Graph {

	private final static int MAX_SIZE = 20;
	private Vertex[] vertexsList ;	//顶点数组
	private int[][] adjMat;		//定义顶点之间的边
	private int vertexsSize;  //顶点个数
	
	public Graph(){
		vertexsList = new Vertex[MAX_SIZE];
		adjMat = new int[MAX_SIZE][MAX_SIZE];
		for(int i=0;i<MAX_SIZE;i++){
			for(int j = 0;j<MAX_SIZE;j++){
				adjMat[0][0]=0;
			}
		}
	}
	
	public void addVertex(String label){    //增加顶点
		vertexsList[vertexsSize++] = new Vertex(label);
	}
	
	public void addEdge(int start,int end){		//增加边
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void displayVertex(int index){        //显示顶点信息
		System.out.print(vertexsList[index].label);
	}
	
	//获取某一个结点的邻近结点
	public int getAdjVertex(int index){
		for(int i = 0;i<vertexsSize;i++){
			if(adjMat[index][i] == 1 & vertexsList[i].visited == false){
				return i;
			}
		}
		return -1;
	}
	
	//深度优先遍历搜索，不存在孤立结点的情况下
	public void dfs(){
		Stack stack = new Stack(MAX_SIZE);
		vertexsList[0].visited = true;
		displayVertex(0);
		stack.push(0);
		while(!stack.isEmpty()){
			int adjVertex = getAdjVertex(stack.peak());  //获取其邻接相邻节点
			if(adjVertex == -1){
				stack.pop();
			}else{
				vertexsList[adjVertex].visited = true;
				displayVertex(adjVertex);
				stack.push(adjVertex);
			}
		}
		for(int i=0;i<vertexsSize;i++){   //重新设置回为最初状态
			vertexsList[i].visited = false;
		}
	}
	//广度优先搜索，不存在孤立结点的情况下
	public void bfs(){
		Queue queue = new Queue(MAX_SIZE);
		vertexsList[0].visited = true;
		queue.insert(0);
		displayVertex(0);
		while(!queue.isEmpty()){
			int adjVertex = getAdjVertex(queue.peekFront());//判断当前元素是否还有邻接结点，没有则出队，有则邻接结点进队
			if(adjVertex == -1){
				queue.remove();
			}else{
				vertexsList[adjVertex].visited = true;
				displayVertex(adjVertex);
				queue.insert(adjVertex);
			}
		}
		for(int i=0;i<vertexsSize;i++){   //重新设置回为最初状态
			vertexsList[i].visited = false;
		}
	}
	
	//无向图最小生成树，按深度优先
	public void miniSpanTree(){
		Stack stack = new Stack(MAX_SIZE);
		vertexsList[0].visited = true;
		stack.push(0);
		while(!stack.isEmpty()){
			int currentVertex = stack.peak();
			int adjVertex = getAdjVertex(stack.peak());
			if(adjVertex == -1){
				stack.pop();
			}else{
				vertexsList[adjVertex].visited = true;
				displayVertex(currentVertex);
				displayVertex(adjVertex);
				System.out.println("   ");
				stack.push(adjVertex);
			}
		}
		for(int i=0;i<vertexsSize;i++){   //重新设置回为最初状态
			vertexsList[i].visited = false;
		}
	}
	
	//是否有办法可以列举出所有的最小生成树
	
	public void addDirectedEdge(int start,int end){
		adjMat[start][end] = 1;
	}
	
	//测试图的连通性
	public void connecticity(int index){
		Stack stack = new Stack(MAX_SIZE);
		stack.push(index);
		vertexsList[index].visited = true;
		displayVertex(index);
		while(!stack.isEmpty()){
			int adjVertex = getAdjVertex(stack.peak());
			if(adjVertex == -1){
				stack.pop();
			}else{
				displayVertex(adjVertex);
				vertexsList[adjVertex].visited = true;
				stack.push(adjVertex);
			}
		}
	}
	
	
	//有向图的拓扑排序
	public void topo(){
		int sumSizes = vertexsSize;
		String[] sortArray = new String[sumSizes];
		int currentVertex;
		while(vertexsSize>0){
			currentVertex = noSuccessor();
			if(currentVertex == -1){
				System.out.println("必须存在拓扑结构");
				return ;
			}
			sortArray[vertexsSize-1] = vertexsList[currentVertex].label;
			deleteVertex(currentVertex);
		}
		
		//对拓扑排序进行输出
		for(int i = 0 ;i<sortArray.length;i++){
			System.out.print(sortArray[i]+"  ");
		}
	}
	
	//寻找没有后继节点的点
	public int noSuccessor(){
		boolean isEdge;
		for(int i = 0;i<vertexsSize;i++){
			isEdge = true;
			for(int j  = 0;j<vertexsSize;j++){
				if(adjMat[i][j] == 1){
					isEdge = false;
					break;
				}
			}
			if(isEdge){
				return i;
			}
		}
		return -1;
	}
	
	public void deleteVertex(int delVertex){
		if(delVertex<vertexsSize-1){
			for(int index = delVertex;index<vertexsSize-1;index++){
				vertexsList[index] = vertexsList[index+1];
			}
			vertexsList[vertexsSize] = null;	//回收该数组元素
			for(int row =delVertex;row<vertexsSize-1;row++){    //注意vertexSize-1，而不使用vertexSize，因为下面有用到row+1；
				upRow(row,vertexsSize);
			}
			for(int col = delVertex;col<vertexsSize-1;col++){
				leftCol(col,vertexsSize-1);
			}
		}
		vertexsSize--;
	}
	
	public void upRow(int row,int length){
		for(int col = 0;col<length;col++){
			adjMat[row][col] = adjMat[row+1][col];
		}
	}
	
	public void leftCol(int col,int length){
		for(int row = 0;row<length;row++){
			adjMat[row][col] = adjMat[row][col+1];
		}
	}
}
