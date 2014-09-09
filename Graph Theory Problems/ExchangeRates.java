import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


public class ExchangeRates {
	static HashMap<String,ArrayList<Item>> map;
	static HashMap<String,Item> itemSet;
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in=new Scanner(new File("rate.txt"));
		HashMap<String,ItemEdge> eSet=new HashMap<String,ItemEdge>();
		map=new HashMap<String,ArrayList<Item>>();
		itemSet=new HashMap<String,Item>();
		while(in.hasNext()){
			String examine=in.next();
			if(examine.equals(".")){
				break;
			}
			if(examine.equals("!")){
				int x=in.nextInt();
				String a=in.next();
				in.next();
				int y=in.nextInt();
				String b=in.next();
				eSet.put(a+b,new ItemEdge(a,b,x,y));
				eSet.put(b+a,new ItemEdge(b,a,y,x));
				if(!map.containsKey(a))
					map.put(a, new ArrayList<Item>());
				if(!map.containsKey(b))
					map.put(b, new ArrayList<Item>());
				Item p=new Item(a);
				Item q=new Item(b);
				map.get(a).add(q);
				map.get(b).add(p);
				itemSet.put(a, p);
				itemSet.put(b, q);
			}
			else{
				for(Item i: itemSet.values()){
					i.visited=false;
					i.parent=null;
				}
				String x=in.next();
				in.next();
				String y=in.next();
				Item a=itemSet.get(x);
				Item b=itemSet.get(y);
				if(a==null||b==null){
					System.out.println("? "+x+" = ? "+b);
					continue;
				}
				if(a.equals(b)){
					System.out.println(1+" "+x+" = "+1+" "+y);
					continue;
				}
				DFS(a,b);
				if(b.parent==null){
					System.out.println("? "+x+" = ? "+b);
					continue;
				}
				Item temp=b;
				Stack<ItemEdge> convert=new Stack<ItemEdge>();
				while(!a.equals(temp)){
					convert.push(eSet.get(temp.parent.a+temp.a));
					temp=temp.parent;
				}
				int num=1;
				int den=1;
				while(convert.size()!=0){
					ItemEdge q=convert.pop();
					num*=q.num;
					den*=q.den;
				}
				int divide=GCD(num,den);
				System.out.println((num/divide)+" "+x+" = "+(den/divide)+" "+y);
			}
		}
	}
	public static int GCD(int a, int b) {
		if (b==0) 
			return a;
		return GCD(b,a%b);
	}
	public static void DFS(Item a, Item b){
		a.visited();
		if(a.equals(b)){
			return;
		}
		ArrayList<Item> list=map.get(a.a);
		for(int i=0; i<list.size(); i++){
			if(!list.get(i).visited){
				list.get(i).parent=a;
				if(list.get(i).equals(b)){
					b.parent=a;
				}
				DFS(list.get(i),b);
			}
		}
		return;
	}
}
class Item{
	String a;
	boolean visited;
	Item parent;
	public Item(String a){
		this.a=a;
		visited=false;
		parent=null;
	}
	public void visited(){
		visited=true;
	}
	@Override
	public boolean equals(Object q){
		Item other=(Item)q;
		return a.equals(other.a);
	}
	public String toString(){
		return a;
	}
}
class ItemEdge{
	String a;
	String b;
	int num;
	int den;
	public ItemEdge(String a, String b, int num, int den){
		this.a=a;
		this.b=b;
		this.num=num;
		this.den=den;
	}
	public String toString(){
		return a+" to "+b;
	}
}

