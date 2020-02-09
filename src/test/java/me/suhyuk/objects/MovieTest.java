package me.suhyuk.objects;

import me.suhyuk.objects.movie.conditions.PeriodCondition;
import me.suhyuk.objects.movie.conditions.SequenceCondition;
import me.suhyuk.objects.movie.policies.AmountDiscountPolicy;
import me.suhyuk.objects.movie.Movie;
import me.suhyuk.objects.movie.policies.PercentDiscountPolicy;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void testMovieFee() {
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
                        )
        );
        Screening screening = new Screening(avatar, 10, LocalDateTime.of(2020, 1, 1, 0, 0));
        Money actual = avatar.calculateMovieFee(screening);
        Money expected = Money.wons(9200);
        assertEquals(expected, actual);

        /*Movie titanic = new Movie("타이타닉",
                Duration.ofMinutes(140),
                Money.wons(12000),
                new PercentDiscountPolicy(0.1,
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
                )
        );*/
    }
}
