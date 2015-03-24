
public class Calculator {
	
	public Calculator() {}
	
	//TODO Will be better use double for input parameters
	//TODO Incorrect variable naming
	public void operation(int x2, String sign2, int y2) {
		double res;
		switch(sign2) {
		//TODO There is required tab.
		case "+": 
			res = x2+y2;
			//TODO Can be placed after switch or moved to another print method
			System.out.println(x2 + " " + sign2 + " " + y2 + " = " + (int)res);
			break;
		case "-":
			res = x2-y2;
			//TODO Can be placed after switch or moved to another print method
			System.out.println(x2 + " " + sign2 + " " + y2 + " = " + (int)res);
			break;
		case "*": 
			res = x2*y2;
			//TODO Can be placed after switch or moved to another print method
			System.out.println(x2 + " " + sign2 + " " + y2 + " = " + (int)res);
			break;
		case "/": 
			if (y2==0) {
				System.out.println("Error: Division by zero");
			} 
			else {
				res = (double)x2/(double)y2;
				//TODO Can be placed after switch or moved to another print method
				System.out.println(x2 + " " + sign2 + " " + y2 + " = " + res);
			}
			break;
		default:
			//TODO Throw exception about not supported method
			break;
		}

	}

}
