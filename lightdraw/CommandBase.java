public interface CommandBase {
	public void executeCommand(DrawCommand drawCommand);
	public void undo();
	public void redo();
	public void showCurrentCommands();
}
