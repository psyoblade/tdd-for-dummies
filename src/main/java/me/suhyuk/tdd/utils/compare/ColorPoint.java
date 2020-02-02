package me.suhyuk.tdd.utils.compare;

import java.awt.*;

public final class ColorPoint extends Point {
    private final Color color;
    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        ColorPoint cp = (ColorPoint) o;
        return super.equals(o) && (this.color == cp.color);
    }
}
