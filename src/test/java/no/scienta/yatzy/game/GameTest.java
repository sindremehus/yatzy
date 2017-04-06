package no.scienta.yatzy.game;

import java.util.Arrays;

import org.junit.Test;

import no.scienta.yatzy.die.RiggedDieValueGenerator;

import static java.util.Arrays.asList;
import static no.scienta.yatzy.die.Die.Value.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Sindre Mehus
 */
public class GameTest {

    @Test
    public void example() throws Exception {

        RiggedDieValueGenerator generator = new RiggedDieValueGenerator();
        Player playerA = new Player("a");
        Player playerB = new Player("b");
        Game game = new Game(asList(playerA, playerB), generator);

        generator.add(ONE, THREE, FIVE, SIX, FOUR);
        Hand hand = game.randomHand();
        assertThat(hand.toString(), equalTo("1 3 5 6 4"));

        generator.add(SIX, ONE);
        hand = game.rethrow(hand, Arrays.asList(hand.getDie(0), hand.getDie(4)));
        assertThat(hand.toString(), equalTo("6 3 5 6 1"));

        game.registerScore(playerA, hand, Category.CHANCE);
        assertThat(game.getScores().get(playerA).sum(), equalTo(21));
        assertThat(game.getScores().get(playerB).sum(), equalTo(0));
    }
}