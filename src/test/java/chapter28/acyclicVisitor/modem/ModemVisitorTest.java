package chapter28.acyclicVisitor.modem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModemVisitorTest {
    private UnixModemConfigurator v;
    private HayesModem h;
    private ZoomModem z;
    private ErnieModem e;

    @BeforeEach
    public void setUp() {
        v = new UnixModemConfigurator();
        h = new HayesModem();
        z = new ZoomModem();
        e = new ErnieModem();
    }

    @Test
    public void testHayesForUnix() {
        h.accept(v);
        assertEquals("&s1=4&D=3", h.configurationString);
    }

    @Test
    public void testZoomForUnix() {
        z.accept(v);
        assertEquals(42, z.configurationValue);
    }

    @Test
    public void testErnieForUnix() {
        e.accept(v);
        assertEquals("C is too slow", e.internalPattern);
    }
}