package battleship.emeka;

public class BattleShipExceptions {

    static class WrongCoordinatesException extends IllegalArgumentException {
        public static final String MESSAGE = "Error! You entered wrong coordinates! Try again:";
        public WrongCoordinatesException(){
            super(MESSAGE);
        }
    }

    static class WrongShipLocation extends IllegalArgumentException {
        public static final String MESSAGE = "Error! Wrong ship location! Try again:";

        public WrongShipLocation(){
            super(MESSAGE);
        }
    }

    static class ShipsTooCloseException extends IllegalArgumentException {
        public static String MESSAGE = "Error! You placed it too close to another one. Try again:";
        public ShipsTooCloseException(){
            super(MESSAGE);
        }
    }

    static class BadCoordinateLengthException extends IllegalArgumentException {
        public static String MESSAGE_LEFT = "Error! Wrong length of the ";
        public final static String MESSAGE_RIGHT = "! Try again:";

        public BadCoordinateLengthException(String ship) {
            super(MESSAGE_LEFT+ship+MESSAGE_RIGHT);
        }
    }
}
