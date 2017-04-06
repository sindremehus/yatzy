package no.scienta.yatzy.rules;

import org.junit.Test;

import no.scienta.yatzy.die.RiggedDieValueGenerator;
import no.scienta.yatzy.game.Hand;

import static no.scienta.yatzy.die.Die.Value.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Sindre Mehus
 */
public class EqualsRuleTest {

    @Test
    public void score() throws Exception {
        Hand hand = Hand.random(new RiggedDieValueGenerator(ONE, THREE, SIX, THREE, THREE));
        assertThat(new EqualsRule(THREE).score(hand), equalTo(9));
        assertThat(new EqualsRule(TWO).score(hand), equalTo(0));
    }
}