public class Queen extends Piece{
    public Queen(boolean white, String name){
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

        // Sprawdź, czy ruch jest poziomy, pionowy lub diagonalny
        if (!isMoveStraight(start, end) && !isMoveDiagonal(start, end)) {
            return false;
        }
        
        // Sprawdź, czy pole docelowe jest wolne lub zajmowane przez przeciwnika
        if (end.getPiece() == null || end.getPiece().isWhite() != this.isWhite()) {
            // Sprawdź, czy ruch jest możliwy
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

    // Sprawdź, czy ruch jest poziomy lub pionowy
    private boolean isMoveStraight(Square start, Square end) {
        return start.getX() == end.getX() || start.getY() == end.getY();
    }

    // Sprawdź, czy ruch jest diagonalny
    private boolean isMoveDiagonal(Square start, Square end) {
        int dx = Math.abs(end.getX() - start.getX());
        int dy = Math.abs(end.getY() - start.getY());
        return dx == dy;
    }
};
