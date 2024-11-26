package aaa.snakegame;

import aaaahackerrank.A;

import java.util.Scanner;

public class SnakeGame {
    public static void main(String[] args) {
        SnakeGame snakeGame=new SnakeGame();
        snakeGame.program();

    }

    private void program() {
        Scanner scanner=new Scanner(System.in);
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the row:");
        int r=scanner.nextInt();
        System.out.println("Enter the colum:");
        int c=scanner.nextInt();
        GameProcess gameProcess=new GameProcess(r,c);
        System.out.println("Enter the snake position:");
        int position =scanner.nextInt();
        if(gameProcess.snakePosition(position)){
            gameProcess.insertSnake(position);
        }else {
            System.out.println("No");
        }
    }
}
