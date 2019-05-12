package cal;

public enum Operator {
    PLUS("+", (former, letter) -> former + letter),
    MINUS("-", (former, letter) -> former - letter),
    MULTIFLY("*", (former, letter) -> former * letter),
    DIVIDE("/", (former, letter) -> former / letter);

    private String value;
    private Calculation<Integer, Integer, Integer> calculation;

    Operator(String value, Calculation<Integer, Integer, Integer> calculation){
        this.value = value;
        this.calculation = calculation;
    }

    public int calculate(int former, int letter){
        return calculation.apply(former, letter);
    }

    public static Operator getOperator(String operator){
        for (Operator oper : values())
            if (oper.value.equals(operator)) return oper;
        throw new IllegalArgumentException();
    }
}
