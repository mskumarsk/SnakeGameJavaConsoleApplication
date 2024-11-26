package aaa.snakegame;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameProcess {
    char[][] board;
    Deque<Position> positions;
    Queue<Position> food;
    public GameProcess(int r, int c) {
        board=new char[r][c];
        positions=new LinkedList<>();
        food=new LinkedList<>();
        insertBorder();
        foodArrange();
    }

    private void foodArrange() {
        food.add(new Position(3,3));
        food.add(new Position(4,4));
        food.add(new Position(5,2));
        food.add(new Position(3,1));
        Position p=food.poll();
        int r=p.getHead();
        int c=p.getTail();
        board[r][c]='F';
    }

    private void insertBorder() {
        for (int i=0;i<board.length;i++){
            board[i][0]='X';
            board[i][board.length-1]='X';
        }
        for (int i=0;i<board[0].length;i++){
            board[0][i]='X';
            board[board[0].length-1][i]='X';
        }
        printBoard();
    }

    private void printBoard() {
        for (int i=0;i< board.length;i++){
            for (int j=0;j< board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }


    public boolean snakePosition(int position) {
        int r=position;
        if (r<=1||r>= board.length-1||board.length-2<4)return false;
        return true;
    }

    public void insertSnake(int position) {
       board[position][board[0].length-2]='=';
        board[position][board[0].length-3]='=';
        board[position][board[0].length-4]='=';
        board[position][board[0].length-5]='O';
        positions.add(new Position(position,board[0].length-5));
        positions.add(new Position(position,board[0].length-4));
        positions.add(new Position(position,board[0].length-3));
        positions.add(new Position(position,board[0].length-2));
        printBoard();
        gameStart(position,board[0].length-5);
    }

    boolean flag=true;
    private void gameStart(int r, int c) {
        System.out.println(r+"   "+c);
        if (r<1||c<1||r>=board.length-1||c>=board[0].length-1){
            System.out.println("No");
            System.exit(0);
        }
        if(board[r][c]=='='){
            System.out.println("No");
            System.exit(0);
        }
        if (board[r][c]!='F'){
            board[r][c]='O';
//            printBoard();

            if (!flag) {
                Position p=positions.peekFirst();
                int n=p.getHead();
                int m=p.getTail();
                board[n][m]='=';
                positions.addFirst(new Position(r, c));
                Position s=positions.pollLast();
                int b=s.getHead();
                int a=s.getTail();
                board[b][a]='\0';
            }
            flag=false;

        }
        if (board[r][c]=='F'){
            board[r][c]='O';
            Position s=positions.peekFirst();
            int l=s.getHead();
            int k=s.getTail();
            board[l][k]='=';
            Position p=food.poll();
            int n=p.getHead();
            int m=p.getTail();
            board[n][m]='F';
            positions.addFirst(new Position(r, c));
        }
        printBoard();
        if(!positions.isEmpty()) {
            System.out.print("Enter a position : ");
            Scanner s = new Scanner(System.in);
            char direction = s.next().charAt(0);

            if (direction == 'U') {
                gameStart(--r, c);
            }
            if (direction == 'D') {
                gameStart(++r, c);
            }
            if (direction == 'R') {
                gameStart(r, ++c);
            }
            if (direction == 'L') {
                gameStart(r, --c);
            }
        }
    }
}
