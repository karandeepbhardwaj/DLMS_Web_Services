package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import serverImplementation.ConLibImpl;
import serverImplementation.McgLibImpl;
import serverImplementation.MonLibImpl;

public class MultithreadedTest {
	static ConLibImpl concordiaLibraryImplementation;
	static McgLibImpl mcgillLibraryImplementation;
	static MonLibImpl montrealLibraryImplementation;
	
	@BeforeClass
	public static void beforeEachRun() {
		concordiaLibraryImplementation = new ConLibImpl();
		mcgillLibraryImplementation = new McgLibImpl();
		montrealLibraryImplementation = new MonLibImpl();
	}
	
	@Test
	public void addItemThreadTest() {
		Runnable addItemImplConc = () ->{
			mcgillLibraryImplementation.addItem("MCGM1111", "MCG6231", "Distributed", 1);
			assertEquals(Integer.valueOf(1), mcgillLibraryImplementation.getBooksData().get("MCG6231").get("Distributed"));
		};
		Thread thread1 = new Thread(addItemImplConc);
		Runnable addItemImplMcg = () ->{
			montrealLibraryImplementation.addItem("MONM1111", "MON6231", "Distributed", 5);
			assertEquals(Integer.valueOf(1), montrealLibraryImplementation.getBooksData().get("MON6231").get("Distributed"));
		};
		Thread thread2 = new Thread(addItemImplMcg);
		Runnable addItemImplMon = () ->{
			concordiaLibraryImplementation.addItem("CONM1111", "CON6441", "APP", 1);
			assertEquals(Integer.valueOf(1), concordiaLibraryImplementation.getBooksData().get("CON6441").get("APP"));
		};
		Thread thread3 = new Thread(addItemImplMon);
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	@Test
	public void listItemThreadTest() {
		Runnable listItemImplConc = () ->{
			mcgillLibraryImplementation.listItemAvailability("MCGM1111");
		};
		Thread thread1 = new Thread(listItemImplConc);
		Runnable listItemImplMcg = () ->{
			montrealLibraryImplementation.listItemAvailability("MONM1111");
		};
		Thread thread2 = new Thread(listItemImplMcg);
		Runnable listItemImplMon = () ->{
			concordiaLibraryImplementation.listItemAvailability("CONM1111");
		};
		Thread thread3 = new Thread(listItemImplMon);
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	@Test
	public void removeItemThreadTest() {
		Runnable removeItemImplConc = () ->{
			mcgillLibraryImplementation.removeItem("MCGM1111", "MCG6231", 1,1);
		};
		Thread thread1 = new Thread(removeItemImplConc);
		Runnable removeItemImplMcg = () ->{
			montrealLibraryImplementation.removeItem("MONM1111", "MON6231", 1,1);
		};
		Thread thread2 = new Thread(removeItemImplMcg);
		Runnable removeItemImplMon = () ->{
			concordiaLibraryImplementation.removeItem("CONM1111", "CON6231", 1,1);
		};
		Thread thread3 = new Thread(removeItemImplMon);
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	@Test
	public void borrowItemList() {
		Runnable borrowItemImplConc = () ->{
			concordiaLibraryImplementation.borrowItem("CONU1111", "CON6231");
		};
		Thread thread1 = new Thread(borrowItemImplConc);
		Runnable borrowItemImplMcg = () ->{
			mcgillLibraryImplementation.borrowItem("MCGU1111","MCG6231");
		};
		Thread thread2 = new Thread(borrowItemImplMcg);
		Runnable borrowItemImplMon = () ->{
			montrealLibraryImplementation.borrowItem("MONU1111", "MON6231");
		};
		Thread thread3 = new Thread(borrowItemImplMon);
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	@Test
	public void returnItemThreadTest() {
		Runnable returnItemImplConc = () ->{
			concordiaLibraryImplementation.returnItem("CONU1111", "CON6231");
		};
		Thread thread1 = new Thread(returnItemImplConc);
		Runnable returnItemImplMcg = () ->{
			mcgillLibraryImplementation.returnItem("MCGU1111", "MCG6231");
		};
		Thread thread2 = new Thread(returnItemImplConc);
		Runnable returnItemImplMon = () ->{
			montrealLibraryImplementation.returnItem("MONU1111", "MON6231");
		};
		Thread thread3 = new Thread(returnItemImplMon);
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	@Test
	public void findItemThreadTest() {
		Runnable findItemImplConc = () ->{
			concordiaLibraryImplementation.findItem("CONU1111", "DISTRIBUTED",false);
		};
		Thread thread1 = new Thread(findItemImplConc);
		Runnable findItemImplMcg = () ->{
			mcgillLibraryImplementation.findItem("MCGU1111","DISTRIBUTED",false);
		};
		Thread thread2 = new Thread(findItemImplMcg);
		Runnable findItemImplMon = () ->{
			montrealLibraryImplementation.findItem("MONU1111", "DISTRIBUTED",false);
		};
		Thread thread3 = new Thread(findItemImplMon);
		thread1.start();
		thread2.start();
		thread3.start();
	}

	@Test
	public void exchangeItemThreadTest() {
		Runnable exchangeItemImplConc = () ->{
			concordiaLibraryImplementation.exchangeItem("CONU1111", "CON6441",  "CON6231", false);
			assertTrue(concordiaLibraryImplementation.getUserBookMapping().get("CON6441").contains("CONU1111"));
		};
		Thread thread1 = new Thread(exchangeItemImplConc);
		Runnable exchangeItemImplMcg = () ->{
			mcgillLibraryImplementation.exchangeItem("MCGU1111", "MCG6440",  "MCG6231", false);
			assertTrue(mcgillLibraryImplementation.getUserBookMapping().get("MCG6231").contains("MCGU1111"));
		};
		Thread thread2 = new Thread(exchangeItemImplMcg);
		Runnable exchangeItemImplMon = () ->{
			montrealLibraryImplementation.exchangeItem("MONU1111", "MON6441",  "MON6231", false);
			assertTrue(montrealLibraryImplementation.getUserBookMapping().get("MON6441").contains("MONU1111"));
		};
		Thread thread3 = new Thread(exchangeItemImplMon);
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

