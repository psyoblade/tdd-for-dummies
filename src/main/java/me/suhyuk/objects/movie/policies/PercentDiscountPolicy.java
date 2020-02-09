package me.suhyuk.objects.movie.policies;

import me.suhyuk.objects.Money;
import me.suhyuk.objects.Screening;
import me.suhyuk.objects.movie.conditions.DiscountCondition;

public class PercentDiscountPolicy extends DiscountPolicy {

    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    public Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
