import java.util.Scanner;

public class Game{
    public ChessBoard board;
    Scanner scanner;
    boolean whiteTurn;

    public Game(){
        this.board = new ChessBoard();
        scanner = new Scanner(System.in);
        this.whiteTurn = true;
    }

    public void start(){
        while(true){
            board.printboard();
            String turnColor = whiteTurn ? "białych" : "czarnych";

            Square kingSquare = board.findKing(whiteTurn);
            if(board.isKingInCheck(kingSquare, whiteTurn)){
                System.out.println("Szach!");
            }

            if(board.isCheckMate(whiteTurn)){
            System.out.println("Koniec Gry! Szach mat!");
                break;
            }
            if(board.isCheckMate(!whiteTurn)){
                System.out.println("Koniec Gry! Szach mat!");
                    break;
            }
            
            System.out.println("Teraz ruch " + turnColor);
            System.out.println("Podaj pole początowe:");
            String start = scanner.nextLine();
            System.out.println("Podaj pole końcowe:");
            String end = scanner.nextLine();

            if(start.equals("") || end.equals("")){
                System.out.println("Musisz podać ruch!");
                continue;
            }

            if(whiteTurn && board.getSqareFromNotation(start).getPiece().isWhite()){
                if(board.setMove(start, end)){
                    whiteTurn = !whiteTurn;
                }
            }
            else if(!whiteTurn && !board.getSqareFromNotation(start).getPiece().isWhite()){
                if(board.setMove(start, end)){
                    whiteTurn = !whiteTurn;
                }
            }
        }
    }

    public static void main(String[] args){
        Game game = new Game();
        game.start();
    }
};