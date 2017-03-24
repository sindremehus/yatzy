package no.scienta.yatzy.rules;

import no.scienta.yatzy.Hand;
import no.scienta.yatzy.die.Die;

/**
 * @author Sindre Mehus
 */
public class EqualsRule extends Rule {

    private final Die.Value value;

    public EqualsRule(Die.Value value) {
        this.value = value;
    }

    @Override
    public int score(Hand hand) {
        return getCount(hand, value) * value.getValue();
    }
}
