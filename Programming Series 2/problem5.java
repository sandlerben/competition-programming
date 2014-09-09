import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;

public class problem5{
	public static void main(String[] args) throws FileNotFoundException, ParseException{
		PrintWriter out=new PrintWriter(System.out);
		//Scanner in=new Scanner(System.in);
		Scanner in=new Scanner(new File("py.txt"));
		int num=in.nextInt();
		for(int i=0; i<num; i++){
			int m=in.nextInt();
			int b=in.nextInt();
			for(int y=10; y>=0; y--){
				for(int x=0; x<=10; x++){
					if(y==m*x+b)
						out.print("O");
					else
						out.print("X");
				}
				out.println();
			}
		}
		out.flush();
		out.close();
	}
}
