import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class problem4 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int num = Integer.parseInt(buffer.readLine());
		for(int x = 0; x<num; x++){
			String[] temp = buffer.readLine().split(" ");
			double[] lines = new double[3];
			for(int y = 0; y<3; y++){
				lines[y] = Double.parseDouble(temp[y]);
			}
			double p = (lines[0]+lines[1]+lines[2])/2;
			double area = (Math.sqrt(p*(p-lines[0])*(p-lines[1])*(p-lines[2])));
			area*=10;
			int area2 = (int)area;
			area=(double)area2/10;
			out.println(area);
		}
		out.flush();
		out.close();
	}
}
