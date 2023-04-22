public class King extends Piece{
    Checker checker;
    public King(boolean white, String name){
        super(white, name);
        checker = new Checker();
    }

    public boolean canMove(ChessBoard board, Square start, Square end) {
        if (end.getX() < 0 || end.getX() > 7 || end.getY() < 0 || end.getY() > 7) {
            return false;
        }

        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            return false;
        }

        if(!castling(board, start, end)){
            return false;
        }

        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int xDiff = Math.abs(end.getX() - start.getX());
        int yDiff = Math.abs(end.getY() - start.getY());
        if (xDiff > 1 || yDiff > 1) {
            return false;
        }

        

        return true;
    }

    public boolean castling(ChessBoard board, Square start, Square end){
        if(start.getPiece() instanceof King && start.getPiece().isWhite() == true && end.getY() == 2 ){
            if(start.getPiece().getFirstMove() == true && board.board[7][0].getPiece().getFirstMove() == true){
                Square mid = board.board[7][3];
                Square endNext = board.board[7][1];
                if(mid.getPiece() == null && !checker.isCheckAfterMove(board, start, mid, start.getPiece().isWhite())){
                    if(end.getPiece() == null && !checker.isCheckAfterMove(board, start, end, start.getPiece().isWhite())){
                        if(endNext.getPiece() == null){
                            board.board[7][2].setPiece(board.board[7][4].getPiece()); 
                            board.board[7][3].setPiece(board.board[7][0].getPiece());
                            board.board[7][0].setPiece(null);
                            board.board[7][4].setPiece(null);
                            board.board[7][2].getPiece().setFirstMove();
                            board.board[7][3].getPiece().setFirstMove();
                            return true;
                        }
                    }
                }
            }
        }
        else if(start.getPiece() instanceof King && start.getPiece().isWhite() == true && end.getY() == 6 ){
            if(start.getPiece().getFirstMove() == true && board.board[7][7].getPiece().getFirstMove() == true){
                Square mid = board.board[7][5];
                if(mid.getPiece() == null && !checker.isCheckAfterMove(board, start, mid, start.getPiece().isWhite())){
                    if(end.getPiece() == null && !checker.isCheckAfterMove(board, start, end, start.getPiece().isWhite())){
                        board.board[7][6].setPiece(board.board[7][4].getPiece());
                        board.board[7][5].setPiece(board.board[7][7].getPiece());
                        board.board[7][7].setPiece(null);
                        board.board[7][4].setPiece(null);
                        board.board[7][6].getPiece().setFirstMove();
                        board.board[7][5].getPiece().setFirstMove();
                        return true;
                    }
                }
            }
        }

        if(start.getPiece() instanceof King && start.getPiece().isWhite() == false && end.getY() == 2 ){
            if(start.getPiece().getFirstMove() == true && board.board[0][0].getPiece().getFirstMove() == true){
                Square mid = board.board[0][3];
                Square endNext = board.board[0][1];
                if(mid.getPiece() == null && !checker.isCheckAfterMove(board, start, mid, start.getPiece().isWhite())){
                    if(end.getPiece() == null && !checker.isCheckAfterMove(board, start, end, start.getPiece().isWhite())){
                        if(endNext.getPiece() == null){
                            board.board[0][2].setPiece(board.board[7][4].getPiece()); 
                            board.board[0][3].setPiece(board.board[7][0].getPiece());
                            board.board[0][0].setPiece(null);
                            board.board[0][4].setPiece(null);
                            board.board[0][2].getPiece().setFirstMove();
                            board.board[0][3].getPiece().setFirstMove();
                            return true;
                        }
                    }
                }
            }
        }
        else if(start.getPiece() instanceof King && start.getPiece().isWhite() == false && end.getY() == 6 ){
            if(start.getPiece().getFirstMove() == true && board.board[0][7].getPiece().getFirstMove() == true){
                Square mid = board.board[0][5];
                if(mid.getPiece() == null && !checker.isCheckAfterMove(board, start, mid, start.getPiece().isWhite())){
                    if(end.getPiece() == null && !checker.isCheckAfterMove(board, start, end, start.getPiece().isWhite())){
                        board.board[0][6].setPiece(board.board[0][4].getPiece());
                        board.board[0][5].setPiece(board.board[0][7].getPiece());
                        board.board[0][7].setPiece(null);
                        board.board[0][4].setPiece(null);
                        board.board[0][6].getPiece().setFirstMove();
                        board.board[0][5].getPiece().setFirstMove();
                        return true;
                    }
                }
            }
        }


        return false;
    }

    
}

