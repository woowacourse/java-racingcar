package stringcalculator.domain.Delimiter;

public class DelimiterFactory {
    private static final Delimiter defaultDelimiter = new DefaultDelimiter();

    private DelimiterFactory() {
    }

    public static Delimiter valueOf(String input) {
        if (!CustomDelimiter.isSupport(input)) {
            return defaultDelimiter;
        }

        return CustomDelimiter.valueOf(input);
    }

    public static Delimiter getDefault() {
        return defaultDelimiter;
    }
}