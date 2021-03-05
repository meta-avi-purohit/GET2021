import org.junit.*;

public class Testing {

	static SparseMatrix S1;
	static SparseMatrix S2;
	static SparseMatrix S3;
	static SparseMatrix ADD;
	static SparseMatrix MULTIPY;
	@BeforeClass
	public static void setUp()
	{
		//Elements of S1
		S1.insert(0, 0, 1);
		S1.insert(0, 2, 2);
		S1.insert(1, 1, 3);
		S1.insert(2, 2, 5);
		
		//Elements of S2
		S2.insert(0, 0, 1);
		S2.insert(1, 1, 1);
		S2.insert(2, 2, 1);
		
		// Elements of S2
		S3.insert(1, 1, 1);
		S3.insert(2, 2, 1);
		S3.insert(0, 0, 1);
		
		//ADD MATRIX
		ADD.insert(0, 0, 2);
		ADD.insert(0, 2, 2);
		ADD.insert(1, 1, 4);
		ADD.insert(2, 2, 6);
		
		//MULTIPLY MATRIX
		MULTIPY.insert(0, 2, 2);
		MULTIPY.insert(1, 1, 3);
		MULTIPY.insert(2, 2, 5);
	}
	
	@Test
	public void testTranspose(){
		
		Assert.assertEquals(S3, S2.transpose());
	}
	
	@Test
	public void testSymmetric(){
		Assert.assertEquals(true, S2.transpose());
		Assert.assertEquals(false, S1.transpose());
	}
	
	@Test
	public void testAdd(){
		Assert.assertEquals(ADD, S1.add(S2));
	}
	
	@Test
	public void testMultiply(){
		Assert.assertEquals(MULTIPY, S1.multiply(S2));
	}
	
}
