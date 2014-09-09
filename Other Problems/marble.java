import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


public class marble {
	public static void main(String[] args) throws IOException{
		System.out.println(2/3);
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new FileReader(new File("marble.txt")));
		PrintWriter out=new PrintWriter(System.out);
		int c=0;
		while(true){
			String[] nums=br.readLine().split(" ");
			int N=Integer.parseInt(nums[0]);
			int Q=Integer.parseInt(nums[1]);
			if(N==0 && Q==0)
				break;
			c++;
			out.println("CASE# "+c+":");
			int[] marbles=new int[N];
			int[] queries=new int[Q];
			for(int i=0; i<N; i++){
				marbles[i]=Integer.parseInt(br.readLine());
			}
			Arrays.sort(marbles);
			for(int i=0; i<Q; i++){
				queries[i]=Integer.parseInt(br.readLine());
			}
			for(int a: queries){
				int x=Arrays.binarySearch(marbles, a);
				while(x>0&&marbles[x-1]==a){
					x-=1;
				}
				if(x<0){
					out.println(a+" not found");
				}
				else{
					out.println(a+" found at "+(x+1));
				}
			}
		}
		out.flush();
		out.close();
	}
}
