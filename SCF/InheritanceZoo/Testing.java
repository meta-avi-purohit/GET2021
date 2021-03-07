import org.junit.*;

public class Testing {
	static ZooMammal M;
	static Lion L1;
	static Tiger T;
	static Lion L2;
	static ZooReptile R;
	static Crocodile C1;
	static Crocodile C2;
	
	@BeforeClass
	public static void setUp() {
		M = new ZooMammal(2,1,true,false);
		L1 = new Lion(90,12,"Leo");
		T = new Tiger(67, 14, "Great Indina Tiger");
		L2 = new Lion(50, 9 ,"Ligeon");
		R = new ZooReptile(1,1,false,true);
		C1 = new Crocodile(23, 14, "Rocky");
		C2 = new Crocodile(14, 40, "Coco");
	}
	@Test
	public void testHasCanteen(){
		Assert.assertEquals(true, M.isHasCanteen());
		Assert.assertEquals(false, R.isHasCanteen());
	}
	@Test
	public void testHasPark(){
		Assert.assertEquals(false, M.isHasPark());
		Assert.assertEquals(true, R.isHasPark());
	}
	@Test
	public void testAddAnimal(){
		Assert.assertEquals(true, M.addAnimal(T));
		Assert.assertEquals(true, M.addAnimal(L1));
		Assert.assertEquals(false, M.addAnimal(L2));
		Assert.assertEquals(true, R.addAnimal(C1));
		Assert.assertEquals(false, R.addAnimal(C2));
	}
}
