package no.scienta.yatzy.die;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sindre Mehus
 */
public class RiggedDieValueGenerator implements DieValueGenerator {

    private final List<Die.Value> values = new ArrayList<>();
    private int index;

    public RiggedDieValueGenerator(List<Die.Value> values) {
        this.values.addAll(values);
    }

    public RiggedDieValueGenerator(Die.Value... values) {
        this(Arrays.asList(values));
    }

    public void add(Die.Value... values) {
        this.values.addAll(Arrays.asList(values));
    }

    @Override
    public Die.Value next() {
        return values.get(index++);
    }
}
