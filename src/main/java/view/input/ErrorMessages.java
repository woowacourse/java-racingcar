package view.input;


public enum ErrorMessages {
    private final String content;

    ErrorMessages(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
