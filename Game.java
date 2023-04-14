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
            System.out.println("Teraz ruch " + turnColor);
            System.out.println("Początek");
            String start = scanner.nextLine();
            System.out.println("Koniec");
            String end = scanner.nextLine();

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