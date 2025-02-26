package dev.it22.kmitl.reg.constant;

public enum UserPrefix {
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
}
