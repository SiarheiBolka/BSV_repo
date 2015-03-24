
public class Calculator {
	
	public Calculator() {}
	
	public void operation(int x2, String sign2, int y2) {
		double res;
		switch(sign2) {
		case "+": 
			res = x2+y2;
			System.out.println(x2 + " " + sign2 + " " + y2 + " = " + (int)res);
			break;
		case "-":
			res = x2-y2;
			System.out.println(x2 + " " + sign2 + " " + y2 + " = " + (int)res);
			break;
		case "*": 
			res = x2*y2;
			System.out.println(x2 + " " + sign2 + " " + y2 + " = " + (int)res);
			break;
		case "/": 
			if (y2==0) {
				System.out.println("Error: Division by zero");
			} 
			else {
				res = (double)x2/(double)y2;
				System.out.println(x2 + " " + sign2 + " " + y2 + " = " + res);
			}
			break;
		default:
			break;
		}

	}

}
