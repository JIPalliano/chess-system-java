package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private piece[][] pieces;
	
	
	
	public int getRows() {
		return rows;
	}


	public int getColumns() {
		return columns;
	}


	public Board(int rows, int columns) {
		if(rows < 1 || columns <1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new piece [rows][columns];
		
	}
	
	public piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces [row][column];
	}
	
	public piece piece(position pos) {
		if(!positionExists(pos)) {
			throw new BoardException("Position not on the board");
		}
		return pieces [pos.getRow()][pos.getColumn()];
	}
	
	public void placePiece(piece piece, position position) { 
		if(thereIsAPiece(position)) {
			throw new BoardException("there is already a piece on position" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.pos = position;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}

}
