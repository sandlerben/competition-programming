import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class problem2{
	public static void main(String[] args) throws FileNotFoundException{
		//Scanner in=new Scanner(System.in);
		Scanner in=new Scanner(new File("2.txt"));
		int c=in.nextInt();
		in.nextLine();
		for(int i=0; i<c; i++){
			char[] moves=in.nextLine().toCharArray();
			ArrayList<Coordinate> cList=new ArrayList<Coordinate>();
			cList.add(new Coordinate(0,0));
			Coordinate last=cList.get(0);
			boolean intersect=false;
			for(char k: moves){
				Coordinate next=null;
				if(k=='U'){
					next=new Coordinate(last.x,last.y+1);
					if(has(next,cList)){
						intersect=true;
						break;
					}
					cList.add(next);
					last=next;
				}
				if(k=='R'){
					next=new Coordinate(last.x+1,last.y);
					if(has(next,cList)){
						intersect=true;
						break;
					}
					cList.add(next);
					last=next;	
				}
				if(k=='D'){
					next=new Coordinate(last.x,last.y-1);
					if(has(next,cList)){
						intersect=true;
						break;
					}
					cList.add(next);
					last=next;	
				}
				if(k=='L'){
					next=new Coordinate(last.x-1,last.y);
					if(has(next,cList)){
						intersect=true;
						break;
					}
					cList.add(next);
					last=next;	
				}
			}
			if(intersect){
				System.out.println("Waaaaaaaah");
			}
			else{
				System.out.println("I'm the best!");
			}
		}
	}
	public static boolean has(Coordinate c, ArrayList<Coordinate> cList){
		for(Coordinate k: cList){
			if(k.x==c.x&&k.y==c.y){
				return true;
			}
		}
		return false;
	}
}
class Coordinate{
	int x;
	int y;
	public Coordinate(int x, int y){
		this.x=x;
		this.y=y;
	}
	public boolean equals(Coordinate other){
		return this.x==other.x&&this.y==other.y;
	}
}
