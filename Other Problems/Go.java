import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Go{
	static char[][]board=null;
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in=new Scanner(new File("go.txt"));
		int n=in.nextInt();
		for(int i=0; i<n; i++){
			board=new char[9][9];
			in.nextLine();
			for(int j=0; j<9; j++){
				board[j]=in.nextLine().toCharArray();
			}
			for(int r=0; r<9; r++){
				for(int c=0; c<9; c++){
					if(board[r][c]=='O'){
						fill(r+1,c,'O');
						fill(r-1,c,'O');
						fill(r,c+1,'O');
						fill(r,c-1,'O');
					}
					if(board[r][c]=='X'){
						fill(r+1,c,'X');
						fill(r-1,c,'X');
						fill(r,c+1,'X');
						fill(r,c-1,'X');
					}
				}
			}
			int black=0;
			int white=0;
			for(int r=0; r<9; r++){
				for(int c=0; c<9; c++){
					if(board[r][c]=='b'||board[r][c]=='X')
						black++;
					if(board[r][c]=='w'||board[r][c]=='O')
						white++;
				}
			}
			System.out.println("Black "+black+" White "+white);
		}
	}
	public static void fill(int r, int c, char col){
		if(r<0||c<0||r>8||c>8){
			return;
		}
		if(board[r][c]=='b'||board[r][c]=='w'){
			if(col=='O'&&board[r][c]=='b'){
				error(r,c);
			}
			if(col=='X'&&board[r][c]=='w'){
				error(r,c);
			}
			return;
		}
		if(board[r][c]=='.'){
			if(col=='O')
				board[r][c]='w';
			if(col=='X')
				board[r][c]='b';
		}
		fill(r+1,c,col);
		fill(r-1,c,col);
		fill(r,c+1,col);
		fill(r,c-1,col);
	}
	public static void error(int r, int c){
		if(r>=0&&c>=0&&r<=9&&c<=9){
			return;
		}
		if(board[r][c]=='b'||board[r][c]=='w'||board[r][c]=='.'){
			board[r][c]='E';
			error(r+1,c);
			error(r-1,c);
			error(r,c+1);
			error(r,c-1);
		}
		
	}
}