package chess;

import boardgame.Board;

import boardgame.piece;
import boardgame.position;

public abstract class ChessPiece extends piece {
	
	private color color;

	public ChessPiece(Board board, chess.color color) {
		super(board);
		this.color = color;
	}

	public color getColor() {
		return color;
	}
	
	protected boolean isThereOpponentPiece(position pos) {
		ChessPiece p = (ChessPiece)getBoard().piece(pos);
		return p != null && p.getColor() != color;
	}

}
