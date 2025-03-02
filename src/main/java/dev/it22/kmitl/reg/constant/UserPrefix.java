package dev.it22.kmitl.reg.constant;

public enum UserPrefix {
    NONE(0),
    MR(1),
    MRS(2),
    MS(3);

    private int level;

    UserPrefix(int level){
        this.level = level;
    }

    public int getValue() {
        return level;
    }

    public static UserPrefix fromValue(int value) {
        for (UserPrefix prefix : values()) {
            if (prefix.getValue() == value) {
                return prefix;
            }
        }
        throw new IllegalArgumentException("Invalid UserPrefix value: " + value);
    }
}
