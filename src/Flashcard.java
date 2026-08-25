import java.util.Random;

public class Flashcard<V, Integer extends Comparable<Integer>> implements Prioritized<V, Integer> {
    private Integer _priority;
    private V _value;

    /**
     * 1st constructor that sets both value and priority
     * @param value the value to be set
     * @param priority priority to be set
     */
    public Flashcard(V value, Integer priority) {
        this._value = value;
        this._priority = priority;
    }

    /**
     * 2nd constructor that takes only value and randomly sets priority
     * @param value the value to be set
     */
    public Flashcard(V value) {
        this._value = value;
        this._priority = (Integer) new java.lang.Integer(0);
    }

    /**
     * @return the _value field.
     */
    @Override
    public V getValue() {
        return _value;
    }

    /**
     * @return returns _priority field.
     */
    @Override
    public Integer getPriority() {
        return _priority;
    }

    public void setPriority(Integer newPriority) {
        this._priority = newPriority;
    }

    /**
     * This helper method sets _priority field to an integer between 0 and 999,999 (i.e. 1000,000-1).
     */
    private void randomizePriority() {
        Random random = new Random();
        this._priority = (Integer) new java.lang.Integer(random.nextInt(1000000));
    }

    /**
     * @param other The 'other' item to be compared with
     * @return int 0 if priorities are equal, or <0 if (this.getPriority < other.getPriority), or >0 otherwise.
     */
    public int compareTo(Prioritized<V, Integer> other) {
        return this._priority.compareTo(other.getPriority());
    }
}