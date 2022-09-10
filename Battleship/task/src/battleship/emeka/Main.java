package battleship.emeka;

import battleship.emeka.enums.ShipType;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write your code here

        // Create the two players for the game
        Player firstPlayer = new Player(1);
        Player secondPlayer = new Player(2);
        firstPlayer.setOpponent(secondPlayer);
        secondPlayer.setOpponent(firstPlayer);
        Game game = new Game();

        try (Scanner scanner = new Scanner(System.in)){
            game.positionPlayerShips(firstPlayer,scanner);
            game.positionPlayerShips(secondPlayer,scanner);
       }catch (Exception e){
            System.out.println(e.getMessage());
        }







    }
}
