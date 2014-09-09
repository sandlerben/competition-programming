import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class BookIndex {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in=new Scanner(new File("index3.txt"));
		Stack<Entry> words=new Stack<Entry>();
		words.push(new Entry(in.nextLine(),0));
		while(in.hasNext()){
			System.out.println(words);
			String temp=in.nextLine();
			int currentTabs=0;
			while(temp.indexOf("\t")!=-1){
				temp=temp.substring(temp.indexOf("\t")+1);
				currentTabs++;
			}
			Entry current=new Entry(temp,currentTabs);
			if(currentTabs<words.peek().tabs||!in.hasNext()){
				int level=words.peek().tabs;
				while(true){
					String tempWord=words.pop().current;
					if(words.peek().tabs!=level)
						break;
					if(tempWord.compareTo(words.peek().current)<0){
						System.out.println("It fails.");
						return;
					}
				}
				if(current.tabs==words.peek().tabs){
					if(current.current.compareTo(words.peek().current)<0){
						System.out.println("It fails.");
						return;
					}
				}
				words.push(current);
			}
			else{
				if(current.tabs==words.peek().tabs){
					if(current.current.compareTo(words.peek().current)<0){
						System.out.println("It fails.");
						return;
					}
				}
				words.push(current);
			}
		}
		while(words.size()!=0){
			int currentTabs=words.peek().tabs;
			while(true){
				String tempWord=words.pop().current;
				if(words.size()==0||words.peek().tabs!=currentTabs)
					break;
				if(tempWord.compareTo(words.peek().current)<0){
					System.out.println("It fails.");
					return;
				}
			}
		}
		System.out.println("It works");
	}
}
class Entry{
	String current;
	int tabs;
	public Entry(String current, int tabs){
		this.current=current;
		this.tabs=tabs;
	}
	public String toString(){
		return current;
	}
}