package chapter16.singletone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

class TestSimpleSingleton {
    @Test
    @DisplayName("Instance를 통해 접근, 여러번 호출되어도 똑같은 인스턴스")
    public void testCreateSingleton() {
        Singleton s = Singleton.Instance();
        Singleton s2 = Singleton.Instance();
        assertSame(s, s2);
    }

    @Test
    @DisplayName("public 생성자가 없기 때문에, Instance 메소드를 사용하지 않고서는 생성할 수 없")
    public void testNoPublicConstructors() throws Exception {
        Class singleton = Class.forName("Singleton");
        Constructor[] constructors = singleton.getConstructors();
        assertEquals(0, constructors.length);
    }
}