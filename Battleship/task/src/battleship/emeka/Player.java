package battleship.emeka;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private final String [][] gameField = {
            {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"}
    };

    private Player opponent;
    private final int number;
    private int ships;
    private Map<Coordinate, Ship> map;

    public Player(int number) {
        // this field is just to give a unique number to players based on registration
        this.number = number;
        this.map = new HashMap<>();
        this.ships = 0;
        this.opponent = null;
    }

    public String[][] getGameField() {
        return gameField;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public int getNumber() {
        return number;
    }

    public int getShips() {
        return ships;
    }

    public void setShips(int ships) {
        this.ships = ships;
    }

    public Map<Coordinate, Ship> getMap() {
        return map;
    }

    public void setMap(Map<Coordinate, Ship> map) {
        this.map = map;
    }
}
