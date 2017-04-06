package no.scienta.yatzy.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import no.scienta.yatzy.die.Die;
import no.scienta.yatzy.die.DieValueGenerator;

/**
 * A "hand" of five dice.
 * <p>
 * This class is immutable.
 *
 * @author Sindre Mehus
 */
public class Hand {

    public final static int DICE_COUNT = 5;

    private final List<Die> dice;

    Hand(List<Die> dice) {
        this.dice = dice;
    }

    public static Hand random(DieValueGenerator generator) {
        List<Die> dice = new ArrayList<>();
        for (int i = 0; i < DICE_COUNT; i++) {
            dice.add(Die.random(generator));
        }
        return new Hand(dice);
    }

    public List<Die> getDice() {
        return Collections.unmodifiableList(dice);
    }

    public Die getDie(int index) {
        return dice.get(index);
    }

    public List<Die.Value> getDiceValues() {
        return dice.stream().map(Die::getValue).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return dice.stream().map(Die::toString).collect(Collectors.joining(" "));
    }
}
