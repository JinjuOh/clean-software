package chapter13;

import chapter05.PrimeGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestSleepCommand {
    private boolean commandExecuted = false;

    @Test
    public void testSleep() throws Exception {
        Command wakeup = () -> commandExecuted = true;

        ActiveObjectEngine e = new ActiveObjectEngine();
        SleepCommand c = new SleepCommand(1000, e, wakeup);
        e.addCommand(c);
        long start = System.currentTimeMillis();
        e.run();
        long stop = System.currentTimeMillis();
        long sleepTime = (stop - start);
        assertTrue(sleepTime > 1000);
        assertTrue(sleepTime < 1100);
        assertTrue(commandExecuted);
    }
}