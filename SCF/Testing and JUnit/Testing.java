import org.junit.*;

public class Testing {

	static ArrOperation A ;
	
	@Test
	public void testMaxMirror()
	{
		int a[] = { 1, 2, 3, 8, 9, 3, 2, 1};
		A = new ArrOperation(a);
		Assert.assertEquals(3, A.maxMirror());
		int b[] = { 7, 1, 4, 9, 7, 4, 1};
		A = new ArrOperation(b);
		Assert.assertEquals(2, A.maxMirror());
		int c[] = { 1, 2, 1, 4 };
		A = new ArrOperation(c);
		Assert.assertEquals(3, A.maxMirror());
		int d[] = { 1, 4, 5, 3, 5, 4, 1};
		A = new ArrOperation(d);
		Assert.assertEquals(7, A.maxMirror());
	}
	
	@Test
	public void testClumps()
	{
		int a[] = { 1, 2, 2, 3, 4, 4};
		A = new ArrOperation(a);
		Assert.assertEquals(2, A.countClumps());
		int b[] = { 1, 1, 2, 1, 1};
		A = new ArrOperation(b);
		Assert.assertEquals(2, A.countClumps());
		int c[] = { 1, 1, 1, 1, 1};
		A = new ArrOperation(c);
		Assert.assertEquals(1, A.countClumps());
	}
	
	@Test
	public void testSplit()
	{
		int a[] = { 1, 1, 1, 2, 1};
		A = new ArrOperation(a);
		Assert.assertEquals(3, A.splitArray());
		int b[] = { 2, 1, 1, 2, 1};
		A = new ArrOperation(b);
		Assert.assertEquals(-1, A.splitArray());
		int c[] = { 10, 10};
		A = new ArrOperation(c);
		Assert.assertEquals(1, A.splitArray());
	}
	
	@Test
	public void testFixXY()
	{
		int a[] = { 5, 4, 9, 4, 9, 5 };
		A = new ArrOperation(a);
		int b[] = { 9, 4, 5, 4, 5, 9 };
		Assert.assertArrayEquals(b, A.fixXY(4, 5));
		int c[] = { 1, 4, 1, 5};
		A = new ArrOperation(c);
		int d[] = { 1, 4, 5, 1 };
		Assert.assertArrayEquals(d, A.fixXY(4, 5));
		int e[] = { 1, 4, 1, 5, 5, 4, 1};
		A = new ArrOperation(e);
		int f[] = { 1, 4, 5, 1, 1, 4, 5 };
		Assert.assertArrayEquals(f, A.fixXY(4, 5));
	}
}
