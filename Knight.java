public class Knight extends Piece{
    public Knight(boolean white, String name){
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

        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);

        // Sprawdź czy ruch spełnia warunki dla skoczka (tzn. przesunięcie o 2 pola w pionie i 1 pole w poziomie, lub odwrotnie)
        if ((dx == 1 && dy == 2) || (dx == 2 && dy == 1)) {
            // Sprawdź czy pole docelowe jest puste lub zajmowane przez przeciwnika
            if (end.getPiece() == null || end.getPiece().isWhite() != this.isWhite()) {
                return true;
            }
        }

        // Ruch nie spełnia warunków
        return false;
    }
}
