package domain;

public class RacingResult {
	private static final char MOVE_SIGN = '-';
	private static final String NAME_AND_MOVING_ROUTE_FORMAT = "%s : %s \n";

	private final Name name;
	private final String movingRoute;

	public RacingResult(final Name name, final int position) {
		this.name = name;
		this.movingRoute = makeMovingRoute(position);
	}

	private String makeMovingRoute(final int position) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < position; i++) {
			builder.append(MOVE_SIGN);
		}
		return builder.toString();
	}

	@Override
	public String toString() {
		return String.format(NAME_AND_MOVING_ROUTE_FORMAT, name.getName(), movingRoute);
	}

}

