import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


class hal9000 {
	public static void main(String[] args) throws FileNotFoundException{
		//Scanner in=new Scanner(System.in);
		Scanner in=new Scanner(new File("hal.txt"));
		int cLists=in.nextInt();
		System.out.println("HAL, open the pod bay doors.");
		for(int i=0; i<cLists; i++){
			int numC=in.nextInt();
			ArrayList<String> commands=new ArrayList<String>();
			int temp=in.nextInt();
			int last=temp;
			String command=in.next();
			commands.add(command);
			for(int j=1; j<numC; j++){
				temp=in.nextInt();
				command=in.next();
				if(temp-last<=1)
					commands.add(0,command);
				else
					commands.add(command);
				last=temp;
			}
			System.out.println("\nCommand List #"+(i+1));
			for(String a: commands)
				System.out.println(a);
		}
		System.out.println("\nI cannot do that, Dave.");
	}
}
