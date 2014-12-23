package blackJakBckForJuint;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testGame.class, testHand.class, testModelLogic.class,
		TestRound.class, TestSysData.class })
public class AllTests {

}
