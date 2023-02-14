package common;

public class ExecuteContext {

    public <T> T workWithOptionStrategy(ExecuteStrategy<T> executeStrategy) {
        T result = null;
        while (result == null) {
            try {
                result = executeStrategy.executeOption();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
}
