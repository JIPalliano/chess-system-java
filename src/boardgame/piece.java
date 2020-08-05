package boardgame;

public class piece {

	protected position pos;
	private Board board;
	
	protected Board getBoard() {
		return board;
	}


	public piece(Board board) {
		this.board = board;
	}
	
	
	
}
