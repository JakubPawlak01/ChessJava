public class ChessBoard {
    Square[][] board;
    public ChessBoard(){
        board = new Square[8][8];
        Rook R1 = new Rook(false,"R");
        Rook R2 = new Rook(false,"R");
        Rook R3 = new Rook(true,"R");
        Rook R4 = new Rook(true,"R");
        Knight KN1 = new Knight(false,"K");
        Knight KN2 = new Knight(false,"K");
        Knight KN3 = new Knight(true,"K");
        Knight KN4 = new Knight(true,"K");
        Bishop B1 = new Bishop(false, "B");
        Bishop B2 = new Bishop(false, "B");
        Bishop B3 = new Bishop(true, "B");
        Bishop B4 = new Bishop(true, "B");
        Queen Q1 = new Queen(false,"Q");
        Queen Q2 = new Queen(true,"Q");
        King K1 = new King(false,"k");
        King K2 = new King(true,"k");
        Pawn P1 = new Pawn(false,"P");
        Pawn P2 = new Pawn(false,"P");
        Pawn P3 = new Pawn(false,"P");
        Pawn P4 = new Pawn(false,"P");
        Pawn P5 = new Pawn(false,"P");
        Pawn P6 = new Pawn(false,"P");
        Pawn P7 = new Pawn(false,"P");
        Pawn P8 = new Pawn(false,"P");

        Pawn P10 = new Pawn(true, "P");
        Pawn P11 = new Pawn(true, "P");
        Pawn P12 = new Pawn(true, "P");
        Pawn P13 = new Pawn(true, "P");
        Pawn P14 = new Pawn(true, "P");
        Pawn P15 = new Pawn(true, "P");
        Pawn P16 = new Pawn(true, "P");
        Pawn P17 = new Pawn(true, "P");
        

        Square a8 = new Square(0, 0, R1,"a8");
        Square b8 = new Square(0, 1, KN1 ,"b8");
        Square c8 = new Square(0, 2, B1,"c8");
        Square d8 = new Square(0, 3, Q1,"d8");
        Square e8 = new Square(0, 4, K1,"e8");
        Square f8 = new Square(0, 5, B2,"f8");
        Square g8 = new Square(0, 6, KN2,"g8");
        Square h8 = new Square(0, 7, R2 ,"h8");

        Square a7 = new Square(1, 0, P1,"a7");
        Square b7 = new Square(1, 1, P2,"b7");
        Square c7 = new Square(1, 2, P3,"c7");
        Square d7 = new Square(1, 3, P4,"d7");
        Square e7 = new Square(1, 4, P5,"e7");
        Square f7 = new Square(1, 5, P6,"f7");
        Square g7 = new Square(1, 6, P7,"g7");
        Square h7 = new Square(1, 7, P8,"h7");


        Square a1 = new Square(7, 0, R3, "a1");
        Square b1 = new Square(7, 1, KN3 ,"b1");
        Square c1 = new Square(7, 2, B3,"c1");
        Square d1 = new Square(7, 3, Q2,"d1");
        Square e1 = new Square(7, 4, K2,"e1");
        Square f1 = new Square(7, 5, B4,"f1");
        Square g1 = new Square(7, 6, KN4 ,"g1");
        Square h1 = new Square(7, 7, R4,"h1");

        Square a2 = new Square(6, 0, P10,"a2");
        Square b2 = new Square(6, 1, P11,"b2");
        Square c2 = new Square(6, 2, P12,"c2");
        Square d2 = new Square(6, 3, P13,"d2");
        Square e2 = new Square(6, 4, P14,"e2");
        Square f2 = new Square(6, 5, P15,"f2");
        Square g2 = new Square(6, 6, P16,"g2");
        Square h2 = new Square(6, 7, P17,"h2");

        Square a3 = new Square(2, 0, null,"a3");
        Square b3 = new Square(2, 1, null,"b3");
        Square c3 = new Square(2, 2, null,"c3");
        Square d3 = new Square(2, 3, null,"d3");
        Square e3 = new Square(2, 4, null,"e3");
        Square f3 = new Square(2, 5, null,"f3");
        Square g3 = new Square(2, 6, null,"g3");
        Square h3 = new Square(2, 7, null,"h3");

        Square a4 = new Square(3, 0, null,"a4");
        Square b4 = new Square(3, 1, null,"b4");
        Square c4 = new Square(3, 2, null,"c4");
        Square d4 = new Square(3, 3, null,"d4");
        Square e4 = new Square(3, 4, null,"e4");
        Square f4 = new Square(3, 5, null,"f4");
        Square g4 = new Square(3, 6, null,"g4");
        Square h4 = new Square(3, 7, null,"h4");

        Square a5 = new Square(4, 0, null,"a5");
        Square b5 = new Square(4, 1, null,"b5");
        Square c5 = new Square(4, 2, null,"c5");
        Square d5 = new Square(4, 3, null,"d5");
        Square e5 = new Square(4, 4, null,"e5");
        Square f5 = new Square(4, 5, null,"f5");
        Square g5 = new Square(4, 6, null,"g5");
        Square h5 = new Square(4, 7, null,"h5");

        Square a6 = new Square(5, 0, null,"a6");
        Square b6 = new Square(5, 1, null,"b6");
        Square c6 = new Square(5, 2, null,"c6");
        Square d6 = new Square(5, 3, null,"d6");
        Square e6 = new Square(5, 4, null,"e6");
        Square f6 = new Square(5, 5, null,"f6");
        Square g6 = new Square(5, 6, null,"g6");
        Square h6 = new Square(5, 7, null,"h6");

        board[0][0] = a8;
        board[0][1] = b8;
        board[0][2] = c8;
        board[0][3] = d8;
        board[0][4] = e8;
        board[0][5] = f8;
        board[0][6] = g8;
        board[0][7] = h8;

        board[1][0] = a7;
        board[1][1] = b7;
        board[1][2] = c7;
        board[1][3] = d7;
        board[1][4] = e7;
        board[1][5] = f7;
        board[1][6] = g7;
        board[1][7] = h7;

        board[2][0] = a6;
        board[2][1] = b6;
        board[2][2] = c6;
        board[2][3] = d6;
        board[2][4] = e6;
        board[2][5] = f6;
        board[2][6] = g6;
        board[2][7] = h6;

        board[3][0] = a5;
        board[3][1] = b5;
        board[3][2] = c5;
        board[3][3] = d5;
        board[3][4] = e5;
        board[3][5] = f5;
        board[3][6] = g5;
        board[3][7] = h5;

        board[4][0] = a4;
        board[4][1] = b4;
        board[4][2] = c4;
        board[4][3] = d4;
        board[4][4] = e4;
        board[4][5] = f4;
        board[4][6] = g4;
        board[4][7] = h4;

        board[5][0] = a3;
        board[5][1] = b3;
        board[5][2] = c3;
        board[5][3] = d3;
        board[5][4] = e3;
        board[5][5] = f3;
        board[5][6] = g3;
        board[5][7] = h3;

        board[6][0] = a2;
        board[6][1] = b2;
        board[6][2] = c2;
        board[6][3] = d2;
        board[6][4] = e2;
        board[6][5] = f2;
        board[6][6] = g2;
        board[6][7] = h2;

        board[7][0] = a1;
        board[7][1] = b1;
        board[7][2] = c1;
        board[7][3] = d1;
        board[7][4] = e1;
        board[7][5] = f1;
        board[7][6] = g1;
        board[7][7] = h1;
        
    }

    public void printboard() {
        for (int i = 7; i >= 0; i--) {
            System.out.print((i + 1) + "| ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j].getName() + " ");
            }
            System.out.println();
        }
        System.out.println("  ----------------");
        System.out.println("   A B C D E F G H  ");
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

    public Square getSquare(String position) {
        int row = 8 - Character.getNumericValue(position.charAt(1)); // zamienia numer wiersza na indeks tablicy board
        int col = (int)position.charAt(0) - (int)'a'; // zamienia literę kolumny na indeks tablicy board
        return board[row][col];
    }

    public void setMove(Square start, Square end){
        //if(!start.getPiece().canMove(this, start, end)){
        //    System.out.println("cannot move");
        //}
        //else{
            end.setPiece(start.getPiece());
            start.setPiece(null);
        
    }
    
    public static void main(String[] args){
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.printboard();
        chessBoard.setMove(chessBoard.getSquare("a2"),  chessBoard.getSquare("a4"));
        System.out.println();
        chessBoard.printboard();
    }
};