public class Calculator {

	public Calculator() {
	}

	// TODO Will be better use double for input parameters
	// TODO Incorrect variable naming
	public void operation(int x, String sign, int y) {
		double res;
		switch (sign) {
		// TODO There is required tab.
		case "+":
			res = x + y;
			// TODO Can be placed after switch or moved to another print method
			System.out.println(x + " " + sign + " " + y + " = " + (int) res);
			break;
		case "-":
			res = x - y;
			// TODO Can be placed after switch or moved to another print method
			System.out.println(x + " " + sign + " " + y + " = " + (int) res);
			break;
		case "*":
			res = x * y;
			// TODO Can be placed after switch or moved to another print method
			System.out.println(x + " " + sign + " " + y + " = " + (int) res);
			break;
		case "/":
			if (y == 0) {
				System.out.println("Error: Division by zero");
			} else {
				res = (double) x / (double) y;
				// TODO Can be placed after switch or moved to another print method
				System.out.println(x + " " + sign + " " + y + " = " + res);
			}
			break;
		default:
			// TODO Throw exception about not supported method
			break;
		}

	}
}
