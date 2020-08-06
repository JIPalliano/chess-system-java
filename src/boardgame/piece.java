package boardgame;

public abstract class piece {

	protected position pos;
	private Board board;
	
	protected Board getBoard() {
		return board;
	}


	public piece(Board board) {
		this.board = board;
	}
	
	public abstract boolean [][] possibleMoves();
	
	public boolean possibleMove(position pos) {
		return possibleMoves()[pos.getRow()][pos.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int i=0; i<mat.length;i++) {
			for(int j=0;j<mat.length;j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
}
