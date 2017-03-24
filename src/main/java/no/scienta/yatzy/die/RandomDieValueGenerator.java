package no.scienta.yatzy.die;

import java.util.Random;

/**
 * @author Sindre Mehus
 */
public class RandomDieValueGenerator implements DieValueGenerator {

    private final Random random = new Random(System.currentTimeMillis());

    @Override
    public Die.Value next() {
        int index = random.nextInt(Die.Value.values().length);
        return Die.Value.values()[index];
    }
}
