package no.scienta.yatzy.rules;

import java.util.Arrays;
import java.util.List;

import no.scienta.yatzy.Hand;
import no.scienta.yatzy.die.Die;

import static no.scienta.yatzy.die.Die.Value.*;

/**
 * @author Sindre Mehus
 */
public class SmallStraightRule extends Rule {

    @Override
    public int score(Hand hand) {
        List<Die.Value> values = hand.getDiceValues();
        return values.containsAll(Arrays.asList(ONE, TWO, THREE, FOUR, FIVE)) ? 15 : 0;
    }
}
