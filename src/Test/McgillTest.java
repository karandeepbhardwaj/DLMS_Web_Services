package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import serverImplementation.McgLibImpl;

public class McgillTest {
	McgLibImpl mcgillLibraryImplementation;
	
	@Before
	public void beforeEachRun() {
		mcgillLibraryImplementation=new McgLibImpl();
		mcgillLibraryImplementation.addItem("MCGM1111", "MCG6231", "Distributed", 1);
		mcgillLibraryImplementation.addItem("MCGM1111", "MCG6231", "Distributed", 5);
		mcgillLibraryImplementation.addItem("MCGM1111", "MCG6441", "APP", 1);
	}

	@Test
	public void addItemThreadTest() {
		Runnable addItemImplConc = () ->{
			mcgillLibraryImplementation.addItem("MCGM1111", "MCG6231", "Distributed", 1);
		};
		Thread thread1 = new Thread(addItemImplConc);
		Runnable addItemImplCON = () ->{
			mcgillLibraryImplementation.addItem("MCGM1111", "MCG6231", "Distributed", 5);
		};
		Thread thread2 = new Thread(addItemImplCON);
		Runnable addItemImplTwo = () ->{
			mcgillLibraryImplementation.addItem("MCGM1111", "MCG6441", "APP", 1);
		};
		Thread thread3 = new Thread(addItemImplTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(17), mcgillLibraryImplementation.getBooksData().get("MCG6231").get("Distributed"));
	}
	
	@Test
	public void listItemThreadTest() {
		Runnable listItemImplConc = () ->{
			mcgillLibraryImplementation.listItemAvailability("MCGM1111");
		};
		Thread thread1 = new Thread(listItemImplConc);
		Runnable listItemImplCON = () ->{
			mcgillLibraryImplementation.listItemAvailability("MCGM1111");
		};
		Thread thread2 = new Thread(listItemImplCON);
		Runnable listItemImplTwo = () ->{
			mcgillLibraryImplementation.listItemAvailability("MCGM1111");
		};
		Thread thread3 = new Thread(listItemImplTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(23), mcgillLibraryImplementation.getBooksData().get("MCG6231").get("Distributed"));
	}
	
	@Test
	public void removeItemThreadTest() {
		Runnable removeItemImplConc = () ->{
			mcgillLibraryImplementation.removeItem("MCGM1111", "MCG6231", 1,2);
		};
		Thread thread1 = new Thread(removeItemImplConc);
		Runnable removeItemImplCON = () ->{
			mcgillLibraryImplementation.removeItem("MCGM1111", "MCG6231", 1, 2);
		};
		Thread thread2 = new Thread(removeItemImplCON);
		Runnable removeItemImplTwo = () ->{
			mcgillLibraryImplementation.removeItem("MCGM1111", "MCG6231", 1, 2);
		};
		Thread thread3 = new Thread(removeItemImplTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(33), mcgillLibraryImplementation.getBooksData().get("MCG6231").get("Distributed"));
	}
	@Test
	public void borrowItemList() {
		Runnable borrowItemImplConc = () ->{
			mcgillLibraryImplementation.borrowItem("MCGU1111", "MCG6231");
		};
		Thread thread1 = new Thread(borrowItemImplConc);
		Runnable borrowItemImplCON = () ->{
			mcgillLibraryImplementation.borrowItem("MCGU1111","MCG6231");
		};
		Thread thread2 = new Thread(borrowItemImplCON);
		Runnable borrowItemImplTwo = () ->{
			mcgillLibraryImplementation.borrowItem("MCGU1111", "MCG6231");
		};
		Thread thread3 = new Thread(borrowItemImplTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(5), mcgillLibraryImplementation.getBooksData().get("MCG6231").get("Distributed"));
	}
	
	@Test
	public void returnItemThreadTest() {
		Runnable returnItemImplConc = () ->{
			mcgillLibraryImplementation.returnItem("MCGU1111", "MCG6231");
		};
		Thread thread1 = new Thread(returnItemImplConc);
		Runnable returnItemImplCON = () ->{
			mcgillLibraryImplementation.returnItem("MCGU1111", "MCG6231");
		};
		Thread thread2 = new Thread(returnItemImplConc);
		Runnable returnItemImpTwo = () ->{
			mcgillLibraryImplementation.returnItem("MCGU1111", "MCG6231");
		};
		Thread thread3 = new Thread(returnItemImpTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(30), mcgillLibraryImplementation.getBooksData().get("MCG6231").get("Distributed"));
	}
	
	@Ignore
	public void findItemThreadTest() {
		Runnable findItemImplConc = () ->{
			mcgillLibraryImplementation.findItem("MCGU1111", "DISTRIBUTED",false);
		};
		Thread thread1 = new Thread(findItemImplConc);
		Runnable findItemImplCON = () ->{
			mcgillLibraryImplementation.findItem("MCGU1111","DISTRIBUTED",false);
		};
		Thread thread2 = new Thread(findItemImplCON);
		Runnable findItemImplTwo = () ->{
			mcgillLibraryImplementation.findItem("MCGU1111", "DISTRIBUTED",false);
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
			mcgillLibraryImplementation.exchangeItem("MCGM1111", "MCG6441",  "MCG6231", false);
		};
		Thread thread1 = new Thread(exchangeItemImplConc);
		Runnable exchangeItemImplCON = () ->{
			mcgillLibraryImplementation.exchangeItem("MCGM1111", "MCG6440",  "MCG6231", false);
		};
		Thread thread2 = new Thread(exchangeItemImplCON);
		Runnable exchangeItemImplTwo = () ->{
			mcgillLibraryImplementation.exchangeItem("MCGM1111", "MCG6441",  "MCG6231", false);
		};
		Thread thread3 = new Thread(exchangeItemImplTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(12), mcgillLibraryImplementation.getBooksData().get("MCG6231").get("Distributed"));
	}
}

