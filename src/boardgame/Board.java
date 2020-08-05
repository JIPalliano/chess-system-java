package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private piece[][] pieces;
	
	
	
	public int getRows() {
		return rows;
	}



	public void setRows(int rows) {
		this.rows = rows;
	}



	public int getColumns() {
		return columns;
	}



	public void setColumns(int columns) {
		this.columns = columns;
	}



	public Board(int rows, int columns) {

		this.rows = rows;
		this.columns = columns;
		pieces = new piece [rows][columns];
		
	}
	
	public piece piece(int row, int column) {
		return pieces [row][column];
	}
	
	public piece piece(position pos) {
		return pieces [pos.getRow()][pos.getColumn()];
	}
	
	public void placePiece(piece piece, position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.pos = position;
	}
	

}
