package battleship.emeka;

import battleship.emeka.enums.ShipType;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final ShipType type;
    private final List<Coordinate>coordinates;

    public Ship(ShipType type) {
        this.type = type;
        this.coordinates = new ArrayList<>();
    }

    public ShipType getType() {
        return type;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void addNewCoordinate(Coordinate coordinate){
    // coordinates added should not exceed the allowed number of cells for ship type
        if (coordinates.size() == type.getNumberOfCells())
            return;
        coordinates.add(coordinate);
    }

    public void removeCoordinate(Coordinate coordinate){
        if (!coordinates.contains(coordinate))
            return;
        coordinates.remove(coordinate);
    }
}
