import java.util.Stack;


public class Tower {
	public static int hashFrom;
	public static int hashTo;
	public static int hashReserve;
	public static void main(String[] args){
		double startTime=System.currentTimeMillis();
		Stack<Integer> from=new Stack<Integer>();
		Stack<Integer> to=new Stack<Integer>();
		Stack<Integer> reserve=new Stack<Integer>();
		int n=20;
		for(int i=n; i>=1; i--){
			from.push(i);
		}
		System.out.println("From: "+from);
		System.out.println("Reserve: "+reserve);
		System.out.println("To: "+ to);
		System.out.println("--------------------------------------");
		hashFrom=from.hashCode();
		hashTo=to.hashCode();
		hashReserve=reserve.hashCode();
		hanoi(n, from, to, reserve);
		System.out.println("From: "+from);
		System.out.println("Reserve: "+reserve);
		System.out.println("To: "+ to);
		System.out.println("Total time: "+(System.currentTimeMillis()-startTime));
	}
	public static void hanoi(int n, Stack<Integer> from, Stack<Integer> to, Stack<Integer> reserve){
		System.out.println("From: "+from);
		System.out.println("Reserve: "+reserve);
		System.out.println("To: "+ to);
		System.out.println("--------------------------------------");
		if(n==1){
			to.push(from.pop());
		}
		else{
			hanoi(n-1, from, reserve, to);
			to.push(from.pop());
			hanoi(n-1, reserve, to, from);
		}
	}
}
