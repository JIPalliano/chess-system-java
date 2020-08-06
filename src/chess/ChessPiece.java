package chess;

import boardgame.Board;
import boardgame.piece;

public abstract class ChessPiece extends piece {
	
	private color color;

	public ChessPiece(Board board, chess.color color) {
		super(board);
		this.color = color;
	}

	public color getColor() {
		return color;
	}

	
}
