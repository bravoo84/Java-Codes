
import java.util.HashMap;
import java.util.Map;
public abstract class AbstractDrawer implements DrawCommand{
	/**
	 * The receiver
	 */
	private Window window;
	
	private int xCoordinate;
	private int yCoordinate;
	private Map<String, String> prevVals = new HashMap<String, String>();
	
	protected AbstractDrawer(Window window,int xCoordinate, int yCoordinate) {
		super();
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.window = window;
	}
	protected int getxCoordinate() {
		return xCoordinate;
	}
	protected int getyCoordinate() {
		return yCoordinate;
	}
	
	public Window getWindow() {
		return window;
	}
	protected void drawPixel(int x, int y, String character) {
		storePrevVal(x, y, window.getPixel(x, y));
		window.draw(x, y, character);
				
	}
	
	protected void storePrevVal(int x, int y, String prevVal) {
		prevVals.put(x + "-" + y, prevVal);
	}
	@Override
	public void undo() {
		for(String coordinate : prevVals.keySet()) {
			String[] coordinateList = coordinate.split("-");
			int x = Integer.parseInt(coordinateList[0]);
			int y = Integer.parseInt(coordinateList[1]);
			window.draw(x, y, prevVals.get(coordinate));
		}
		
	}
}
