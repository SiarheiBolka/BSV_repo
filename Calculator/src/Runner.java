import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
public class Runner {
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);


//****************Calculator creation***************
		System.out.println("Calculator starting... ");
		try {
			Calculator calc = new Calculator();
				
			System.out.println("Enter first digit ");

		
			int x = Integer.parseInt(sc.nextLine());
			
			System.out.println("Select one of operations: + - * / ");
			String sign = sc.nextLine();
				
			System.out.println("Enter second digit ");
			int y = Integer.parseInt(sc.nextLine());
			
			//Calculation
			calc.operation(x, sign, y);
		} catch (Exception e) {
			System.out.println("Calculator error! ");
			e.printStackTrace();
		}
		
		System.out.println();
		
//****************Matrix creation***************
		System.out.println("Matrix creation starting... ");
		try {
			Matrix matr = new Matrix();
			
			//set up matrix parameters
			System.out.println("Enter quantity of strings: ");
			int n = Integer.parseInt(sc.nextLine());
			System.out.println("Enter quantity of columns: ");
			int m = Integer.parseInt(sc.nextLine());
			
			//filling of matrix
			System.out.println("Please fill the matrix: ");
			int[][] myMatrix = new int[n][m];
			
			for (int i = 0; i < n; ++i)
			{
			    for (int j = 0; j < m; ++j)
			    {
			    	System.out.println("Enter element: [" + i + "][" + j + "]");
			    	myMatrix[i][j] = sc.nextInt();
			    }
			}
			
			
			//Print matrix
			System.out.println("Original matrix ");
			matr.display(myMatrix, n, m);
			System.out.println();
			
			//Transpose matrix
			myMatrix=matr.transpon(myMatrix, n, m);
			
			//Print transposed matrix
			System.out.println("Transposed matrix ");
			matr.display(myMatrix, m, n);
		} catch (Exception exc) {
			System.out.println("Matrix error! ");
			exc.printStackTrace();
		}

//****************ArrayList creation***************
		System.out.println();
		System.out.println("ArrayList creation starting... ");
		ArrayList<String> myList = new ArrayList<String>();
		
		System.out.println("Enter quantity of elements in list: ");
		
		 try
		 {
			 BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		     String inputString = bufferRead.readLine();
		     int elem_num = Integer.parseInt(inputString); 
		     System.out.println("Quantity of list elements enters is: " + elem_num);
		     
		     System.out.println("Please fill the list elements: ");
				
		     for (int i = 0; i < elem_num; ++i) {
		    	 System.out.println("Please enter the " + (i+1) + " string: ");
		    	 myList.add(i, bufferRead.readLine());
		     }
		 }
		 catch(IOException ex)
		 {
			 System.out.println("ArrayList input error! ");
			 ex.printStackTrace();
		 }

		//print ArrayList
		System.out.println();
		System.out.println("Original ArrayList: ");
		System.out.println(myList);
		
		
		//Sorting of ArrayList by length
		Collections.sort(myList, new MyComparator());
		
		System.out.println();
		System.out.println("Sorted by lenght ArrayList: ");
		System.out.println(myList);
		
		sc.close();
	}
}
