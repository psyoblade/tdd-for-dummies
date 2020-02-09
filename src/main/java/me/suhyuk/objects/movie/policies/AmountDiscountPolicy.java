package me.suhyuk.objects.movie.policies;

import me.suhyuk.objects.Money;
import me.suhyuk.objects.Screening;
import me.suhyuk.objects.movie.conditions.DiscountCondition;

public class AmountDiscountPolicy extends DiscountPolicy {

    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    public Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
