package no.scienta.yatzy.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import no.scienta.yatzy.die.Die;
import no.scienta.yatzy.die.DieValueGenerator;
import no.scienta.yatzy.die.RandomDieValueGenerator;

/**
 * @author Sindre Mehus
 */
public class Game {

    private final Map<Player, PlayerScores> scores = new LinkedHashMap<>();
    private final DieValueGenerator dieValueGenerator;

    public Game(List<Player> players) {
        this(players, new RandomDieValueGenerator());
    }

    public Game(List<Player> players, DieValueGenerator dieValueGenerator) {
        this.dieValueGenerator = dieValueGenerator;
        players.forEach(player -> scores.put(player, new PlayerScores(player)));
    }

    public Hand randomHand() {
        return Hand.random(dieValueGenerator);
    }

    public Hand rethrow(Hand hand, List<Die> diceToRethrow) {
        List<Die> newDice = new ArrayList<>();
        for (Die die : hand.getDice()) {
            newDice.add(diceToRethrow.contains(die) ? Die.random(dieValueGenerator) : die);
        }
        return new Hand(newDice);
    }

    public void registerScore(Player player, Hand hand, Category category) {
        scores.get(player).registerScore(hand, category);
    }

    public Map<Player, PlayerScores> getScores() {
        return Collections.unmodifiableMap(scores);
    }
}
