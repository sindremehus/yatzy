package no.scienta.yatzy;

import no.scienta.yatzy.die.Die;
import no.scienta.yatzy.rules.ChanceRule;
import no.scienta.yatzy.rules.EqualsRule;
import no.scienta.yatzy.rules.LargeStraightRule;
import no.scienta.yatzy.rules.NOfAKindRule;
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

    ONE_PAIR(new NOfAKindRule(2)),
    THREE_OF_A_KIND(new NOfAKindRule(3)),
    FOUR_OF_A_KIND(new NOfAKindRule(4)),
    CHANCE(new ChanceRule()),
    SMALL_STRAIGHT(new SmallStraightRule()),
    LARGE_STRAIGHT(new LargeStraightRule()),
    YATZY(new YatzyRule()),;

    private final Rule rule;

    Category(Rule rule) {
        this.rule = rule;
    }

    public Rule getRule() {
        return rule;
    }
}
