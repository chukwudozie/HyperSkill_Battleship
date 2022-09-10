package battleship.emeka;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import battleship.emeka.BattleShipExceptions.*;
import battleship.emeka.enums.ShipType;

public class Game {
// This map converts the x - coordinate from characters to their number equivalence
     static final Map<Character, Integer> COORDINATES = Arrays.stream(new Object [][]{
            {'A', 1}, {'B', 2}, {'C', 3}, {'D', 4}, {'E', 5},
            {'F', 6}, {'G', 7}, {'H', 8}, {'I', 9}, {'J', 10},
            {'a', 1}, {'b', 2}, {'c', 3}, {'d', 4}, {'e', 5},
            {'f', 6}, {'g', 7}, {'h', 8}, {'i', 9}, {'j', 10}
    }).collect(Collectors.toMap(point ->(Character)point[0], point -> (Integer) point[1]));


     void validateCoordinate(int x, int y) {
        boolean checkX = x >= 1 && x <= 10;
        boolean checkY = y >= 1 && y <= 10;
        if (!checkX || !checkY) {
            System.out.println("Sorry the coordinates wither less than 1 or greater than 10");
            throw new WrongCoordinatesException();
        }
    }

    void validateShipLocation(String shipType, int numberOfCells, int x1, int x2, int y1, int y2) {
        System.out.println("I entered ship location validation");
         if ((x1 == x2) == (y1 == y2)) throw new WrongShipLocation();
        if ((x1 == x2 && Math.abs(y1 - y2) != numberOfCells - 1)
                || (y1 == y2 && Math.abs(x1 - x2) != numberOfCells - 1)) {
            throw new BadCoordinateLengthException(shipType);
        }
        System.out.println("I came out from ship location validation");

    }

    private void checkIfShipsCanBePlaced(Player player, int x1, int x2, int y1, int y2) {
        int n = x1 == x2 ? 0 : 1;
        int m = n == 1 ? 0 : 1;
        int x;
        int y;
        for (x = x1, y = y1; x < x2 || y < y2; x += n, y += m) {
            isPlaceOccupiedBySomeShip(player, x, y);
        }

        isPlaceOccupiedBySomeShip(player, x, y);
    }


    private void isPlaceOccupiedBySomeShip(Player player, int x, int y) {
        if ("O".equals(player.getGameField()[x][y])
                || x + 1 <= 10 && "O".equals(player.getGameField()[x + 1][y])
                || x - 1 >= 1 && "O".equals(player.getGameField()[x - 1][y])
                || y + 1 <= 10 && "O".equals(player.getGameField()[x][y + 1])
                || y - 1 >= 1 && "O".equals(player.getGameField()[x][y - 1])) {
            throw new ShipsTooCloseException();
        }
        System.out.println("Position specified is good"+x+" "+y);
    }

    void startGame(){

    }
    private void place(Player player, ShipType shipType, int x1, int x2, int y1, int y2) {
        int n = x1 == x2 ? 0 : 1;
        int m = n == 1 ? 0 : 1;

        int x;
        int y;

        Ship ship = new Ship(shipType);
        for (x = x1, y = y1; x < x2 || y < y2; x += n, y += m) {
            putShip(player, ship, new Coordinate(x, y));
        }
        putShip(player, ship, new Coordinate(x, y));
        player.setShips(player.getShips() + 1);

    }

    private void putShip(Player player, Ship ship, Coordinate coordinate) {
        ship.addNewCoordinate(coordinate);
        player.getMap().put(coordinate, ship);
        player.getGameField()[coordinate.getX()][coordinate.getY()] = "O";
    }

    void positionPlayerShips(Player player, Scanner scanner) {
        System.out.println("Player "+player.getNumber()+", place ships (5) on the play field");
        for (ShipType type: ShipType.values()){
            printGameField(player);
            System.out.println("Enter the coordinates of the "+type.getName()+" ("+type.getNumberOfCells()+"):");
            boolean readValue = false;
            while (!readValue) {
                String []playerInputs = scanner.nextLine().split("\\s+");
                System.out.println();
                readValue = placeShip(player,type,playerInputs);
                printGameField(player);
                System.out.println();
            }
        }
        System.out.println("Press Enter and pass the move to another player");
        scanner.nextLine();
    }

    void printGameField(Player player){
         for (String[] strings: player.getGameField()){
             System.out.println(String.join("  ",strings));
         }
    }



    private boolean placeShip(Player player, ShipType type, String[] playerInputs) {
        //Get the coordinates of the ship from the user input eg A1 B1 = (1,1) (2,1)
        boolean flag = true;

        try {
            System.out.println(" I cam here 1");
            int x1 = COORDINATES.get(playerInputs[0].charAt(0));
            int x2 = COORDINATES.get(playerInputs[1].charAt(0));
            int y1 = Integer.parseInt(playerInputs[0].substring(1));
            int y2 = Integer.parseInt(playerInputs[1].substring(1));
            System.out.println("I came here 2");
            validateCoordinate(x1, y1);
            validateCoordinate(x2, y2);
            System.out.println("I came here 3");
            // Sort coordinates
            if (x2 < x1) {
                System.out.println("I came here 4");
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
            }
            if (y2 < y1) {
                System.out.println("I came here 5");
                int tmp = y1;
                y1 = y2;
                y2 = tmp;
            }
            System.out.println("I came after 3");
            validateShipLocation(type.getName(), type.getNumberOfCells(), x1, x2, y1, y2);
            System.out.println("I came here 6");
            checkIfShipsCanBePlaced(player,x1,x2,y1,y2);
            place(player,type,x1,x2,y1,y2);
        } catch (NullPointerException | NumberFormatException | IndexOutOfBoundsException |
                WrongCoordinatesException| BadCoordinateLengthException | WrongShipLocation e) {
            flag = false;
            System.err.println("Error! : "+e.getMessage()+" "+e.getCause());
        }
        return flag;
    }

}
