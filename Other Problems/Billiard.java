import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


class Billiard {
	public static void main(String[] args) throws IOException{
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new FileReader(new File("billiard.txt")));
		PrintWriter out=new PrintWriter(System.out);
		while(true){
			String[] temp=new String[5];
			temp=br.readLine().split(" ");
			int a=Integer.parseInt(temp[0]);
			int b=Integer.parseInt(temp[1]);
			int s=Integer.parseInt(temp[2]);
			int m=Integer.parseInt(temp[3]);
			int n=Integer.parseInt(temp[4]);
			if(a==0&&b==0&&s==0&&m==0&&m==0&&n==0)
				break;
			double frac=(n*b*1.0)/(m*a*1.0);
			double angleR=Math.atan(frac);
			double angle=angleR*(180/Math.PI);
			double velocity=(a*m*1.0)/(s*Math.cos(angleR));
			String temp2=String.format("%.2f", angle);
			String temp3=String.format("%.2f", velocity);
			out.println(temp2+" "+temp3);
		}
		out.flush();
		out.close();
	}
}
