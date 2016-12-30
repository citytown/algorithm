package com.planone.entity;

/**
 * 边的优先级队列的操作
 * @author citytown
 *
 */
public class EdgePriQueue {
	private final static int MAXSIZE = 20;
	public Edge[] edgePQ;
	public int size;
	
	
	public EdgePriQueue() {
		edgePQ = new Edge[MAXSIZE];
		size = 0;
	}
	
	public void insert(Edge edge){
		if(isEmpty()){
			edgePQ[size++] = edge;
		}else{
			int i;
			for(i = size-1;i>=0;i--){
				if(edge.distance>edgePQ[i].distance){
					edgePQ[i+1] = edgePQ[i];
				}else{
					break;
				}
			}
			edgePQ[++i] = edge;
			size++;
		}
	}
	
	public boolean isEmpty(){
		return size<1;
	}
	
	public Edge removeMin(){
		return edgePQ[size--];
	}
	
	public int findByDestVertex(Vertex vertext){
		for(int i=0;i<size;i++){
			if(edgePQ[i].equals(vertext)){
				return i;
			}
		}
		return -1;
	}
	
	public Edge findByIndex(int index){
		return edgePQ[index];
	}
	
	public Edge removeByIndex(int index){
		Edge edge = edgePQ[index];
		for(int i=index;i<edgePQ.length-1;i++){
			edgePQ[i] = edgePQ[i+1];
		}
		return edge;
	}
}
