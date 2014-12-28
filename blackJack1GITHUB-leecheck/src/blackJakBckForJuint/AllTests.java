package blackJakBckForJuint;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({testModelLogic.class, testGame.class, testHand.class,
		TestRound.class})
public class AllTests {

}
