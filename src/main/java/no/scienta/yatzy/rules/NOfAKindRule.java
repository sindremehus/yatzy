package no.scienta.yatzy.rules;

import no.scienta.yatzy.Hand;
import no.scienta.yatzy.die.Die;

/**
 * @author Sindre Mehus
 */
public class NOfAKindRule extends Rule {

    private final int n;
    private final int m;

    public NOfAKindRule(int n) {
        this(n, 0);
    }

    public NOfAKindRule(int n, int m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public int score(Hand hand) {


// TODO


        int score = 0;
        for (Die.Value value : Die.Value.DESCENDING) {
            if (getCount(hand, value) >= n) {
                score = value.getValue() * n;
                break;
            }
        }

        if (m > 0) {

        }


        return 0;
    }
}
