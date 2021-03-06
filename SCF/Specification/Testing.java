import org.junit.*;

public class Testing {

	static Area A = new Area();
	static Strings S = new Strings();
	float a[] = {43,32,67,58,18};
	Marksheet M = new Marksheet(5, a);
	
	@Test
	public void testAverage()
	{
		Assert.assertEquals(43.0, M.average(),0);
	}
	
	@Test
	public void testMax()
	{
		Assert.assertEquals(67.0, M.maximum(), 0);
	}
	
	@Test
	public void testMin()
	{
		Assert.assertEquals(18.0, M.minimum(), 0);
	}
	
	@Test
	public void testPrecntage()
	{
		Assert.assertEquals(60.0, M.percentage(), 0);
	}
	@Test
	public void testTriangle()
	{
		Assert.assertEquals(36.0, A.triangle(12, 6), 0);
	}
	@Test
	public void testRectangle()
	{
		Assert.assertEquals(168.0, A.rectangle(12, 14),0);
	}
	@Test
	public void testSquare()
	{
		Assert.assertEquals(16.0, A.square(4), 0);
	}
	@Test
	public void testReverse()
	{
		Assert.assertEquals("Avi", S.reverse("ivA"));
	}
	@Test
	public void testLargest()
	{
		Assert.assertEquals("India", S.largestWord("India is Great"));
	}
	@Test
	public void testReplace()
	{
		Assert.assertEquals("gREAT", S.replace("Great"));
	}
}
