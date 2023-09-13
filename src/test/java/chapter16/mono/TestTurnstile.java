package chapter16.mono;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTurnstile {
    @Test
    public void setUp()
    {
        Turnstile t = new Turnstile();
        t.reset();
    }
    @Test
    public void testInit()
    {
        Turnstile t = new Turnstile();
        assert(t.locked());
        assert(!t.alarm());
    }
    @Test
    public void testCoin()
    {
        Turnstile t = new Turnstile();
        t.coin();
        Turnstile t1 = new Turnstile();
        assert(!t1.locked());
        assert(!t1.alarm());
        assertEquals(1, t1.coins());
    }
    @Test
    public void testCoinAndPass()
    {
        Turnstile t = new Turnstile();
        t.coin();
        t.pass();
        Turnstile t1 = new Turnstile();
        assert(t1.locked());
        assert(!t1.alarm());
        assertEquals(1, t1.coins());
    }
    public void testTwoCoins()
    {
        Turnstile t = new Turnstile();
        t.coin();
        t.coin();
        Turnstile t1 = new Turnstile();
        assert(!t1.locked());
        assertEquals(1, t1.coins());
        assertEquals(1, t1.refunds());
        assert(!t1.alarm());
    }
    @Test
    public void testPass()
    {
        Turnstile t = new Turnstile();
        t.pass();
        Turnstile t1 = new Turnstile();
        assert(t1.alarm());
        assert(t1.locked());
    }
    @Test
    public void testCancelAlarm()
    {
        Turnstile t = new Turnstile();
        t.pass();
        t.coin();
        Turnstile t1 = new Turnstile();
        assert(!t1.alarm());
        assert(!t1.locked());
        assertEquals(1, t1.coins());
        assertEquals(0, t1.refunds());
    }
    @Test
    public void testTwoOperations()
    {
        Turnstile t = new Turnstile();
        t.coin();
        t.pass();
        t.coin();
        assert( !t.locked());
        assertEquals(2, t.coins());
        t.pass();
        assert(t.locked());
    }
}