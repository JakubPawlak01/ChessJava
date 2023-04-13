public class King extends Piece{
    public boolean castling = false;

    public King(boolean white, String name){
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

        // Sprawdź, czy ruch nie jest wykonywany na pole zajmowane przez swoją figurę
        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        // Sprawdź, czy ruch króla nie wykracza poza jego zasięg
        int xDiff = Math.abs(end.getX() - start.getX());
        int yDiff = Math.abs(end.getY() - start.getY());
        if (xDiff > 1 || yDiff > 1) {
            return false;
        }

        return true;
    }

    
}

