import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P5{
	public static void main(String[] args) throws FileNotFoundException{
		PrintWriter out=new PrintWriter(System.out);
		Scanner in=new Scanner(System.in);
		//Scanner in=new Scanner(new File("5.txt"));
		int N=in.nextInt();
		for(int i=0; i<N; i++){
			int L=in.nextInt();
			int W=in.nextInt();
			in.nextLine();
			char[][] map =new char[W][L];
			for(int j=0; j<W; j++){
				map[j]=in.nextLine().toCharArray();
			}
			int sR = 0;
			int sC = 0;
			int pR=0;
			int pC=0;
			for(int x=0; x<map.length; x++){
				for(int y=0; y<map[0].length; y++){
					if(map[x][y]=='S'){
						sR=x;
						sC=y;
					}
					if(map[x][y]=='P'){
						pR=x;
						pC=y;
					}
				}
			}
			int rows=map.length;
			int cols=map[0].length;
			while(true){
				if(map[sR][sC]=='P'){
					out.println("Case "+(i+1)+": The force is not with her.");
					break;
				}
				if(sR+1<rows&&map[sR+1][sC]=='P'){
					out.println("Case "+(i+1)+": The force is not with her.");
					break;
				}
				else if(sR-1>=0&&map[sR-1][sC]=='P'){
					out.println("Case "+(i+1)+": The force is not with her.");
					break;
				}
				else if(sC-1>=0&&map[sR][sC-1]=='P'){
					out.println("Case "+(i+1)+": The force is not with her.");
					break;
				}
				else if(sC+1<cols&&map[sR][sC+1]=='P'){
					out.println("Case "+(i+1)+": The force is not with her.");
					break;
				}
				if(sR+1<rows&&map[sR+1][sC]=='.'){
					map[sR][sC]='X';
					map[sR+1][sC]='S';
					sR=sR+1;
				}
				else if(sR-1>=0&&map[sR-1][sC]=='.'){
					map[sR][sC]='X';
					map[sR-1][sC]='S';
					sR=sR-1;
				}
				else if(sC-1>=0&&map[sR][sC-1]=='.'){
					map[sR][sC]='X';
					map[sR][sC-1]='S';
					sC=sC-1;
				}
				else if(sC+1<cols&&map[sR][sC+1]=='.'){
					map[sR][sC]='X';
					map[sR][sC+1]='S';
					sC=sC+1;
				}
				else{
					out.println("Case "+(i+1)+": The force is not with me.");
					break;
				}
			}
		}
		out.flush();
		out.close();
	}
}