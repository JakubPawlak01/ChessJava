import java.util.Scanner;

public class ChessBoard {
    Square[][] board;
    Piece[] whiteDead;
    Piece[] blackDead;
    public boolean whiteTurn = true;
    public Checker check;
    Scanner scanner;
    int w = 0;
    int b = 0;
    Square[] lastMove;

    public ChessBoard(){
        scanner = new Scanner(System.in);
        check = new Checker();
        lastMove = new Square[2];
        whiteDead = new Piece[7];
        blackDead = new Piece[7];
        for(int i = 0; i < 7; i++) {
            whiteDead[i] = null;
            blackDead[i] = null;
        }
        board = new Square[8][8];

        board[0][0] = new Square(0, 0, new Rook(false,"\u001B[31mR\u001B[0m"));
        board[0][1] = new Square(0, 1, new Knight(false,"\u001B[31mN\u001B[0m"));
        board[0][2] = new Square(0, 2, new Bishop(false,"\u001B[31mB\u001B[0m"));
        board[0][3] = new Square(0, 3, new Queen(false,"\u001B[31mQ\u001B[0m"));
        board[0][4] = new Square(0, 4, new King(false,"\u001B[31mK\u001B[0m"));
        board[0][5] = new Square(0, 5, new Bishop(false,"\u001B[31mB\u001B[0m"));
        board[0][6] = new Square(0, 6, new Knight(false,"\u001B[31mN\u001B[0m"));
        board[0][7] = new Square(0, 7, new Rook(false,"\u001B[31mR\u001B[0m"));

        board[1][0] = new Square(1, 0, new Pawn(false,"\u001B[31mP\u001B[0m"));
        board[1][1] = new Square(1, 1, new Pawn(false,"\u001B[31mP\u001B[0m"));
        board[1][2] = new Square(1, 2, new Pawn(false,"\u001B[31mP\u001B[0m"));
        board[1][3] = new Square(1, 3, new Pawn(false,"\u001B[31mP\u001B[0m"));
        board[1][4] = new Square(1, 4, new Pawn(false,"\u001B[31mP\u001B[0m"));
        board[1][5] = new Square(1, 5, new Pawn(false,"\u001B[31mP\u001B[0m"));
        board[1][6] = new Square(1, 6, new Pawn(false,"\u001B[31mP\u001B[0m"));
        board[1][7] = new Square(1, 7, new Pawn(false,"\u001B[31mP\u001B[0m"));

        board[6][0] = new Square(6, 0, new Pawn(true,"P"));
        board[6][1] = new Square(6, 1, new Pawn(true,"P"));
        board[6][2] = new Square(6, 2, new Pawn(true,"P"));
        board[6][3] = new Square(6, 3, new Pawn(true,"P"));
        board[6][4] = new Square(6, 4, new Pawn(true,"P"));
        board[6][5] = new Square(6, 5, new Pawn(true,"P"));
        board[6][6] = new Square(6, 6, new Pawn(true,"P"));
        board[6][7] = new Square(6, 7, new Pawn(true,"P"));

        board[7][0] = new Square(7, 0, new Rook(true,"R"));
        board[7][1] = new Square(7, 1, new Knight(true,"N"));
        board[7][2] = new Square(7, 2, new Bishop(true,"B"));
        board[7][3] = new Square(7, 3, new Queen(true,"Q"));
        board[7][4] = new Square(7, 4, new King(true,"K"));
        board[7][5] = new Square(7, 5, new Bishop(true,"B"));
        board[7][6] = new Square(7, 6, new Knight(true,"N"));
        board[7][7] = new Square(7, 7, new Rook(true,"R"));

        for(int i = 2; i < 6; i++) {
            for(int j = 0; j < 8; j++) {
                board[i][j] = new Square(i, j, null);
            }
        } 
    }

