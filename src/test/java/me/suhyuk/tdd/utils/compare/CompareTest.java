package me.suhyuk.tdd.utils.compare;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.TestPropertySource;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

// Effective Java 2nd - 3장 '보편적 계약 (General Contracts)에 대한 실험
// TODO. 인스턴스 생성이 가능한 클래스의 서브 클래스에 값 컴포넌트를 추가하면서 equals 를 구현할 방법은 없다
// TODO. 이러한 경우는 상속(Inheritance) 보다 컴포지션(Composition)을 통한 비교를 해야 한다
public class CompareTest {

    @Test
    public void 대소문자구분없는_문자열_대칭성_위배_테스트() {
        CaseInsensitiveString s1 = new CaseInsensitiveString("case-insensitive-string");
        CaseInsensitiveString s2 = new CaseInsensitiveString("Case-Insensitive-String");
        assertEquals(s1, s2);

        CaseInsensitiveString s3 = new CaseInsensitiveString("case-insensitive-string");
        String s4 = new String("Case-Insensitive-String");
        assertEquals(s3, s4);

        String s5 = new String("Case-Insensitive-String");
        CaseInsensitiveString s6 = new CaseInsensitiveString("case-insensitive-string");
        assertNotEquals(s5, s6);
    }

    @Test // (expected = AssertionError.class)
    public void 좌표객체와_상속받은객체_대칭성_위배_테스트() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        assertEquals(p1, p2);

        ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
        ColorPoint cp2 = new ColorPoint(1, 2, Color.RED);
        assertEquals(cp1, cp2);

        assertEquals(p1, cp1); // equals but
        assertNotEquals(cp1, p1); // not equals
    }

    @Test
    public void 좌표객체와_상속받은객체_이행성_위배_테스트() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        assertEquals(p1, p2);

        ColorPoint2 cp1 = new ColorPoint2(1, 2, Color.RED);
        ColorPoint2 cp2 = new ColorPoint2(1, 2, Color.RED);
        assertEquals(cp1, cp2);

        assertEquals(p1, cp1); // equals but
        assertEquals(cp1, p1); // equals also

        ColorPoint2 cp3 = new ColorPoint2(1, 2, Color.BLUE);
        assertEquals(cp1, p1); // equals
        assertEquals(p1, cp3); // equals also
        assertNotEquals(cp1, cp3); // but not equals
    }

    @Test
    public void 상속대신_컴포지션_통한_비교_테스트() {
        ColorPoint3 cp1 = new ColorPoint3(new Point(1, 2), Color.RED);
        ColorPoint3 cp2 = new ColorPoint3(new Point(1, 2), Color.RED);
        assertEquals(cp1, cp2);
    }

}
