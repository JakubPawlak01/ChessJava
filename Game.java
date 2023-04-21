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
        String[] a = {"e2","a7","d1","a8","h5","h7","a5","a6","h2","f7","c7","e8","d7","d8","b7","d3","b8","f7","c8"};
        String[] b = {"e3","a5","h5","a6","a5","h5","c7","h6","h4","f6","d7","f7","b7","d3","b8","h7","c8","g6","e6"};
        int c = 0;
        while(true){
            board.printboard();
        
            String turnColor = whiteTurn ? "białych" : "czarnych";

            if(check.isCheck(board, whiteTurn)){
                System.out.println("Szach!");
            }
            if(check.isCheckMate(board, whiteTurn)){
                System.out.println("Mat!");
                break;
            }
            if(check.isPat(board, whiteTurn)){
                System.out.println("Pat!");
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

            //String start  = a[c];
            //String end = b[c++];
            //if(c > 19 ){
            //    start = scanner.nextLine();
            //    end = scanner.nextLine();
            //}
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