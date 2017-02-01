package irrigationSystem;

public class mstDemo 
{

	private static final int V=11;

	int findMinKey(int key[],Boolean mstSet[]){
		int minValue=Integer.MAX_VALUE;
		int index=-1;

		for(int i=0;i<V;i++){
			if((mstSet[i]==false)&&(key[i]<minValue)){
				minValue=key[i];
				index=i;
			}
		}

		return index;
	}

	void printMst(int parentIndex[],int graph[][])
	{
		System.out.println("Edge Weight");
		for(int i=1;i<V;i++){
			System.out.println(parentIndex[i] + "-" + i + "  " + graph[i][parentIndex[i]]);
		}
	}

	//ADJACENCY MATRIX
	void primMST(int graph[][]){
		int parent[]=new int[V];
		int key[]=new int[V];
		Boolean mstSet[]=new Boolean[V];

		for(int i=0;i<V;i++){
			key[i]=Integer.MAX_VALUE;
			mstSet[i]=false;
		}

		key[0]=0;
		parent[0]=-1;

		for(int i=0;i<V-1;i++){

			int index=findMinKey(key, mstSet);			
			mstSet[index]=true;

			for(int j=0;j<V;j++){
				if((graph[index][j]!=0)&&(mstSet[j]==false)&&(graph[index][j]<key[j])){
					parent[j]=index;
					key[j]=graph[index][j];
				}
			}
		}

		printMst(parent, graph);
	}

	public static void main(String[] args) 
	{

		mstDemo m=new mstDemo();

		int graph[][]=new int[][]{{0,4,5,5,1,1,4,5,4,1,1},
			{4,0,3,4,1,2,0,0,0,0,0},
			{5,3,0,4,1,2,0,0,0,0,0},
			{5,4,4,0,2,1,0,0,0,0,0},
			{1,1,1,2,0,1,0,0,0,0,0},
			{1,2,2,1,1,0,0,0,0,0,0},
			{4,0,0,0,0,0,0,4,5,3,4},
			{5,0,0,0,0,0,4,0,3,3,2},
			{4,0,0,0,0,0,5,3,0,2,1},
			{1,0,0,0,0,0,3,3,2,0,3},
			{1,0,0,0,0,0,4,2,1,3,0},
		};

		m.primMST(graph);               
	}

}