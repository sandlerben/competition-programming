
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


public class problem1 {
	public static void main(String[] args) throws FileNotFoundException, ParseException{
		PrintWriter out=new PrintWriter(System.out);
		//Scanner in=new Scanner(System.in);
		Scanner in=new Scanner(new File("dates.txt"));
		int num=in.nextInt();
		in.nextLine();
		String[] dates=new String[num];
		for(int i=0; i<num; i++){
			dates[i]=in.nextLine();
		}
		SimpleDateFormat a=new SimpleDateFormat();
		a.applyPattern("MM/dd/yyyy");
		SimpleDateFormat b=new SimpleDateFormat();
		b.applyPattern("MM/dd/yy");
		SimpleDateFormat c=new SimpleDateFormat();
		c.applyPattern("MMMM d, yyyy");
		SimpleDateFormat d=new SimpleDateFormat();
		d.applyPattern("yyyy MMMM-d");
		SimpleDateFormat e=new SimpleDateFormat();
		e.applyPattern("yyyy-MM-dd");
		SimpleDateFormat f=new SimpleDateFormat();
		f.applyPattern("yy-MM-dd");
		SimpleDateFormat[] formats=new SimpleDateFormat[6];
		formats[0]=a;
		formats[1]=b;
		formats[2]=c;
		formats[3]=d;
		formats[4]=e;
		formats[5]=f;
		Date[] list=new Date[num];
		for(int i=0; i<dates.length; i++){
			for(int j=0; j<formats.length; j++){
				try{
					list[i]=formats[j].parse(dates[i]);
				}
				catch(ParseException temp){
					
				}
			}
		}
		HashMap<Date, String> originals=new HashMap<Date,String>();
		for(int i=0; i<list.length; i++){
			originals.put(list[i], dates[i]);
		}
		Arrays.sort(list);
		for(int i=0; i<list.length; i++){
			out.println(originals.get(list[i]));
		}
		out.flush();
		out.close();
	}
}

