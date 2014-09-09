import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;


class Graph {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br=new BufferedReader(new FileReader(new File("birthday.txt")));
		PrintWriter out=new PrintWriter(System.out);
		while(true){
			int N=Integer.parseInt(br.readLine());
			if(N==0){
				break;
			}
			Coordinate[] cList=new Coordinate[N*2];
			for(int i=0; i<(2*N); i++){
				String[] temp=new String[2];
				temp=br.readLine().split(" ");
				cList[i]=new Coordinate(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
			}
			int a=0;
			int b=0;
			Random rand=new Random();
			while(true){
				a=rand.nextInt(1001)-500;
				b=rand.nextInt(1001)-500;
				int above=0;
				int below=0;
				int same=0;
				for(Coordinate c: cList){
					int temp=compare(a,b,c);
					if(temp==-1)
						below++;
					if(temp==1)
						above++;
					else
						same++;
				}
				if(same!=0&&below==above)
					break;
			}
			out.println(a+" "+b);
		}
		out.flush();
		out.close();
	}
	public static int compare(int a, int b, Coordinate c){
		double calc=a*c.x+b*c.y;
		if(calc<0){
			return -1;
		}
		if(calc>0){
			return 1;
		}
		else{
			return 0;
		}
	}
}
/* class Coordinate{
	int x;
	int y;
	public Coordinate(int x, int y){
		this.x=x;
		this.y=y;
	}
	public String toString(){
		return "("+x+","+y+")";
	}
} */