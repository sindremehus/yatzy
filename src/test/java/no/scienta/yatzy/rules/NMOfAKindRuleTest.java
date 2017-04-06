package no.scienta.yatzy.rules;

import org.junit.Test;

import no.scienta.yatzy.die.RiggedDieValueGenerator;
import no.scienta.yatzy.game.Hand;

import static no.scienta.yatzy.die.Die.Value.SIX;
import static no.scienta.yatzy.die.Die.Value.THREE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Sindre Mehus
 */
public class NMOfAKindRuleTest {

    @Test
    public void score() throws Exception {
        Hand hand = Hand.random(new RiggedDieValueGenerator(SIX, THREE, SIX, THREE, THREE));
        assertThat(new NMOfAKindRule(2, 0).score(hand), equalTo(12));
        assertThat(new NMOfAKindRule(3, 0).score(hand), equalTo(9));
        assertThat(new NMOfAKindRule(4, 0).score(hand), equalTo(0));
        assertThat(new NMOfAKindRule(2, 2).score(hand), equalTo(18));
        assertThat(new NMOfAKindRule(2, 3).score(hand), equalTo(21));
        assertThat(new NMOfAKindRule(3, 2).score(hand), equalTo(21));
        assertThat(new NMOfAKindRule(3, 3).score(hand), equalTo(0));
    }

}