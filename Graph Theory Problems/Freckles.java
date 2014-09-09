import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Freckles {
	static int[] array = null;
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in=new Scanner(new File("freckle.txt"));
		int C=in.nextInt();
		for(int i=0; i<C; i++){
			ArrayList<Freckle> fList=new ArrayList<Freckle>();
			ArrayList<FreckleEdge> eList=new ArrayList<FreckleEdge>();
			ArrayList<FreckleEdge> mst=new ArrayList<FreckleEdge>();
			int n=in.nextInt();
			array=new int[n];
			Arrays.fill(array, -1);
			for(int j=0; j<n; j++){
				Freckle temp=new Freckle(in.nextDouble(),in.nextDouble(),j);
				if(!fList.contains(temp))
					fList.add(temp);
			}
			for(Freckle f: fList){
				for(Freckle o: fList){
					if(f.equals(o))
						continue;
					eList.add(new FreckleEdge(f,o));
					eList.add(new FreckleEdge(o,f));
				}
			}
			Collections.sort(eList);
			double sum=0;
			for(FreckleEdge f: eList){
				if(find(f.a.n)!=find(f.b.n)){
					mst.add(f);
					sum+=f.distance;
					union(find(f.a.n),find(f.b.n));
				}
			}
			System.out.printf("%.2f",sum);
			System.out.println("\n");
		}
	}
	public static int find(int n){
		if(array[n]<0){
			return n;
		}
		return find(array[n]);
	}
	public static void union(int a, int b){
		if(array[a]<array[b]){
			array[a]+=array[b];
			array[b]=a;
		}
		else{
			array[b]+=array[a];
			array[a]=b;
		}
	}
}
class Freckle{
	double x;
	double y;
	int n;
	public Freckle(double x, double y, int n){
		this.x=x;
		this.y=y;
		this.n=n;
	}
	@Override
	public boolean equals(Object o){
		Freckle o2 = (Freckle) o;
		return this.x==o2.x&&this.y==o2.y;
	}
	public String toString(){
		return "("+x+","+y+")"+n;
	}
}
class FreckleEdge implements Comparable<FreckleEdge>{
	Freckle a;
	Freckle b;
	double distance;
	public FreckleEdge(Freckle a, Freckle b){
		this.a=a;
		this.b=b;
		distance=(Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y, 2)));
	}
	public int compareTo(FreckleEdge o){
		if(distance-o.distance>0)
			return 1;
		if(distance-o.distance<0)
			return -1;
		else
			return 0;
	}
	public String toString(){
		return a+" to "+b+" distance "+distance;
	}
}
