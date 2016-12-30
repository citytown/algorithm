package com.planone.entity;

/**
 * 无向带权图的操作
 * @author citytown
 *
 */
public class GraphW {
	private final static int INFINITY = 1000000; 
	private final static int MAXSIZE = 20;
	public Vertex[] vertextList;
	public int[][] matrix;
	public EdgePriQueue priQueue;
	
	public GraphW(){
		vertextList = new Vertex[MAXSIZE];
		matrix = new int[MAXSIZE][MAXSIZE];
		for(int i=0;i<MAXSIZE;i++){
			for(int j=0;j<MAXSIZE;j++){
				matrix[i][j] = INFINITY;
			}
		}
		priQueue = new EdgePriQueue();
	}
	
	//无向带权图产生最小生成树
	public void mstw(){
		int currentIndex = 0;
		int visitCount = 1;
		while (visitCount < vertextList.length) {
			vertextList[currentIndex].visited = true;
			visitCount++;
			for (int i = 0; i < vertextList.length; i++) {
				if (vertextList[i].equals(currentIndex) || (vertextList[i].visited == true)) {
					continue;
				}
				int distance = matrix[vertextList[currentIndex].index][vertextList[i].index];
				pushPQ(vertextList[currentIndex], vertextList[i], distance);
				if (!priQueue.isEmpty()) {
					Edge edge = priQueue.removeMin();
					Vertex srcVertex = edge.srcVertex;
					Vertex destVertex = edge.destVertex;
					destVertex.visited = true;
					System.out.print(" " + srcVertex + destVertex);
					currentIndex = edge.destVertex.index;
				} else {
					System.out.println("the graphic isn't connect!");
					return;
				}
			}
		}
		
		//遍历完整时，把所有节点状态复位
		for(int i = 0;i<vertextList.length;i++){
			vertextList[i].visited = false;
		}
	}
	
	public void pushPQ(Vertex srcVertex,Vertex destVertex,int distance){
		int index = priQueue.findByDestVertex(destVertex);
		if(index == -1){
			priQueue.insert(new Edge(srcVertex,destVertex,distance));
		}else{
			Edge edge = priQueue.findByIndex(index);
			if(edge.distance >distance){
				priQueue.removeByIndex(index);
			}
		}
	}
}