    public void printboard() {
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i +"| ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j].getName() + " ");
            }
            System.out.println();
        }
        System.out.println("  ----------------");
        System.out.println("   A B C D E F G H");
    }

    public void printwhiteDead(){
        for (int i = 0; i < 7; i++) {
            if(whiteDead[i] != null){
                System.out.println(i+1+" "+whiteDead[i].getPieceName());
            }
        }
    }
    
    public void printblackDead(){
        for (int i = 0; i < 7; i++) {
            if(blackDead[i] != null){
                System.out.println(i+1+" "+blackDead[i].getPieceName());
            }
        }
    }  

    public Square getSquare(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return null; // Return null if x or y is out of range
        }
        return board[x][y];
    }

    public Piece getPiece(Square square) {
        int row = square.getX();
        int col = square.getY();
        return board[row][col].getPiece();
    }


    public boolean setMove(String start, String end){
        Square str = this.getSqareFromNotation(start);
        Square en = this.getSqareFromNotation(end);

        if(str.getPiece() instanceof King){
            King king = (King) str.getPiece();
            if(king.castling(this, str, en)){
                whiteTurn = !whiteTurn;
                lastMove[0] = str;
                lastMove[1] = en;
                return true;
            }
        }

        if(str.getPiece() == null){
            return false;
        }

        if (str != null && en != null) {
            if(str.getX() > 7 || str.getY() > 7 || en.getX() > 7 || en.getY() > 7){
                System.out.println("Invalid move!1");
                return false;
            }
            if(str.getPiece() == null){
                System.out.println("No piece on starting square!");
                return false;
            }
            if(!str.getPiece().canMove(this, str, en)){
                System.out.println("Invalid move!2");
                return false;
            }
            if(check.isCheckAfterMove(this, str, en, whiteTurn)){
                System.out.println("Invalid move!3");
                return false;
            }
            if(en.getPiece() != null){
                if(en.getPiece() instanceof Pawn){
                }
                else{
                    if(en.getPiece().isWhite() == true){
                        whiteDead[w++] = en.getPiece();
                    }
                    else{
                        blackDead[b++] = en.getPiece();
                    }
                }
            }
            en.setPiece(str.getPiece());
            str.setPiece(null);
            en.getPiece().setFirstMove();
            promotion(en);
            whiteTurn = !whiteTurn;
            lastMove[0] = str;
            lastMove[1] = en;
            return true;
        } else {
            return false;
        }
    }

    public boolean setMove(Square start, Square end){
        Square str = start;
        Square en = end;
        if(str.getPiece() instanceof King){
            King king = (King) str.getPiece();
            if(king.castling(this, start, end)){
                whiteTurn = !whiteTurn;
                lastMove[0] = str;
                lastMove[1] = en;
                return true;
            }
        }
        if (str != null && en != null) {
            if(str.getX() > 7 || str.getY() > 7 || en.getX() > 7 || en.getY() > 7){
                System.out.println("Invalid move!1");
                return false;
            }
            if(str.getPiece() == null){
                System.out.println("No piece on starting square!");
                return false;
            }
            if(!str.getPiece().canMove(this, str, en)){
                System.out.println("Invalid move!2");
                return false;
            }
            if(check.isCheckAfterMove(this, str, en, whiteTurn)){
                System.out.println("Invalid move!3");
                return false;
            }
            if(en.getPiece() != null){
                if(en.getPiece() instanceof Pawn){
                }
                else{
                    if(en.getPiece().isWhite() == true){
                        whiteDead[w++] = en.getPiece();
                    }
                    else{
                        blackDead[b++] = en.getPiece();
                    }
                }
            }
            en.setPiece(str.getPiece());
            str.setPiece(null);
            promotion(end);
            whiteTurn = !whiteTurn;
            lastMove[0] = str;
            lastMove[1] = en;
            return true;
        } else {
            return false;
        }
    }

    public Square getSqareFromNotation(String not){
        char first = not.charAt(0);
        char second = not.charAt(1);

        int one = 0;
        int two = 0;
        switch(first){
            case 'a':
                one = 0; break;
            case 'b':
                one = 1; break;
            case 'c':
                one = 2; break;
            case 'd':
                one = 3; break;
            case 'e':
                one = 4; break;
            case 'f':
                one = 5; break;
            case 'g':
                one = 6; break;
            case 'h':
                one = 7; break;
            default:
                System.out.println("Zła literka"); break;
        }
        switch(second){
            case '1':
                two = 7; break;
            case '2':
                two = 6; break;
            case '3':
                two = 5; break;
            case '4':
                two = 4; break;
            case '5':
                two = 3; break;
            case '6':
                two = 2; break;
            case '7':
                two = 1; break;
            case '8':
                two = 0; break;
            default:
                System.out.println("Zła cyferka"); break;
        }
        return this.board[two][one];
    }
    
    public void promotion(Square end){
        if(end.getPiece() instanceof Pawn && end.getPiece().isWhite() == true && end.getX() == 0){
            printwhiteDead();
            System.out.println("Podaj na jaka figure chcesz zamienić piona: ");
            int choice = scanner.nextInt();
            if(whiteDead[choice-1] != null){
                end.setPiece(whiteDead[choice-1]);
                whiteDead[choice-1] = null;
                sortTable(whiteDead);
                w--;
            }
        }
        else if(end.getPiece() instanceof Pawn && end.getPiece().isWhite() == false && end.getX() == 7){
            printblackDead();
            System.out.println("Podaj na jaka figure chcesz zamienić piona: ");
            int choice = scanner.nextInt();
            if(blackDead[choice-1] != null){
                end.setPiece(blackDead[choice-1]);
                blackDead[choice-1] = null;
                sortTable(whiteDead);
                b--;
            }
        }     
    }

    public void sortTable(Piece[] table){
        for(int i=0; i<table.length; i++){
            if(table[i] == null){
                for(int j = i + 1; j < table.length; j++){
                    if(table[j] != null){
                        table[i] = table[j];
                        table[j] = null;
                        break;
                    }
                }
            }
        }
    }
};