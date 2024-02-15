package domain;

public class Name {
    private String value;
    private static final Integer LENGTH_LIMIT = 5;

    public Name(String value) {
        validate(value);
        this.value = value;
    }
    private void validate(String value){
        if(value.isBlank()){
            throw new IllegalArgumentException("blank");
        }
        if(value.length()>LENGTH_LIMIT){
            throw new IllegalArgumentException();
        }
    }

    public String getValue() {
        return value;
    }
}
