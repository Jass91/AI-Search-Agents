package core;

public class FreePosition {

	private int line;
	private int column;
	
	public FreePosition(int line, int column) {
		this.line = line;
		this.column = column;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}
}
