package api;

public enum Subject {
    MATHS("\u01AA"), HISTORY("\u0048\u0049\u0053"), CHEMISTRY("\u0043\u0048"), BIOLOGY("\u0042\u004C\u0047"), POLISH("\u0050\u004C"), ENGLISH("\u0045\u004E\u0047");
    private String symbol;

    Subject(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
