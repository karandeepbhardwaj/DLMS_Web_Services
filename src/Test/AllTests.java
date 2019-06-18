package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ConcordiaTest.class, McgillTest.class, MontrealTest.class,
		MultithreadedTest.class })
public class AllTests {

}
