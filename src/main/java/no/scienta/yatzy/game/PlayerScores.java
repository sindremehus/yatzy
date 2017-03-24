package no.scienta.yatzy.game;

import java.util.LinkedHashMap;
import java.util.Map;

import no.scienta.yatzy.Category;
import no.scienta.yatzy.Hand;

/**
 * @author Sindre Mehus
 */
public class PlayerScores {

    private final Player player;
    private final Map<Category, Integer> scores = new LinkedHashMap<>();

    public PlayerScores(Player player) {
        this.player = player;
    }

    public int sum() {
        // TODO: Bonus
        return scores.values().stream()
                     .mapToInt(Integer::intValue)
                     .sum();
    }

    public void registerScore(Hand hand, Category category) {
        int score = category.getRule().score(hand);
        if (scores.putIfAbsent(category, score) != null) {
            throw new IllegalArgumentException("Already registered score for " + category + " for player " + player.getName());
        }
    }
}


