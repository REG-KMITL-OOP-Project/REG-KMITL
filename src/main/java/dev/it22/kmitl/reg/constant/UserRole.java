package dev.it22.kmitl.reg.constant;

public enum UserRole {

    ADMIN(1),
    STUDENT(2),
    PROF(3);

    private int level;
    UserRole(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
