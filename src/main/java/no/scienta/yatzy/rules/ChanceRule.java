package no.scienta.yatzy.rules;

import no.scienta.yatzy.Hand;

/**
 * @author Sindre Mehus
 */
public class ChanceRule extends Rule {

    @Override
    public int score(Hand hand) {
        return hand.getDice().stream()
                   .mapToInt(die -> die.getValue().getValue())
                   .sum();
    }
}
