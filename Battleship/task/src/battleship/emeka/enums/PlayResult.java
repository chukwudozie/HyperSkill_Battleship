package battleship.emeka.enums;

public enum PlayResult {
    HIT(System.lineSeparator()+"You hit a Ship! Try again:"+System.lineSeparator(),"X"),
    MISS(System.lineSeparator()+"You missed! Try again:"+System.lineSeparator(),"M");
    private final String message;
    private final String flag;
    PlayResult(String message, String flag) {
        this.message = message;
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public String getFlag() {
        return flag;
    }
}
