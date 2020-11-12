package chess.pieces;

import boardgame.Board;
import boardgame.position;
import chess.ChessPiece;
import chess.ChessMatch;

public class King extends ChessPiece{
	
	private ChessMatch chessMatch;

	public King(Board board, chess.Color color) {
		super(board, color);
		this.chessMatch = chessMatch;
		
	}
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastling(position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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
		
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			position posT1 = new position(p.getRow(), p.getColumn() + 3);
			if (testRookCastling(posT1)) {
				position p1 = new position(p.getRow(), p.getColumn() + 1);
				position p2 = new position(p.getRow(), p.getColumn() + 2);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[p.getRow()][p.getColumn() + 2] = true;
				}
			}
		}

		position posT2 = new position(p.getRow(), p.getColumn() - 4);
		if (testRookCastling(posT2)) {
			position p1 = new position(p.getRow(), p.getColumn() - 1);
			position p2 = new position(p.getRow(), p.getColumn() - 2);
			position p3 = new position(p.getRow(), p.getColumn() - 3);
			if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
				mat[p.getRow()][p.getColumn() - 2] = true;
			}
		}
		
		return mat;
	}

}
