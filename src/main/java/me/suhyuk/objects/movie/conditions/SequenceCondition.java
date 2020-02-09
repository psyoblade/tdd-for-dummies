package me.suhyuk.objects.movie.conditions;

import me.suhyuk.objects.Screening;

public class SequenceCondition implements DiscountCondition{

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(this.sequence);
    }
}
