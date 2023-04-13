public class Pawn extends Piece{
    public Pawn(boolean white, String name){
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
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();

        // Sprawdzenie, czy na polu początkowym znajduje się pionek
        if (start.getPiece() == null || !(start.getPiece() instanceof Pawn)) {
            return false;
        }

        // Sprawdzenie, czy pole końcowe jest puste
        if (end.getPiece() != null) {
            return false;
        }

        // Sprawdzenie, czy pionek porusza się o jedno pole do przodu
        if (Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 1) {
            // Sprawdzenie, czy na polu końcowym znajduje się figura przeciwnika
            if (end.getPiece() != null && end.getPiece().isWhite() != this.isWhite()) {
                return true;
            }
        } else if (startY != endY) {
            // Pionek może poruszać się tylko na ukos, aby bić figury przeciwnika
            return false;
        } else if (this.isWhite()) {
            if (startX == 6 && endX == 4) {
                // Sprawdzenie, czy pionek porusza się o dwa pola do przodu z pola startowego
                // oraz czy pola między polem startowym a końcowym są puste
                if (board.getSquare(5, startY).getPiece() == null && end.getPiece() == null) {
                    return true;
                }
            } else if (startX - endX == 1) {
                // Sprawdzenie, czy pionek porusza się o jedno pole do przodu
                if (end.getPiece() == null) {
                    return true;
                }
            }
        } else {
            if (startX == 1 && endX == 3) {
                // Sprawdzenie, czy pionek porusza się o dwa pola do przodu z pola startowego
                // oraz czy pola między polem startowym a końcowym są puste
                if (board.getSquare(2, startY).getPiece() == null && end.getPiece() == null) {
                    return true;
                }
            } else if (endX - startX == 1) {
                // Sprawdzenie, czy pionek porusza się o jedno pole do przodu
                if (end.getPiece() == null) {
                    return true;
                }
            }
        }
        return false;
    }
}
