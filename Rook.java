public class Rook extends Piece{
    public Rook(boolean white, String name){
        super(white, name);
    }
    public boolean canMove(ChessBoard board, Square start, Square end) {
        // Sprawdź, czy ruch nie wykracza poza granice szachownicy
        if (end.getX() < 0 || end.getX() > 7 || end.getY() < 0 || end.getY() > 7) {
            return false;
        }

        // Sprawdź, czy ruch nie jest wykonywany na to samo pole
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            return false;
        }

        // Make sure the start and end squares are different
        if (start == end) {
            return false;
        }

        // Make sure the end square is on the same row or column as the start square
        if (start.getX() != end.getX() && start.getY() != end.getY()) {
            return false;
        }

        // Check for any pieces in the way
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

        // Return true if there is no piece in the way and the end square is not occupied by a piece of the same color
        return end.getPiece() == null || end.getPiece().isWhite() != start.getPiece().isWhite();
    }
}
