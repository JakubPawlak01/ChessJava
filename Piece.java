public abstract class Piece {
    public boolean alive = true;
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

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPieceName() {
        return this.name;
    }

    //public abstract boolean canMove(Board board, Squere start, Square end);
}
