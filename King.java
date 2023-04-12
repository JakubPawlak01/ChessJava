public class King extends Piece{
    public boolean castling = false;

    public King(boolean white, String name){
        super(white, name);
    }

    public boolean castlingDone(){
        return this.castling;
    }

    public void setCastling(boolean castlingDone){
        this.castling = castlingDone;
    }

    //public boolean canMove(Board board, Square start, Squere end){ 
    //    if(end.getPiece().isWhite() == this.isWhite()){
    //        return false;
    //    }
//
    //    int x = Math.abs(start.getX() - end.getX());
    //    int y = Math.abs(start.getY() - end.getY());
    //    if (x + y == 1) {
    //        return true;
    //    }
//
    //    return this.isValidCastling(board, start, end);
    //}
}

