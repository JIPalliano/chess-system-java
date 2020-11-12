package chess.pieces;

import boardgame.Board;
import boardgame.position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		position p = new position(0, 0);

		if (getColor() == Color.WHITE) {
			p.setValues(p.getRow() - 1, p.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(p.getRow() - 2, p.getColumn());
			position p2 = new position(p.getRow() - 1, p.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(p.getRow() - 1, p.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(p.getRow() - 1, p.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			if (p.getRow() == 3) {
				position left = new position(p.getRow(), p.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left)
						&& getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				if (p.getRow() == 3) {
					position right = new position(p.getRow(), p.getColumn() + 1);
					if (getBoard().positionExists(right) && isThereOpponentPiece(right)
							&& getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
						mat[right.getRow() - 1][right.getColumn()] = true;
					}
				}

			} else {
				p.setValues(p.getRow() + 1, p.getColumn());
				if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}

				p.setValues(p.getRow() + 2, p.getColumn());
				position p3 = new position(p.getRow() + 1, p.getColumn());
				if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p3)
						&& !getBoard().thereIsAPiece(p3) && getMoveCount() == 0) {
					mat[p.getRow()][p.getColumn()] = true;
				}

				p.setValues(p.getRow() + 1, p.getColumn() + 1);
				if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}

				p.setValues(p.getRow() + 1, p.getColumn() - 1);
				if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}

				if (p.getRow() == 4) {
					position left = new position(p.getRow(), p.getColumn() - 1);
					if (getBoard().positionExists(left) && isThereOpponentPiece(left)
							&& getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
						mat[left.getRow() + 1][left.getColumn()] = true;
					}
					if (p.getRow() == 4) {
						position right = new position(p.getRow(), p.getColumn() + 1);
						if (getBoard().positionExists(right) && isThereOpponentPiece(right)
								&& getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
							mat[right.getRow() + 1][right.getColumn()] = true;
						}
					}
				}
			}
		}
		return mat;
	}

	@Override
	public String toString() {
		return "p";
	}

}
