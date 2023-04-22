import java.util.Scanner;
public class Pawn extends Piece{
    Scanner scanner;
    public Pawn(boolean white, String name){
        super(white, name);
        scanner = new Scanner(System.in);
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
        int diffX = Math.abs(startX - endX);
        int diffY = Math.abs(startY - endY);

        if(diffX > 2 || diffY > 1){
            return false;
        }

        if (start.getPiece().isWhite() && end.getX() > start.getX()) {
            return false;
        } else if (!start.getPiece().isWhite() && end.getX() < start.getX()) {
            return false;
        }
        
        if((diffX == 1 && diffY == 1 && end.getPiece() == null) || diffY >= 1 && diffX == 0){
            return false;
        }

        if(diffX == 2 && startX == 6 || startX == 1){
            {
                int xDir = (end.getX() > start.getX()) ? 1 : -1;
                Square diffSquare = board.board[startX + xDir][startY];
                if(diffSquare.getPiece() == null && end.getPiece() == null){
                    return true;
                }
            }
        }

        if(diffX == 1 && end.getPiece() == null){
            return true;
        }

        if(diffX == 1 && diffY == 1 && end.getPiece() != null && start.getPiece().isWhite() != end.getPiece().isWhite()){
            return true;
        }
        
        return false;
    }
}
