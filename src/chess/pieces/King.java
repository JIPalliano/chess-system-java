package chess.pieces;

import boardgame.Board;
import boardgame.position;
import chess.ChessPiece;

public class King extends ChessPiece{

	public King(Board board, chess.color color) {
		super(board, color);
		
	}
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		position p = new position(0, 0);
		
		p.setValues(pos.getRow() - 1, pos.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(pos.getRow() + 1, pos.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(pos.getRow(), pos.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(pos.getRow(), pos.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(pos.getRow() - 1, pos.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(pos.getRow() + 1, pos.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(pos.getRow() + 1, pos.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(pos.getRow() - 1, pos.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
	}

}
