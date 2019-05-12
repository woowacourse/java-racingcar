package cal;

@FunctionalInterface
public interface Calculation<Former, Letter, Return> {
    Return apply(Former former, Letter letter);
}
