public class Bishop extends Piece{
    public Bishop(boolean white, String name){
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
        
        // Pionek nie może poruszać się na pole, które jest już zajęte przez inną figurę
        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int deltaX = Math.abs(end.getX() - start.getX());
        int deltaY = Math.abs(end.getY() - start.getY());

        // Sprawdzenie, czy ruch jest wykonany po skosie
        if (deltaX != deltaY) {
            return false;
        }

        // Sprawdzenie, czy pomiędzy startem i końcem nie ma innej figury na drodze
        int xDir = (end.getX() > start.getX()) ? 1 : -1;
        int yDir = (end.getY() > start.getY()) ? 1 : -1;
        for (int i = 1; i < deltaX; i++) {
            Square square = board.board[start.getX() + i * xDir][start.getY() + i * yDir];
            if (square.getPiece() != null) {
                return false;
            }
        }

        return true;
    }
}
