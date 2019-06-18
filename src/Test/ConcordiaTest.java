package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import serverImplementation.ConLibImpl;

public class ConcordiaTest {
	ConLibImpl concordiaLibraryImplementation;

	@Before
	public void beforeEachRun() {
		concordiaLibraryImplementation=new ConLibImpl();
		concordiaLibraryImplementation.addItem("CONM1111", "CON6231", "Distributed", 1);
		concordiaLibraryImplementation.addItem("CONM1111", "CON6231", "Distributed", 5);
		concordiaLibraryImplementation.addItem("CONM1111", "CON6441", "APP", 1);
	}

	@Ignore
	public void addItemThreadTest() {
		Runnable addItemImplConc = () ->{
			concordiaLibraryImplementation.addItem("CONM1111", "CON6231", "Distributed", 1);
		};
		Thread thread1 = new Thread(addItemImplConc);
		Runnable addItemImplCON = () ->{
			concordiaLibraryImplementation.addItem("CONM1111", "CON6231", "Distributed", 5);
		};
		Thread thread2 = new Thread(addItemImplCON);
		Runnable addItemImplTwo = () ->{
			concordiaLibraryImplementation.addItem("CONM1111", "CON6441", "APP", 1);
		};
		Thread thread3 = new Thread(addItemImplTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(17), concordiaLibraryImplementation.getBooksData().get("CON6231").get("Distributed"));
	}

	@Ignore
	public void listItemThreadTest() {
		Runnable listItemImplConc = () ->{
			concordiaLibraryImplementation.listItemAvailability("CONM1111");
		};
		Thread thread1 = new Thread(listItemImplConc);
		Runnable listItemImplCON = () ->{
			concordiaLibraryImplementation.listItemAvailability("CONM1111");
		};
		Thread thread2 = new Thread(listItemImplCON);
		Runnable listItemImplTwo = () ->{
			concordiaLibraryImplementation.listItemAvailability("CONM1111");
		};
		Thread thread3 = new Thread(listItemImplTwo);
		thread1.start();
		//		thread2.start();
		//		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(23), concordiaLibraryImplementation.getBooksData().get("CON6231").get("Distributed"));
	}

	@Ignore
	public void removeItemThreadTest() {
		Runnable removeItemImplConc = () ->{
			concordiaLibraryImplementation.removeItem("CONM1111", "CON6231", 1, 2);
		};
		Thread thread1 = new Thread(removeItemImplConc);
		Runnable removeItemImplCON = () ->{
			concordiaLibraryImplementation.removeItem("CONM1111", "CON6231", 1,2);
		};
		Thread thread2 = new Thread(removeItemImplCON);
		Runnable removeItemImplTwo = () ->{
			concordiaLibraryImplementation.removeItem("CONM1111", "CON6231", 1,2);
		};
		Thread thread3 = new Thread(removeItemImplTwo);
		thread1.start();
				thread2.start();
				thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(33), concordiaLibraryImplementation.getBooksData().get("CON6231").get("Distributed"));
	}

	@Test
	public void borrowItemList() {
		Runnable borrowItemImplConc = () ->{
			concordiaLibraryImplementation.addItem("CONM1111", "CON6231", "Distributed", 1);
		};
		Thread thread1 = new Thread(borrowItemImplConc);
		Runnable borrowItemImplCON = () ->{
			concordiaLibraryImplementation.borrowItem("CONU1111", "CON6231");
		};
		Thread thread2 = new Thread(borrowItemImplCON);
		Runnable borrowItemImplTwo = () ->{
			concordiaLibraryImplementation.removeItem("CONM1111", "CON6231", 1,1);
		};
		Thread thread3 = new Thread(borrowItemImplTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
//		assertEquals(Integer.valueOf(5), concordiaLibraryImplementation.getBooksData().get("CON6231").get("Distributed"));
	}

	@Ignore
	public void returnItemThreadTest() {
		Runnable returnItemImplConc = () ->{
			concordiaLibraryImplementation.returnItem("CONU1111", "CON6231");
		};
		Thread thread1 = new Thread(returnItemImplConc);
		Runnable returnItemImplCON = () ->{
			concordiaLibraryImplementation.returnItem("CONU1111", "CON6231");
		};
		Thread thread2 = new Thread(returnItemImplConc);
		Runnable returnItemImpTwo = () ->{
			concordiaLibraryImplementation.returnItem("CONU1111", "CON6231");
		};
		Thread thread3 = new Thread(returnItemImpTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(30), concordiaLibraryImplementation.getBooksData().get("CON6231").get("Distributed"));
	}

	@Ignore
	public void findItemThreadTest() {
		Runnable findItemImplConc = () ->{
			concordiaLibraryImplementation.findItem("CONU1111", "DISTRIBUTED",false);
		};
		Thread thread1 = new Thread(findItemImplConc);
		Runnable findItemImplCON = () ->{
			concordiaLibraryImplementation.findItem("CONU1111","DISTRIBUTED",false);
		};
		Thread thread2 = new Thread(findItemImplCON);
		Runnable findItemImplTwo = () ->{
			concordiaLibraryImplementation.findItem("CONU1111", "DISTRIBUTED",false);
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
			concordiaLibraryImplementation.exchangeItem("CONM1111", "CON6441",  "CON6231", false);
		};
		Thread thread1 = new Thread(exchangeItemImplConc);
		Runnable exchangeItemImplCON = () ->{
			concordiaLibraryImplementation.exchangeItem("CONM1111", "CON6440",  "CON6231", false);
		};
		Thread thread2 = new Thread(exchangeItemImplCON);
		Runnable exchangeItemImplTwo = () ->{
			concordiaLibraryImplementation.exchangeItem("CONM1111", "CON6441",  "CON6231", false);
		};
		Thread thread3 = new Thread(exchangeItemImplTwo);
		thread1.start();
		thread2.start();
		thread3.start();
		while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
		assertEquals(Integer.valueOf(12), concordiaLibraryImplementation.getBooksData().get("CON6231").get("Distributed"));
	}
}

