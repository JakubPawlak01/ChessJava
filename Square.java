public class Square {
    public Piece piece;
    public int x;
    public int y;
    String name;

    public Square(int x, int y, Piece piece, String name) {
        this.setPiece(piece);
        this.setX(x);
        this.setY(y);
        this.setName(name);
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

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        if (piece == null){
            return "-";
        }
        return piece.getPieceName();
    }
}

