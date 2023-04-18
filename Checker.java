public class Checker {

    public Square findKing(ChessBoard chessboard, Boolean WhiteTurn){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(chessboard.board[i][j].getPiece() instanceof King && chessboard.board[i][j].getPiece().isWhite() == WhiteTurn){
                    return chessboard.board[i][j];
                }
            }
        }
    return null;
    }

    public boolean isCheck(ChessBoard chessboard, Boolean WhiteTurn){
        Square kingSquare = findKing(chessboard, WhiteTurn);
        if(kingSquare == null){
            System.out.println("Nie znaleziono Pawła Króla xD");
            return false;
        }
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                Square attackingSquare = chessboard.board[i][j];
                Piece attackingPiece = attackingSquare.getPiece();
                if(attackingPiece != null && attackingPiece.isWhite() != WhiteTurn  && attackingPiece.canMove(chessboard, attackingSquare, kingSquare)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCheckMate(ChessBoard chessBoard, Boolean WhiteTurn) {
        Square kingSquare = findKing(chessBoard, WhiteTurn);
    
        if (kingSquare == null) {
            return false;
        }
    
        if (!isCheck(chessBoard, WhiteTurn)) {
            return false;
        }
    
        int kingX = kingSquare.getX();
        int kingY = kingSquare.getY();
        for (int row = kingX - 1; row <= kingX + 1; row++) {
            for (int col = kingY - 1; col <= kingY + 1; col++) {
                if (row < 0 || row > 7 || col < 0 || col > 7 || (row == kingX && col == kingY)) {
                    continue;
                }
                Square endSquare = chessBoard.board[row][col];
                Piece endPiece = endSquare.getPiece();
                if (endPiece == null || endPiece.isWhite() != WhiteTurn) {
                    if (!isCheckAfterMove(chessBoard, kingSquare, endSquare, WhiteTurn)) {
                        return false;
                    }
                }
            }
        }
    
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Square startSquare = chessBoard.board[row][col];
                Piece startPiece = startSquare.getPiece();
                if (startPiece != null && startPiece.isWhite() == WhiteTurn) {
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            Square endSquare = chessBoard.board[i][j];
                            if (endSquare != null  && startSquare.getPiece().canMove(chessBoard, startSquare, endSquare)) {
                                if (!isCheckAfterMove(chessBoard, startSquare, endSquare, WhiteTurn)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
    
        return true;
    }

    public boolean isCheckAfterMove(ChessBoard chessboard, Square startSquare, Square endSquare, Boolean WhiteTurn){
        ChessBoard chessboard2 = new ChessBoard();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                chessboard2.board[i][j] = chessboard.board[i][j];
            }
        }
        chessboard2.whiteTurn = chessboard.whiteTurn;
        Piece sp = startSquare.getPiece();
        Piece ep = endSquare.getPiece();
        startSquare.setPiece(null);
        endSquare.setPiece(sp);
        if(isCheck(chessboard2, WhiteTurn)){
            startSquare.setPiece(sp);
            endSquare.setPiece(ep);
            return true;
        }
        startSquare.setPiece(sp);
        endSquare.setPiece(ep);
        return false;
    }
    
};



