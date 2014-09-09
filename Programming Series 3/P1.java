import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class P1{
	public static void main(String[] args) throws FileNotFoundException{
		PrintWriter out=new PrintWriter(System.out);
		Scanner in=new Scanner(System.in);
		//Scanner in=new Scanner(new File("1.txt"));
		int N=in.nextInt();
		for(int i=0; i<N; i++){
			int T=in.nextInt();
			ArrayList<Coor> tList=new ArrayList<Coor>();
			ArrayList<Coor> cList=new ArrayList<Coor>();
			for(int j=0; j<T; j++){
				tList.add(new Coor(in.nextDouble(),in.nextDouble()));
			}
			int C=in.nextInt();
			for(int j=0; j<C; j++){
				cList.add(new Coor(in.nextDouble(),in.nextDouble()));
			}
			int count=0;
			for(Coor person: cList){
				for(Coor trib: tList){
					if(person.danger(trib)){
						count++;
						break;
					}
				}
			}
			out.println("Case "+(i+1)+". Crewmate(s) in danger: "+count);
		}
		out.flush();
		out.close();
	}
}
class Coor{
	double x;
	double y;
	public Coor(double x, double y){
		this.x=x;
		this.y=y;
	}
	public boolean danger(Coor temp){
		Double distance=Math.sqrt(Math.pow(x-temp.x,2)+Math.pow(y-temp.y, 2));
		return distance<5;
	}
}