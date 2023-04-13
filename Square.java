public class Square {
    public Piece piece;
    public int x;
    public int y;

    public Square(int x, int y, Piece piece) {
        this.setPiece(piece);
        this.setX(x);
        this.setY(y);
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece p)
    {
        this.piece = p;
    }

    public int getX()
    {
        return this.x;
    }
  
    public void setX(int x)
    {
        this.x = x;
    }
  
    public int getY()
    {
        return this.y;
    }
  
    public void setY(int y)
    {
        this.y = y;
    }

    public String getName(){
        if (piece == null){
            return "-";
        }
        return piece.getPieceName();
    }
}

