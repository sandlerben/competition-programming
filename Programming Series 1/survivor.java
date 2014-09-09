import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class survivor {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in=new Scanner(new File("survivor.txt"));
		//Scanner in=new Scanner(System.in);
		int scenarios=in.nextInt();
		for(int i=0; i<scenarios; i++){
			int cases=in.nextInt();
			double[][]coordinates=new double[cases][2];
			for(int j=0; j<cases; j++){
				double[] temp={in.nextDouble(),in.nextDouble()};
				coordinates[j]=temp;
			}
			double length=0;
			for(int j=1; j<cases; j++){
				length+=Math.sqrt(Math.pow(coordinates[j][0]-coordinates[j-1][0],2)+Math.pow(coordinates[j][1]-coordinates[j-1][1],2));
			}
			length+=Math.sqrt(Math.pow(coordinates[0][0]-coordinates[cases-1][0],2)+Math.pow(coordinates[0][1]-coordinates[cases-1][1],2));
			length*=66.09;
			System.out.print("Island#"+(i+1)+": walking speed = ");
			System.out.printf("%.2f",length);
			System.out.println(" mph");
		}
	}
}
