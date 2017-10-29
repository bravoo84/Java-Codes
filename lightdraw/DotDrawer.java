public class DotDrawer extends AbstractDrawer {
	private static final String DOT_CHARACTER ="*";
	public DotDrawer(Window window, int xCoordinate, int yCoordinate) {
		super(window, xCoordinate, yCoordinate);
	}

	@Override
	public void draw() {
		drawPixel(getxCoordinate(), getyCoordinate(), DOT_CHARACTER);
	}

	@Override
	public String toString() {
		return "DotDrawer [getxCoordinate()=" + getxCoordinate() + ", getyCoordinate()=" + getyCoordinate() + "]";
	}
}
