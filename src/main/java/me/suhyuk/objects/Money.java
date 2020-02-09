package me.suhyuk.objects;

import java.math.BigDecimal;

/**
 * 돈을 계산하는 클래스인데, BigDecimal 타입으로 더하기, 빼기 그리고 곱하기 연산을 수행할 수 있어야 합니다
 */
public class Money {

    public static final Money ZERO = Money.wons(0);
    private final BigDecimal amount;

    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }

    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }

    public Money times(double percent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public boolean isLessThan(Money other) {
        return this.amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanEqual(Money other) {
        return this.amount.compareTo(other.amount) >= 0;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    // 값만 같으면 동일한 값으로 처리하도록 Override
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Money)) return false;
        Money money = (Money) other;
        return amount.compareTo(money.getAmount()) == 0;
    }
}
