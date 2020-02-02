package me.suhyuk.tdd.utils.compare;

import java.awt.*;

public class ColorPoint2 extends Point {
    private final Color color;
    public ColorPoint2(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        if (!(o instanceof ColorPoint2))
            return super.equals(o);
        ColorPoint2 cp = (ColorPoint2) o;
        return super.equals(o) && (this.color == cp.color);
    }
}
