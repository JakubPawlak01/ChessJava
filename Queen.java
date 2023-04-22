public class Queen extends Piece{
    public Queen(boolean white, String name){
        super(white, name);
    }

    public boolean canMove(ChessBoard board, Square start, Square end) {

        if (end.getX() < 0 || end.getX() > 7 || end.getY() < 0 || end.getY() > 7) {
            return false;
        }

        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            return false;
        }

        if (!isMoveStraight(start, end) && !isMoveDiagonal(start, end)) {
            return false;
        }
        
        if (end.getPiece() == null || end.getPiece().isWhite() != this.isWhite()) {
            int dx = Integer.compare(end.getX(), start.getX());
            int dy = Integer.compare(end.getY(), start.getY());
            int x = start.getX() + dx;
            int y = start.getY() + dy;
            while (x != end.getX() || y != end.getY()) {
                if (board.getSquare(x, y).getPiece() != null) {
                    return false;
                }
                x += dx;
                y += dy;
            }
            return true;
        }
        return false;
    }

    private boolean isMoveStraight(Square start, Square end) {
        return start.getX() == end.getX() || start.getY() == end.getY();
    }

    private boolean isMoveDiagonal(Square start, Square end) {
        int dx = Math.abs(end.getX() - start.getX());
        int dy = Math.abs(end.getY() - start.getY());
        return dx == dy;
    }
};
