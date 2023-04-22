public abstract class Piece {
    public boolean firstMove = true;
    public boolean white = false;
    public String name;

    public Piece(boolean white, String name) {
        this.setWhite(white);
        this.setName(name);
    }
    
    public boolean isWhite() {
        return this.white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean getFirstMove() {
        return this.firstMove;
    }

    public void setFirstMove() {
        this.firstMove = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPieceName() {
        return this.name;
    }

    public abstract boolean canMove(ChessBoard board, Square start, Square end);
}
