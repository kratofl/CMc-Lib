package kratofl.cmclib.advancements.constants;

public enum FrameType {
    TASK("task"), GOAL("goal"), CHALLENGE( "challenge");

    private final String name;
    FrameType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
