import org.junit.*;

public class Testing {
	static LCMHCF L = new LCMHCF();
	static Search S = new Search();
	static int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	static int board[][] = new int[4][4];
	static Recursion Q = new Recursion();

	@Test
	public void testLCM() {
		Assert.assertEquals(105, L.recursionLCM(21, 5));
	}

	@Test
	public void testHCF() {
		Assert.assertEquals(5, L.recursionHCF(40, 25));
	}

	@Test
	public void testLinearSearch() {
		Assert.assertEquals(3, S.linearSearch(a, 3, 0, 10));
	}

	@Test
	public void testBinarySearch() {
		Assert.assertEquals(6, S.binarySearch(a, 6, 0, 10));
	}

	@Test
	public void testnQueen() {
		Assert.assertTrue(Q.nQueen(board, 0, 4));
	}
}
