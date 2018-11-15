package api;


/**
 * SpaceAPI is the super class of all rooms or say spaces.
 * The concrete Space class should contain id, name, capacity, type, remain
 */
public abstract class SpaceAPI {
    /**
     * Show.
     */
    public abstract void show();
}
