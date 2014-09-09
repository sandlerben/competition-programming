import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Crypt {
	public static void main(String[] args) throws FileNotFoundException{
		String quick="the quick brown fox jumps over the lazy dog";
		Scanner in=new Scanner(new File("abc.txt"));
		int n=in.nextInt();
		in.nextLine();
		in.nextLine();
		for(int i=0; i<n; i++){
			if(i>0)
				System.out.println();
			ArrayList<String> lines=new ArrayList<String>();
			String temp=in.nextLine();
			while(!temp.equals("")){
				try{
				lines.add(temp);
				temp=in.nextLine();
				}
				catch(NoSuchElementException e){
					break;
				}
			}
			String abc="";
			HashMap<Character,Character> dictionary = null;
			for(String line: lines){
				if(line.length()==43){
					String[] sp=line.split(" ");
					if(sp[0].length()==3&&sp[1].length()==5&&sp[2].length()==5&&sp[3].length()==3&&sp[4].length()==5&&sp[5].length()==4&&sp[6].length()==3&&sp[7].length()==4&&sp[8].length()==3){
						abc=line;
						//creating dictionary, checking if it's possible
						dictionary=new HashMap<Character,Character>();
						char[] c=abc.toCharArray();
						char[] d=quick.toCharArray();
						for(int j=0; j<c.length; j++){
							Character match=dictionary.get(c[j]);
							if(match!=null){
								if(match!=d[j]){
									//CONTRADICTION!!!
									abc="";
									break;
								}
							}
							if(c[j]!=' ')
								dictionary.put(c[j], d[j]);
						}
					}
				}
			}
			if(abc.equals("")){
				System.out.println("No solution.");
				continue;
			}
			//decode loop
			for(int x=0; x<lines.size(); x++){
				String line=lines.get(x);
				char[] l=line.toCharArray();
				for(int j=0; j<l.length; j++){
					if(dictionary.containsKey(l[j]))
						l[j]=dictionary.get(l[j]);
				}
				line=String.valueOf(l);
				System.out.println(line);
			}
		}
	}
}
