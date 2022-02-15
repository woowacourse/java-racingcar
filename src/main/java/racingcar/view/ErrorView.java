package racingcar.view;

import racingcar.client.ErrorClient;

public class ErrorView {

    private final ErrorClient errorClient;

    public ErrorView(ErrorClient errorClient) {
        this.errorClient = errorClient;
    }

    public void error(Exception e) {
        errorClient.error(e.getMessage() + "\n");
    }
}
