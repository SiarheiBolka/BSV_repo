
public class Matrix {
	
	//Print matrix
	public void display(int[][] myMatrix, int n, int m) {
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        System.out.print(myMatrix[i][j] + "\t");
		    }
		    System.out.println();
		}
	}
	
	public int tmp=0;
	
	//Transpose matrix
	public int[][] transpon(int[][] myMatrix, int n, int m) {
	int[][] temp = new int[m][n];
	for (int i = 0; i < n; i++)
	   for (int j = 0; j < m; j++)
	   { 
		   temp[j][i] = myMatrix[i][j];
	     
	   }
	
		return temp;
	}
}