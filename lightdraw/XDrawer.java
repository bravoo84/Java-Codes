import java.util.HashMap;
import java.util.Map;


public class XDrawer extends AbstractDrawer {
	private static final String X_CHARACTER = "X";
	private int size;
	
	public XDrawer(Window window, int xCoordinate, int yCoordinate, int size) {
		super(window, xCoordinate, yCoordinate);
		this.size = size;
	}

	@Override
	public void draw() {
		drawPixel(this.getxCoordinate(), this.getyCoordinate(), X_CHARACTER);
		for (int offset = 1; offset < size; offset ++) {
			drawPixel(this.getxCoordinate()+offset, this.getyCoordinate()+offset, X_CHARACTER);
			drawPixel(this.getxCoordinate()-offset, this.getyCoordinate()-offset, X_CHARACTER);
			drawPixel(this.getxCoordinate()+offset, this.getyCoordinate()-offset, X_CHARACTER);
			drawPixel(this.getxCoordinate()-offset, this.getyCoordinate()+offset, X_CHARACTER);
		}
	}

	@Override
	public String toString() {
		return "XDrawer [size=" + size + ", getxCoordinate()=" + getxCoordinate() + ", getyCoordinate()="
				+ getyCoordinate() + "]";
	}

}
