package me.suhyuk.objects.movie.conditions;

import me.suhyuk.objects.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
