package battleship.emeka;

import battleship.emeka.enums.ShipType;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write your code here

        // Create the two players for the game

        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        player1.setOpponent(player2);
        player2.setOpponent(player1);
        System.out.println(ShipType.values().length);
        Game game = new Game();
//        game.placeShip(player1,scanner);
        game.printGameField(player1);

    }
}
