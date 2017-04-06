package no.scienta.yatzy.game;

import java.util.LinkedHashMap;
import java.util.Map;

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
        int upperScores = scores.keySet().stream()
                                .filter(Category::isUpperSection)
                                .mapToInt(scores::get)
                                .sum();

        int lowerScores = scores.keySet().stream()
                                .filter(Category::isLowerSection)
                                .mapToInt(scores::get)
                                .sum();

        int bonus = upperScores >= 63 ? 50 : 0;

        return upperScores + lowerScores + bonus;
    }

    public void registerScore(Hand hand, Category category) {
        int score = category.getRule().score(hand);
        if (scores.putIfAbsent(category, score) != null) {
            throw new IllegalArgumentException("Already registered score for " + category + " for player " + player.getName());
        }
    }
}


