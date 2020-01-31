package me.suhyuk.tdd;

public class Positive {

    private final String NEGATIVE_VALUE = "음수는 허용되지 않습니다";
    private int number = 0;

    public Positive(String number) {
        this(Integer.parseInt(number));
    }

    Positive(int number) {
        if (number < 0) throw new RuntimeException(NEGATIVE_VALUE);
        this.number = number;
    }

    int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Positive add(Positive that) {
        return new Positive(this.number + that.number);
    }
}
