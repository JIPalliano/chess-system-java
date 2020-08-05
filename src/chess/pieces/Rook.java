package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;

public class Rook extends ChessPiece {

	public Rook(Board board, chess.color color) {
		super(board, color);
		
	}

	@Override
	public String toString() {
		return "R";
	}
	

}