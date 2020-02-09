package me.suhyuk.objects.movie.policies;

import me.suhyuk.objects.Money;
import me.suhyuk.objects.Screening;
import me.suhyuk.objects.movie.conditions.DiscountCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {

    private List<DiscountCondition> conditions = new ArrayList<>();

    DiscountPolicy(DiscountCondition ... items) {
        this.conditions.addAll(Arrays.asList(items));
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    public abstract Money getDiscountAmount(Screening screening);
}
