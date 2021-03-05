import java.util.*;

final class SparseMatrix{
	private final int sparseMatrix[][] = new int[100][3];
	private final int rows;
	private final int columns;
	private int length;
	
	public SparseMatrix(int row, int column){
		this.rows = row;
		this.columns = column;
		this.length = 0;
	}
	
	//Insert New Value to Matrix
	public void insert(int r, int c, int val) {

		if (r > rows || c > columns) {
			System.out.println("Wrong Values entered");
		}

		else {

			sparseMatrix[length][0] = r;

			sparseMatrix[length][1] = c;

			sparseMatrix[length][2] = val;

			length++;
		}
	}
	

	//Transpose Function  
	public SparseMatrix transpose() {

		SparseMatrix result = new SparseMatrix(columns, rows);

		result.length = length;

		// Number of elements in each column
		int count[] = new int[columns + 1];

		for (int i = 1; i <= columns; i++)
			count[i] = 0;

		for (int i = 0; i < length; i++)
			count[sparseMatrix[i][1]]++;

		int[] index = new int[columns + 1];

		// to count number of elements having column smaller
		// than particular i

		index[1] = 0;

		// initialize rest of the indices
		for (int i = 2; i <= columns; i++)

			index[i] = index[i - 1] + count[i - 1];

		for (int i = 0; i < length; i++) {

			// insert a data at position and increment its value
			int pos = index[sparseMatrix[i][1]]++;

			// row = columns
			result.sparseMatrix[pos][0] = sparseMatrix[i][1];

			// column =row
			result.sparseMatrix[pos][1] = sparseMatrix[i][0];

			// same value
			result.sparseMatrix[pos][2] = sparseMatrix[i][2];
		}
		return result;
	} 
    
	
	//Add Function
    public SparseMatrix add(SparseMatrix b) 
    { 
    	SparseMatrix result = new SparseMatrix(rows, columns);
		if (rows != b.rows || columns != b.columns) {
			System.out.println("Matrices cannot be added");
		} else {

			int aposition = 0, bposition = 0;

			while (aposition < length && bposition < b.length) {

				// if b's row and column is smaller
				if (sparseMatrix[aposition][0] > b.sparseMatrix[bposition][0]
						|| (sparseMatrix[aposition][0] == b.sparseMatrix[bposition][0] && sparseMatrix[aposition][1] > b.sparseMatrix[bposition][1]))
				{

					result.insert(b.sparseMatrix[bposition][0],b.sparseMatrix[bposition][1], b.sparseMatrix[bposition][2]);

					bposition++;
				}

				// if a's row and columns is smaller
				else if (sparseMatrix[aposition][0] < b.sparseMatrix[bposition][0]
						|| (sparseMatrix[aposition][0] == b.sparseMatrix[bposition][0] && sparseMatrix[aposition][1] < b.sparseMatrix[bposition][1]))
				{

					result.insert(sparseMatrix[aposition][0], sparseMatrix[aposition][1], sparseMatrix[aposition][2]);

					aposition++;
				}

				else {

					// add the values as row and columns is same
					int addedval = sparseMatrix[aposition][2] + b.sparseMatrix[bposition][2];

					if (addedval != 0)
						result.insert(sparseMatrix[aposition][0], sparseMatrix[aposition][1], addedval);
				
					aposition++;
					bposition++;
				}
			} 
  
           
            while (aposition < length) 
                result.insert(sparseMatrix[aposition][0], sparseMatrix[aposition][1], sparseMatrix[aposition++][2]); 
  
            while (bposition < b.length) 
                result.insert(b.sparseMatrix[bposition][0], b.sparseMatrix[bposition][1], b.sparseMatrix[bposition++][2]); 
   
            result.print(); 
        } 
		return result;
    } 
    
    
    //Multiply Function
    public SparseMatrix multiply(SparseMatrix b) 
    { 
    	SparseMatrix result = new SparseMatrix(rows, b.rows); 
        if (columns != b.rows) {
            System.out.println("Invalid dimensions"); 
        } else{
  
        // transpose b to compare row  
        b = b.transpose(); 
        int aposition, bposition;
  
        // Loop for A Matrix Elements
        for (aposition = 0; aposition < length;) { 
  
            // current row of result matrix 
            int r = sparseMatrix[aposition][0]; 
  
            // Loop for B Matrix Elements 
            for (bposition = 0; bposition < b.length;) { 
  
                // current column of result matrix  
                int c = b.sparseMatrix[bposition][0]; 
  
                 
                int temp1 = aposition; 
                int temp2 = bposition; 
  
                int sum = 0; 
  
                
                while (temp1 < length && sparseMatrix[temp1][0] == r && temp2 < b.length && b.sparseMatrix[temp2][0] == c) { 
  
                    if (sparseMatrix[temp1][1] < b.sparseMatrix[temp2][1]) {
                    	temp1++; 
                    } else if (sparseMatrix[temp1][1] > b.sparseMatrix[temp2][1]) { 
                        temp2++; 
                    } else {
  
                        // same column, so multiply and increment 
                        sum += sparseMatrix[temp1++][2] * b.sparseMatrix[temp2++][2];
                    }
                }
                if (sum != 0) 
                    result.insert(r, c, sum); 
  
                while (bposition < b.length && b.sparseMatrix[bposition][0] == c) 
                    bposition++; 
            }
            while (aposition < length && sparseMatrix[aposition][0] == r)
                aposition++; 
        }
        result.print();
        }
        return result;
    } 

