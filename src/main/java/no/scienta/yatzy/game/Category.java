package no.scienta.yatzy.game;

import no.scienta.yatzy.die.Die;
import no.scienta.yatzy.rules.ChanceRule;
import no.scienta.yatzy.rules.EqualsRule;
import no.scienta.yatzy.rules.LargeStraightRule;
import no.scienta.yatzy.rules.NMOfAKindRule;
import no.scienta.yatzy.rules.Rule;
import no.scienta.yatzy.rules.SmallStraightRule;
import no.scienta.yatzy.rules.YatzyRule;

/**
 * @author Sindre Mehus
 */
public enum Category {
    ONES(new EqualsRule(Die.Value.ONE)),
    TWOS(new EqualsRule(Die.Value.TWO)),
    THREES(new EqualsRule(Die.Value.THREE)),
    FOURS(new EqualsRule(Die.Value.FOUR)),
    FIVES(new EqualsRule(Die.Value.FIVE)),
    SIXES(new EqualsRule(Die.Value.SIX)),

    ONE_PAIR(new NMOfAKindRule(2)),
    TWO_PAIRS(new NMOfAKindRule(2, 2)),
    THREE_OF_A_KIND(new NMOfAKindRule(3)),
    FOUR_OF_A_KIND(new NMOfAKindRule(4)),
    SMALL_STRAIGHT(new SmallStraightRule()),
    LARGE_STRAIGHT(new LargeStraightRule()),
    FULL_HOUSE(new NMOfAKindRule(3, 2)),
    CHANCE(new ChanceRule()),
    YATZY(new YatzyRule()),;

    private final Rule rule;

    Category(Rule rule) {
        this.rule = rule;
    }

    public Rule getRule() {
        return rule;
    }
}
