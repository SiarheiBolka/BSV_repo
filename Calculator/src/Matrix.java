
public class Matrix {
	
	//TODO Only myMatrix is required. 'n' and 'm' can be get from myMatrix variable
	//Print matrix
	public void display(int[][] myMatrix, int n, int m) {
		//TODO More simple http://www.wikihow.com/Print-an-Array-in-Java
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        System.out.print(myMatrix[i][j] + "\t");
		    }
		    System.out.println();
		}
	}
	
	//TODO Move all fields to top of class
	public int tmp=0;
	
	//TODO Use full name for method
	//TODO Only myMatrix is required. 'n' and 'm' can be get from myMatrix variable
	//Transpose matrix
	public int[][] transpon(int[][] myMatrix, int n, int m) {
	int[][] temp = new int[m][n];
	for (int i = 0; i < n; i++)
	//TODO add braces for all loops
	   for (int j = 0; j < m; j++)
	   { 
		   temp[j][i] = myMatrix[i][j];
	     
	   }
	
		return temp;
	}
}
