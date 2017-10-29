
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LightDraw {
	
	public static void main (String[] args) throws IOException {
		//This will be the receiver
		Window window = new Window();
		window.init();
		
		//This will invoke commands. Can invoke draw and undo. 
		CommandBase commandBase = CommandBaseImpl.getInstance();
		
		System.out.println("Welcome! What do you want to draw?");
		
		while(true) {
			try {
				if(!captureCommand(window, commandBase)) {
					break;
				}
			} catch (Exception e) {
				System.out.println("Unable to run command. Try again, am sorry TT_TT");
			}
		}
	}

	private static boolean captureCommand(Window window, CommandBase commandBase) throws IOException {
		System.out.println("What do you want to do?");
		System.out.println("[1] Show screen");
		System.out.println("[2] Draw dot (2-x-y)");
		System.out.println("[3] Draw x (3-x-y-size)");
		System.out.println("[4] Draw Square (4-x-y-size)");
		System.out.println("[5] Erase (7-x-y)");
		System.out.println("[6] Undo");
		System.out.println("[7] Redo");
		System.out.println("[8] Show commands");
		System.out.println("[9] Exit");
		

		InputStreamReader in=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(in);
		String choice = br.readLine();
		
		if(choice.equals("9")) {
		   	System.out.println("See you later alligator");
			return false;
		} else if (choice.equals("1")) {
			window.render();
		} else if (choice.startsWith("2")) {
			String[] parts = choice.split("-");
			DrawCommand command = new DotDrawer(window, Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
			commandBase.executeCommand(command);
		} else if (choice.startsWith("3")) {
			String[] parts = choice.split("-");
			DrawCommand command = new XDrawer(window, Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
			commandBase.executeCommand(command);
		} else if (choice.startsWith("4")) {
			String[] parts = choice.split("-");
			DrawCommand command = new SquareDrawer(window, Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
			commandBase.executeCommand(command);
		} else if (choice.equals("6")) {
			commandBase.undo();
		} else if (choice.equals("7")) {
			commandBase.redo();
		} else if (choice.startsWith("5")) {
			String[] parts = choice.split("-");
			DrawCommand command = new Eraser(window, Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
			commandBase.executeCommand(command);
		} else if (choice.equals("8")) {
			commandBase.showCurrentCommands();
		} else {
			System.out.println("Unrecognized command");
		}
		
		return true;
	}
}
