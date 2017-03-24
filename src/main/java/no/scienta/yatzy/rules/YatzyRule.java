package no.scienta.yatzy.rules;

import no.scienta.yatzy.Hand;
import no.scienta.yatzy.die.Die;

/**
 * @author Sindre Mehus
 */
public class YatzyRule extends Rule {

    @Override
    public int score(Hand hand) {
        for (Die.Value value : Die.Value.DESCENDING) {
            if (getCount(hand, value) == Hand.DICE_COUNT) {
                return 50;
            }
        }
        return 0;
    }
}
