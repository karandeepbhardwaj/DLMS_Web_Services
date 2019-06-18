package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import serverImplementation.MonLibImpl;

public class MontrealTest {
	MonLibImpl montrealLibraryImplementation;
	
	@Before
	public void beforeEachRun() {
		montrealLibraryImplementation=new MonLibImpl();
		montrealLibraryImplementation.addItem("MONM1111", "MON6231", "Distributed", 1);
		montrealLibraryImplementation.addItem("MONM1111", "MON6231", "Distributed", 5);
		montrealLibraryImplementation.addItem("MONM1111", "MON6441", "APP", 1);
	}

	@Test
	public void addItemThreadTest() {
		Runnable addItemImplConc = () ->{
			montrealLibraryImplementation.addItem("MONM1111", "MON6231", "Distributed", 1);
		};
		Thread thread1 = new Thread(addItemImplConc);
		Runnable addItemImplCON = () ->{
			montrealLibraryImplementation.addItem("MONM1111", "MON6231", "Distributed", 5);
		};
		Thread thread2 = new Thread(addItemImplCON);
		Runnable addItemImplTwo = () ->{
			montrealLibraryImplementation.addItem("MONM1111", "MON6441", "APP", 1);
		};
		Thread thread3 = new Thread(addItemImplTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(16), montrealLibraryImplementation.getBooksData().get("MON6231").get("Distributed"));
	}
	
	@Test
	public void listItemThreadTest() {
		Runnable listItemImplConc = () ->{
			montrealLibraryImplementation.listItemAvailability("MONM1111");
		};
		Thread thread1 = new Thread(listItemImplConc);
		Runnable listItemImplCON = () ->{
			montrealLibraryImplementation.listItemAvailability("MONM1111");
		};
		Thread thread2 = new Thread(listItemImplCON);
		Runnable listItemImplTwo = () ->{
			montrealLibraryImplementation.listItemAvailability("MONM1111");
		};
		Thread thread3 = new Thread(listItemImplTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(22), montrealLibraryImplementation.getBooksData().get("MON6231").get("Distributed"));
	}
	
	@Test
	public void removeItemThreadTest() {
		Runnable removeItemImplConc = () ->{
			montrealLibraryImplementation.removeItem("MONM1111", "MON6231", 1, 2);
		};
		Thread thread1 = new Thread(removeItemImplConc);
		Runnable removeItemImplCON = () ->{
			montrealLibraryImplementation.removeItem("MONM1111", "MON6231", 1, 2);
		};
		Thread thread2 = new Thread(removeItemImplCON);
		Runnable removeItemImplTwo = () ->{
			montrealLibraryImplementation.removeItem("MONM1111", "MON6231", 1, 2);
		};
		Thread thread3 = new Thread(removeItemImplTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(31), montrealLibraryImplementation.getBooksData().get("MON6231").get("Distributed"));
	}
	@Test
	public void borrowItemList() {
		Runnable borrowItemImplConc = () ->{
			montrealLibraryImplementation.borrowItem("MON1111", "MON6231");
		};
		Thread thread1 = new Thread(borrowItemImplConc);
		Runnable borrowItemImplCON = () ->{
			montrealLibraryImplementation.borrowItem("MONU1111","MON6231");
		};
		Thread thread2 = new Thread(borrowItemImplCON);
		Runnable borrowItemImplTwo = () ->{
			montrealLibraryImplementation.borrowItem("MONU1111", "MON6231");
		};
		Thread thread3 = new Thread(borrowItemImplTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(4), montrealLibraryImplementation.getBooksData().get("MON6231").get("Distributed"));
	}
	@Test
	public void returnItemThreadTest() {
		Runnable returnItemImplConc = () ->{
			montrealLibraryImplementation.returnItem("MONM1111", "MON6231");
		};
		Thread thread1 = new Thread(returnItemImplConc);
		Runnable returnItemImplCON = () ->{
			montrealLibraryImplementation.returnItem("MON1111", "MON6231");
		};
		Thread thread2 = new Thread(returnItemImplConc);
		Runnable returnItemImpTwo = () ->{
			montrealLibraryImplementation.returnItem("MONM1111", "MON6231");
		};
		Thread thread3 = new Thread(returnItemImpTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(28), montrealLibraryImplementation.getBooksData().get("MON6231").get("Distributed"));
	}
	
	@Ignore
	public void findItemThreadTest() {
		Runnable findItemImplConc = () ->{
			montrealLibraryImplementation.findItem("MONU1111", "DISTRIBUTED",false);
		};
		Thread thread1 = new Thread(findItemImplConc);
		Runnable findItemImplCON = () ->{
			montrealLibraryImplementation.findItem("MONU1111","DISTRIBUTED",false);
		};
		Thread thread2 = new Thread(findItemImplCON);
		Runnable findItemImplTwo = () ->{
			montrealLibraryImplementation.findItem("MONU1111", "DISTRIBUTED",false);
		};
		Thread thread3 = new Thread(findItemImplTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
	}

	@Ignore
	public void exchangeItemThreadTest() {
		Runnable exchangeItemImplConc = () ->{
			montrealLibraryImplementation.exchangeItem("MONU1111", "MON6441",  "MON6231", false);
		};
		Thread thread1 = new Thread(exchangeItemImplConc);
		Runnable exchangeItemImplCON = () ->{
			montrealLibraryImplementation.exchangeItem("MONU1111", "MON6440",  "MON6231", false);
		};
		Thread thread2 = new Thread(exchangeItemImplCON);
		Runnable exchangeItemImplTwo = () ->{
			montrealLibraryImplementation.exchangeItem("MONU1111", "MON6441",  "MON6231", false);
		};
		Thread thread3 = new Thread(exchangeItemImplTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(12), montrealLibraryImplementation.getBooksData().get("MON6231").get("Distributed"));
	}
}

