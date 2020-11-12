package chess;

import boardgame.Board;
import boardgame.piece;
import boardgame.position;

public abstract class ChessPiece extends piece {
	
	private Color color;
	private int moveCount;

	public ChessPiece(Board board, chess.Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	public void increaseMoveCount() {
		moveCount++;
	}
	
	public void decreaseMoveCount() {
		moveCount--;
	}
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(pos);
	}
	
	protected boolean isThereOpponentPiece(position pos) {
		ChessPiece p = (ChessPiece)getBoard().piece(pos);
		return p != null && p.getColor() != color;
	}

}
