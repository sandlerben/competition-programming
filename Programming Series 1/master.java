import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class master {
	public static void main(String[] args) throws FileNotFoundException{
		//Scanner in=new Scanner(System.in);
		Scanner in=new Scanner(new File("master.txt"));
		int numMaps=in.nextInt();
		System.out.println("I'm going to have to put you on the game grid.");
		for(int i=0; i<numMaps; i++){
			char[][]map=new char[in.nextInt()][in.nextInt()];
			int limit=in.nextInt();
			System.out.println(limit);
			in.nextLine();
			int cR=-1;
			int cC=-1;
			int eR=-1;
			int eC=-1;
			for(int r=0; r<map.length; r++){
				String temp=in.nextLine();
				map[r]=temp.toCharArray();
				System.out.println(temp);
			}
			for(int r=0; r<map.length; r++){
				for(int c=0; c<map[0].length; c++){
					if(map[r][c]=='C'){
						cR=r;
						cC=c;
					}
					if(map[r][c]=='E'){
						eR=r;
						eC=c;
					}
				}
			}
			int count=0;
			while(true){
				/*for(int r=0; r<map.length; r++){
					for(int c=0; c<map[0].length; c++){
						System.out.print(map[r][c]);
					}
					System.out.println();
				}
				System.out.println(count);*/
				if(count==limit){
					System.out.println("I shouldn't have written all of those tank programs.");
					break;
				}
				if(cR==eR&&cC+1==eC||cR==eR&&cC-1==eC||cR+1==eR&&cC==eC||cR-1==eR&&cC==eC){
					System.out.println("I knew you'd escape! They haven't built a circuit that could hold you!");
				}
				else{
					count++;
				}
				if(cR==eR&&eC>cC){
					if(map[cR][cC+1]=='.'){
						map[cR][cC+1]='C';
						map[cR][cC]='-';
						cC+=1;
					}
				}
				if(cR==eR&&eC<cC){
					if(map[cR][cC-1]=='.'){
						map[cR][cC-1]='C';
						map[cR][cC]='-';
						cC-=1;
					}
				}
				if(cC==eC&&eR>cR){
					if(map[cR+1][cC]=='.'){
						map[cR+1][cC]='C';
						map[cR][cC]='-';
						cR+=1;
					}
				}
				if(cC==eC&&eR<cR){
					if(map[cR-1][cC]=='.'){
						map[cR-1][cC]='C';
						map[cR][cC]='-';
						cR-=1;
					}
				}
				else if(map[cR+1][cC]=='.'){
					map[cR+1][cC]='C';
					map[cR][cC]='-';
					cR+=1;
				}
				else if(map[cR-1][eC]=='.'){
					map[cR-1][eC]='C';
					map[cR][eC]='-';
					cR-=1;
				}
				else if(map[cR][cC+1]=='.'){
					map[cR][cC+1]='C';
					map[cR][cC]='-';
					cC+=1;
				}
				else if(map[cR][cC-1]=='.'){
					map[cR+1][cC-1]='C';
					map[cR][cC]='-';
					cC-=1;
				}
			}
		}
	}
}
