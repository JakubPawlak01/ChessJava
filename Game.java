import java.util.Scanner;

public class Game{
    public ChessBoard board;
    public Checker check;
    Scanner scanner;
    boolean whiteTurn;

    public Game(){
        this.board = new ChessBoard();
        this.check = new Checker();
        scanner = new Scanner(System.in);
        this.whiteTurn = true;
    }

    public void start(){
        while(true){
            board.printboard();
            if(check.isCheck(board, whiteTurn)){
                System.out.println("Szach!");
            }
            if(check.isCheckMate(board, whiteTurn)){
                System.out.println("Mat!");
                break;
            }
            String turnColor = whiteTurn ? "białych" : "czarnych";
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