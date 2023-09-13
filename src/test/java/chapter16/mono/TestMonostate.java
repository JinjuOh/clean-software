package chapter16.mono;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestMonostate {

    @Test
    public void testInstance() {
        Monostate m = new Monostate();
        for (int x = 0; x < 10; x++) {
            m.setX(x);
            assertEquals(x, m.getX());
        }
    }

    @Test
    @DisplayName("같은 클래스의 두 인스턴스가 하나인 것처럼 동작")
    public void testInstanceBehaveAsOne() {
        Monostate m1 = new Monostate();
        Monostate m2 = new Monostate();
        for (int x = 0; x < 10; x++) {
            m1.setX(x);
            assertEquals(x, m2.getX());
        }
    }
}