import java.util.Random;

public class Flashcard{
    private int _priority;
    private String _value;

    /**
     * 1st constructor that sets both value and priority
     *
     * @param value    the value to be set
     * @param priority priority to be set
     */
    public Flashcard(String value, int priority) {
        this._value = value;
        this._priority = priority;
    }

    /**
     * 2nd constructor that takes only value and randomly sets priority
     *
     * @param value the value to be set
     */
    public Flashcard(String value) {
        this._value = value;
        this._priority = 100;
    }

    public String getValue() {
        return _value;
    }

    public Integer getPriority() {
        return _priority;
    }

    public void setPriority(int newPriority) {
        this._priority = newPriority;
    }

    /**
     * This helper method sets _priority field to an integer between 0 and 999,999 (i.e. 1000,000-1).
     */
    private void randomizePriority() {
        Random random = new Random();
        this._priority = new java.lang.Integer(random.nextInt(1000000));
    }
}
