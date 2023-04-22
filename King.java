public class King extends Piece{
    public boolean castling = false;

    public King(boolean white, String name){
        super(white, name);
    }

    public boolean canMove(ChessBoard board, Square start, Square end) {
        if (end.getX() < 0 || end.getX() > 7 || end.getY() < 0 || end.getY() > 7) {
            return false;
        }

        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            return false;
        }

        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int xDiff = Math.abs(end.getX() - start.getX());
        int yDiff = Math.abs(end.getY() - start.getY());
        if (xDiff > 1 || yDiff > 1) {
            return false;
        }

        return true;
    }

    
}

