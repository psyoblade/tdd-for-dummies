package me.suhyuk.tdd.utils.compare;

import java.awt.*;

public class ColorPoint3 {
    private final Point point;
    private final Color color;
    public ColorPoint3(Point point, Color color) {
        this.point = point;
        this.color = color;
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint3))
            return super.equals(o);
        ColorPoint3 cp = (ColorPoint3) o;
        return point.equals(cp.point) && color.equals(cp.color);
    }
}
