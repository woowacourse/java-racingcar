import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DelimiterAndTale {
    private String delimiter;
    private String tale;

    public DelimiterAndTale(String delimiter, String tale) {
        this.delimiter = delimiter;
        this.tale = tale;
    }

    public List<String> split() {
        return Arrays.asList(tale.split(delimiter));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DelimiterAndTale that = (DelimiterAndTale) o;
        return Objects.equals(delimiter, that.delimiter) &&
                Objects.equals(tale, that.tale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiter, tale);
    }

}
