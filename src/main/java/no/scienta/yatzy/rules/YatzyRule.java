package no.scienta.yatzy.rules;

import no.scienta.yatzy.die.Die;
import no.scienta.yatzy.game.Hand;

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
