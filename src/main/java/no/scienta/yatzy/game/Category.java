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
    ONES(new EqualsRule(Die.Value.ONE), true),
    TWOS(new EqualsRule(Die.Value.TWO), true),
    THREES(new EqualsRule(Die.Value.THREE), true),
    FOURS(new EqualsRule(Die.Value.FOUR), true),
    FIVES(new EqualsRule(Die.Value.FIVE), true),
    SIXES(new EqualsRule(Die.Value.SIX), true),

    ONE_PAIR(new NMOfAKindRule(2), false),
    TWO_PAIRS(new NMOfAKindRule(2, 2), false),
    THREE_OF_A_KIND(new NMOfAKindRule(3), false),
    FOUR_OF_A_KIND(new NMOfAKindRule(4), false),
    SMALL_STRAIGHT(new SmallStraightRule(), false),
    LARGE_STRAIGHT(new LargeStraightRule(), false),
    FULL_HOUSE(new NMOfAKindRule(3, 2), false),
    CHANCE(new ChanceRule(), false),
    YATZY(new YatzyRule(), false),;

    private final Rule rule;
    private final boolean upperSection;

    Category(Rule rule, boolean upperSection) {
        this.rule = rule;
        this.upperSection = upperSection;
    }

    public Rule getRule() {
        return rule;
    }

    public boolean isUpperSection() {
        return upperSection;
    }

    public boolean isLowerSection() {
        return !upperSection;
    }
}
