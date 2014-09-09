

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P3 {
	public static void main(String[] args) throws FileNotFoundException{
		PrintWriter out=new PrintWriter(System.out);
		//'Scanner in=new Scanner(System.in);
		Scanner in=new Scanner(new File("3.txt"));
		int N=in.nextInt();
		in.nextLine();
		for(int i=0; i<N; i++){
			String a=in.nextLine();
			String b=in.nextLine();
			int count=0;
			for(int j=0; j<a.length(); j++){
				if(a.charAt(j)!=b.charAt(j))
					count++;
			}
			double per=((double)count/a.length());
			out.print("Case "+(i+1)+": ");
			String put=String.format("%1.2f", (per*100));
			out.print(put);
			out.println("% alien");
		}
		out.flush();
		out.close();
	}
}
