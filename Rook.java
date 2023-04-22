public class Rook extends Piece{
    public boolean firstMove = true;
    public Rook(boolean white, String name){
        super(white, name);
    }
    public void setFirstMove(){
        firstMove = false;
    }
    public boolean canMove(ChessBoard board, Square start, Square end) {
        if (end.getX() < 0 || end.getX() > 7 || end.getY() < 0 || end.getY() > 7) {
            return false;
        }

        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            return false;
        }

        if (start == end) {
            return false;
        }

        if (start.getX() != end.getX() && start.getY() != end.getY()) {
            return false;
        }

        int xDiff = Integer.compare(end.getX(), start.getX());
        int yDiff = Integer.compare(end.getY(), start.getY());

        int x = start.getX() + xDiff;
        int y = start.getY() + yDiff;

        while (x != end.getX() || y != end.getY()) {
            if (board.board[x][y].getPiece() != null) {
                return false;
            }
            x += xDiff;
            y += yDiff;
        }

        if(end.getPiece() == null || end.getPiece().isWhite() != start.getPiece().isWhite()){
            return true;
        }
        return false;
    }
}
