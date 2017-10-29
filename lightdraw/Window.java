import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Window {
	/**
	 * Key is row number
	 * Value is another map, whose key is column number, and value is the character
	 */
	private Map<Integer, Map<Integer, String>> screen = new TreeMap<Integer, Map<Integer, String>>();
	private static final int WINDOW_SIZE = 20 ;
	
	/**
	 * Draw an empty screen, with pounds as chars
	 */
	public void init() {
		for(int i = 0; i < WINDOW_SIZE ; i ++) {
			Map<Integer, String> row = new TreeMap<Integer, String>();
			for(int j = 0; j < WINDOW_SIZE ; j ++) {
				row.put(j, " ");
			}	
			screen.put(i, row);
		}
	}
	
	public void render() {
		System.out.println("[Screen");
		System.out.println("  ------------------------------------------");
		
		for (int rowNumber : screen.keySet()) {
			Map<Integer, String> row = screen.get(rowNumber);
			System.out.print(" | ");
			
			for (int columnNumber : row.keySet() ) {
				
				String pixel = row.get(columnNumber);
				System.out.print(pixel + " ");
			}
			System.out.print(" | ");
			
			System.out.println("");
		}

		System.out.println("  ------------------------------------------");
	}
	
	public void draw(int row, int col, String character) {
		if(row  < 0 || row > WINDOW_SIZE -1 || col < 0  || col > WINDOW_SIZE -1 ) {
			throw new IllegalArgumentException("OUT OF BOUNDS KA BOY!");
		}
		this.screen.get(row).put(col, character);
	}
	public String getPixel(int row, int col) {
		if(row  < 0 || row > WINDOW_SIZE -1 || col < 0  || col > WINDOW_SIZE -1 ) {
			throw new IllegalArgumentException("OUT OF BOUNDS KA BOY!");
		}
		return this.screen.get(row).get(col);
	}
}
