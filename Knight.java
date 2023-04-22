public class Knight extends Piece{
    public Knight(boolean white, String name){
        super(white, name);
    }

    public boolean canMove(ChessBoard board, Square start, Square end) {
        if (end.getX() < 0 || end.getX() > 7 || end.getY() < 0 || end.getY() > 7) {
            return false;
        }

        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            return false;
        }

        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();

        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);

        if ((dx == 1 && dy == 2) || (dx == 2 && dy == 1)) {
            if (end.getPiece() == null || end.getPiece().isWhite() != this.isWhite()) {
                return true;
            }
        }

        return false;
    }
}
