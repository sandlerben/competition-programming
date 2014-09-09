import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P6{
	public static void main(String[] args) throws FileNotFoundException{
		PrintWriter out=new PrintWriter(System.out);
		//Scanner in=new Scanner(System.in);
		Scanner in=new Scanner(new File("6.txt"));
		int N=in.nextInt();
		for(int i=0; i<N; i++){
			String name=in.next();
			int angle=in.nextInt();
			int height=in.nextInt();
			int numEn=in.nextInt();
			int timeDefeat=in.nextInt();
			int speed=in.nextInt();
			double x=height/Math.tan(Math.PI/180);
			double time=x/speed;
		}
	}
}