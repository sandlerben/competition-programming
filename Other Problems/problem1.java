import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class problem1 {
	public static void main(String[] args) throws FileNotFoundException{
		//Scanner in=new Scanner(System.in);
		Scanner in=new Scanner(new File("1.txt"));
		int c=in.nextInt();
		for(int i=0; i<c; i++){
			int n=in.nextInt();
			ArrayList<Player> players=new ArrayList<Player>();
			in.nextLine();
			for(int j=0; j<n; j++){
				String temp=in.nextLine();
				players.add(new Player(temp,j+1));
			}
			while(players.size()!=1){
				ArrayList<Player> temp=new ArrayList<Player>();
				for(int j=0; j<players.size()-1; j+=2){
					int a=versus(players.get(j),players.get(j+1));
					if(a==1)
						temp.add(players.get(j));
					else
						temp.add(players.get(j+1));
				}
				if(players.size()%2==1){
					temp.add(players.get(players.size()-1));
				}
				players=temp;
			}
			System.out.println("Player "+(players.get(0).number)+" gets the day off!");
		}
	}
	public static int versus(Player y, Player z){
		String a=y.plays;
		String b=z.plays;
		for(int i=0; i<a.length(); i++){
			if(a.charAt(i)=='P'&&b.charAt(i)=='S')
				return 2;
			if(a.charAt(i)=='P'&&b.charAt(i)=='R')
				return 1;
			if(a.charAt(i)=='R'&&b.charAt(i)=='P')
				return 2;
			if(a.charAt(i)=='R'&&b.charAt(i)=='S')
				return 1;
			if(a.charAt(i)=='S'&&b.charAt(i)=='R')
				return 2;
			if(a.charAt(i)=='S'&&b.charAt(i)=='P')
				return 1;
		}
		return 1;
	}
}
class Player{
	String plays;
	int number;
	public Player(String plays, int number){
		this.plays=plays;
		this.number=number;
	}
}
