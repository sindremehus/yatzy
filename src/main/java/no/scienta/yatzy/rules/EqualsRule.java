package no.scienta.yatzy.rules;

import no.scienta.yatzy.die.Die;
import no.scienta.yatzy.game.Hand;

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
