import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;


class LiningUp {
	public static void main(String[] args) throws NumberFormatException, IOException{
		//BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in=new BufferedReader(new FileReader(new File("lining.txt")));
		PrintWriter out=new PrintWriter(System.out);
		int cases=Integer.parseInt(in.readLine());
		in.readLine();
		for(int i=0; i<cases; i++){ //each test case
			ArrayList<int[]> cList=new ArrayList<int[]>();
			ArrayList<Line> lList=new ArrayList<Line>();
			while(true){ //while not done reading coordinates
				String[] temp=new String[2];
				String temp2=in.readLine();
				if(temp2==null||temp2.equals("")){
					break;
				}
				temp=temp2.split(" ");
				int[]coordinate=new int[2];
				coordinate[0]=Integer.parseInt(temp[0]);
				coordinate[1]=Integer.parseInt(temp[1]);
				cList.add(coordinate);
			}
			int max=Integer.MIN_VALUE;
			for(int x=0; x<cList.size(); x++){
				for(int y=x+1; y<cList.size(); y++){
					int[] c1=cList.get(x);
					int[] c2=cList.get(y);
					double m=((double)c2[1]-c1[1])/((double)c2[0]-c1[0]);
					double b=(double)c2[1]-m*c2[0];
					Line l=new Line(m,b);
					int count=0;
					if(!lList.contains(l)){
						for(int[] c3: cList){
							if(c3[1]==m*c3[0]+b){
								count++;
							}
						}
						if(count>max){
							max=count;
						}
						lList.add(l);
					}
				}
			}
			out.println(max);
		}	
		out.flush();
		out.close();
	}
}
class Line{
	double m;
	double b;
	public Line(double m, double b){
		this.m=m;
		this.b=b;
	}
	public boolean equals(Line l){
		return l.m==m&&l.b==b;
	}
	public String toString(){
		return m+"x+"+b;
	}
}
