import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;


class Tourist {
	static HashMap<String,Vertex> vertices;
	static HashMap<String,Edge> edges;
	public static void main(String[] args) throws FileNotFoundException{
		//Scanner in=new Scanner(System.in);
		Scanner in=new Scanner(new File("tourist.txt"));
		PrintWriter out=new PrintWriter(System.out);
		int cases=0;
		while(true){
			int n=in.nextInt();
			int r=in.nextInt();
			if(n==0&&r==0){
				break;
			}
			vertices=new HashMap<String,Vertex>();
			edges=new HashMap<String,Edge>();
			for(int i=0; i<r; i++){
				String start=in.nextInt()+"";
				String end=in.nextInt()+"";
				int capacity=in.nextInt();
				if(!vertices.containsKey(start)){ //see if it contains the start node
					Vertex a=new Vertex(start);
					vertices.put(start, a);
				}
				if(!vertices.containsKey(end)){ //see if it contains the end node
					Vertex b=new Vertex(end);
					vertices.put(end, b);
				}
				Edge v1=new Edge(capacity,vertices.get(start),vertices.get(end));
				Edge v2=new Edge(capacity,vertices.get(end),vertices.get(start));
				vertices.get(start).connected.add(end);
				vertices.get(end).connected.add(start);
				if(!edges.containsKey(start+end)){
					edges.put(start+end, v1);
				}
				if(!edges.containsKey(end+start)){
					edges.put(end+start, v2);
				}
			}
			String s=in.nextInt()+"";
			String d=in.nextInt()+"";
			int t=in.nextInt();
			boolean pathExists=true;
			int min=Integer.MAX_VALUE;
			while(pathExists){ //takes out min edges until no path exists
				int minTemp=Integer.MAX_VALUE;
				String minEdge="";
				for(Edge e: edges.values()){
					if(e.length<minTemp){
						minTemp=e.length;
						minEdge=e.id;
					}
				}
				Edge tempEdge=edges.get(minEdge);
				vertices.get(tempEdge.start.id).connected.remove(vertices.get(tempEdge.end.id).id);
				vertices.get(tempEdge.end.id).connected.remove(vertices.get(tempEdge.start.id).id);
				edges.remove(minEdge);
				edges.remove(tempEdge.end.id+""+tempEdge.start.id);
				Queue<String> line=new ArrayDeque<String>();
				ArrayList<String>visited=new ArrayList<String>();
				line.add(s);
				visited.add(s);
				while(true){
					if(min==20){
						System.out.println(line);
						System.out.println(line.peek()+" equals "+d);
					}
					if(minTemp==30){
						System.out.println(line);
					}
					if(line.size()==0){ 
						pathExists=false;
						break;
					}
					if(line.peek().equals(d)){
						if(min==20)
							System.out.println("TRUE!!!");
						break;
					}
					String current=line.poll();
					visited.add(current);
					for(String temp: vertices.get(current).connected){
						if(!visited.contains(temp)&&!line.contains(temp))
							line.add(temp);
					}
				}
				if(!pathExists)
					min=minTemp;
			}
			min-=1;
			out.println("Scenario #"+(cases+1));
			if((double)t/min-t/min!=0){
				out.println("Minimum Number of Trips = "+((t/min)+1));
			}
			else{
				out.println("Minimum Number of Trips = "+(t/min));
			}
			cases++;
		}
		out.flush();
		out.close();
	}
}
class Edge{
	String id;
	int length; //MAX FLOW
	int flow; //CURRENT FLOW
	Vertex start;
	Vertex end;
	public Edge(int length, Vertex start, Vertex end){
		this.id=start.id+end.id;;
		this.length=length;
		this.start=start;
		this.end=end;
		flow=length;
	}
	public String toString(){
		return start+","+end;
	}
	public boolean equals(Edge e){
		return e.start.equals(start)&&e.end.equals(end);
	}
}
class Vertex{
	String id;
	ArrayList<String>connected;
	boolean visited;
	int distance;
	public Vertex(String id){
		this.id=id;
		connected=new ArrayList<String>();
		visited=false;
	}
	public String toString(){
		return id;
	}
	public boolean equals(Vertex v){
		return id.equals(v.id);
	}
}
