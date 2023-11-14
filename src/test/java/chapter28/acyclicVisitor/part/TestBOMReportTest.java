package chapter28.acyclicVisitor.part;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class TestBOMReportTest {

    private PiecePart p1;
    private PiecePart p2;
    private Assembly a;

    @BeforeEach
    void setUp() {
        p1 = new PiecePart("997624", "MyPart", 3.20);
        p2 = new PiecePart("7734", "Hell", 666);
        a = new Assembly("5879", "MyAssembly");
    }

    @Test
    public void testCreatePart() {
        assertEquals("997624", p1.getPartNumber());
        assertEquals("MyPart", p1.getDescription());
        assertEquals(3.20, p1.getCost(), .01);
    }

    @Test
    void testCreateAssembly() {
        assertEquals("5879", a.getPartNumber());
        assertEquals("MyAssembly", a.getDescription());
    }

    @Test
    void testAssembly() {
        a.add(p1);
        a.add(p2);
        Iterator i = a.getParts();
        PiecePart p = (PiecePart) i.next();
        assertEquals(p, p1);
        p = (PiecePart) i.next();
        assertEquals(p, p2);
        assertFalse(i.hasNext());
    }

    @Test
    void testAssemblyOfAssemblies() {
        Assembly subAssembly = new Assembly("1324", "SubAssembly");
        subAssembly.add(p1);
        a.add(subAssembly);

        Iterator i = a.getParts();
        assertEquals(subAssembly, i.next());
    }

    private boolean p1Found = false;
    private boolean p2Found = false;
    private boolean aFound = false;

    @Test
    void testVisitorCoverage() {
        a.add(p1);
        a.add(p2);
        a.accept(
                new PartVisitor() {
                    @Override
                    public void visit(PiecePart pp) {
                        if (pp == p1)
                            p1Found = true;
                        else if (pp == p2)
                            p2Found = true;
                    }

                    @Override
                    public void visit(Assembly assy) {
                        if (assy == a)
                            aFound = true;
                    }
                }
        );
        assertTrue(p1Found);
        assertTrue(p2Found);
        assertTrue(aFound);
    }

    private Assembly cellphone;

    void setUpReportDatabase() {
        cellphone = new Assembly("CP-7734", "Cell Phone");
        PiecePart display = new PiecePart("DS-1428", "LCD Display", 14.37);
        PiecePart speaker = new PiecePart("SP-92", "Speaker", 3.50);
        PiecePart microphone = new PiecePart("MC-28", "Microphone", 5.30);
        PiecePart cellRadio = new PiecePart("CR-56", "Cell Radio", 30);
        PiecePart frontCover = new PiecePart("FC-77", "Front Cover", 1.4);
        PiecePart backCover = new PiecePart("RC-77", "Back Cover", 1.2);
        Assembly keypad = new Assembly("KP-62", "Keypad");
        Assembly button = new Assembly("B52", "Button");
        PiecePart buttonCover = new PiecePart("CV-15", "Cover", 0.5);
        PiecePart buttonContact = new PiecePart("CN-2", "Contact", 1.2);
        button.add(buttonCover);
        button.add(buttonContact);
        for (int i = 0; i < 15; i++) {
            keypad.add(button);
        }
        cellphone.add(display);
        cellphone.add(speaker);
        cellphone.add(microphone);
        cellphone.add(cellRadio);
        cellphone.add(frontCover);
        cellphone.add(backCover);
        cellphone.add(keypad);
    }

    @Test
    void testExplodedCost() {
        setUpReportDatabase();
        ExplodedCostVisitor v = new ExplodedCostVisitor();
        cellphone.accept(v);
        assertEquals(81.27, v.cost(), .001);
    }

    @Test
    void testPartCount() {
        setUpReportDatabase();
        PartCountVisitor v = new PartCountVisitor();
        cellphone.accept(v);
        assertEquals(36, v.getPieceCount());
        assertEquals(8, v.getPartNumberCount());
        assertEquals(1, v.getCountForPart("DS-1428"));
        assertEquals(1, v.getCountForPart("SP-92"));
        assertEquals(1, v.getCountForPart("MC-28"));
        assertEquals(1, v.getCountForPart("CR-56"));
        assertEquals(1, v.getCountForPart("RC-77"));
        assertEquals(15, v.getCountForPart("CV-15"));
        assertEquals(15, v.getCountForPart("CN-2"));
        assertEquals(0, v.getCountForPart("Bob"));
    }
}