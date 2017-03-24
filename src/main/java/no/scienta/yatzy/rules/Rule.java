package no.scienta.yatzy.rules;

import no.scienta.yatzy.Hand;
import no.scienta.yatzy.die.Die;

/**
 * @author Sindre Mehus
 */
public abstract class Rule {

    public abstract int score(Hand hand);

    protected int getCount(Hand hand, Die.Value value) {
        return (int) hand.getDice().stream().filter(die -> die.getValue() == value).count();
    }
}