    public boolean isSymmetric(SparseMatrix S)
    {
    	SparseMatrix T = this.transpose();
    	int flag = 1;
    	for(int i = 0;i<S.length;i++)
    	{
    		if(S.sparseMatrix[i][0] != T.sparseMatrix[i][0] && S.sparseMatrix[i][1] != T.sparseMatrix[i][1] && S.sparseMatrix[i][2] != T.sparseMatrix[i][2])
    		{
    			flag = 0;
    			break;
    		}
    	}
    	if(flag == 1)
    		return true;
    	return false;
    }
    
    //Print Function
	public void print() {
		System.out.println("Dimension: " + rows + "x" + columns);
		System.out.println("Sparse Matrix: \nRow Column Value");

		for (int i = 0; i < length; i++) {

			System.out.println(sparseMatrix[i][0] + " " + sparseMatrix[i][1] + " " + sparseMatrix[i][2]);
		}
	}
}

public class Solution {
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		//First Matrix
		System.out.println("Enter number of Rows and Columns of Matrix : ");
		int row = scan.nextInt();
		int column = scan.nextInt();
		SparseMatrix S = new SparseMatrix(row,column);
		System.out.println("Enter the number of non Zero elements : ");
		int size = scan.nextInt();
		System.out.println("Enter Row, Column, Value:");
		for(int i = 0; i < size; i++)
		{
			int r = scan.nextInt();
			int c = scan.nextInt();
			int value = scan.nextInt();
			S.insert(r, c, value);
		}
		//End

		System.out.println("####ORIGNAL MATRIX####");
		S.print();
		SparseMatrix T = S.transpose();
		System.out.println("####TRANSPOSE OF MATRIX####");
		T.print();
		
		//Second Matrix
		System.out.println("Enter number of Rows and Columns of Matrix : ");
		row = scan.nextInt();
		column = scan.nextInt();
		SparseMatrix S2 = new SparseMatrix(row,column);
		System.out.println("Enter the number of non Zero elements : ");
		size = scan.nextInt();
		System.out.println("Enter Row, Column, Value:");
		for(int i = 0; i < size; i++)
		{
			int r = scan.nextInt();
			int c = scan.nextInt();
			int value = scan.nextInt();
			S2.insert(r, c, value);
		}
		
		System.out.println("####ADDED MATRIX####");
		S.add(S2);
	
		System.out.println("####MULTIPLY MATRIX####");
		S.multiply(S2);
		
		scan.close();
	}

}
