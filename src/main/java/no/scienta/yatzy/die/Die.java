package no.scienta.yatzy.die;

import java.util.Arrays;
import java.util.List;

/**
 * A die with a given face value.
 * <p>
 * This class is immutable.
 *
 * @author Sindre Mehus
 */
public class Die {

    private final Value value;

    private Die(Value value) {
        this.value = value;
    }

    public static Die random(DieValueGenerator generator) {
        return new Die(generator.next());
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public enum Value {

        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6);

        public static final List<Value> DESCENDING = Arrays.asList(SIX, FIVE, FOUR, THREE, TWO, ONE);

        private final int value;

        Value(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}


