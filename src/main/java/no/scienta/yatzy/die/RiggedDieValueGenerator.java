package no.scienta.yatzy.die;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Sindre Mehus
 */
public class RiggedDieValueGenerator implements DieValueGenerator {

    private final Iterator<Die.Value> values;

    public RiggedDieValueGenerator(Iterable<Die.Value> values) {
        this.values = values.iterator();
    }

    public RiggedDieValueGenerator(Die.Value... values) {
        this(Arrays.asList(values));
    }

    @Override
    public Die.Value next() {
        return values.next();
    }
}
