package me.suhyuk.objects.movie;

import me.suhyuk.objects.Money;
import me.suhyuk.objects.Screening;
import me.suhyuk.objects.movie.conditions.DiscountCondition;
import me.suhyuk.objects.movie.policies.DiscountPolicy;

import java.time.Duration;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(this.discountPolicy.calculateDiscountAmount(screening));
    }

    public Money getFee() {
        return fee;
    }
}
