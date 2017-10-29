public class Eraser extends AbstractDrawer {
	private static final String BLANK_CHARACTER = " ";

	protected Eraser(Window window, int xCoordinate, int yCoordinate) {
		super(window, xCoordinate, yCoordinate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		drawPixel(getxCoordinate(), getyCoordinate(), BLANK_CHARACTER);
	}

	@Override
	public String toString() {
		return "Eraser [getxCoordinate()=" + getxCoordinate() + ", getyCoordinate()=" + getyCoordinate() + "]";
	}
	
	
}
