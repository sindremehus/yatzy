package no.scienta.yatzy.rules;

import no.scienta.yatzy.die.Die;
import no.scienta.yatzy.game.Hand;

/**
 * N dice of one kind, and M dice of another kind.
 * <p>
 * Generalization of one pair, two pairs, three of a kind, four of a kind, and full house.
 *
 * @author Sindre Mehus
 */
public class NMOfAKindRule extends Rule {

    private final int n;
    private final int m;

    public NMOfAKindRule(int n) {
        this(n, 0);
    }

    public NMOfAKindRule(int n, int m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public int score(Hand hand) {
        for (Die.Value a : Die.Value.DESCENDING) {
            for (Die.Value b : Die.Value.DESCENDING) {
                if (a == b) {
                    continue;
                }
                if (getCount(hand, a) >= n && getCount(hand, b) >= m) {
                    return a.getValue() * n + b.getValue() * m;
                }
            }
        }
        return 0;
    }
}
