import java.util.HashMap;

public class Stop {

    private String stopName;
    private static HashMap<Stop, Integer> stopIntMap = new HashMap<>();
    private static HashMap<Integer, Stop> intStopMap = new HashMap<>();
    private static int stopCounter = 0;

    public Stop() {}

    public Stop(String name) {
        this.stopName = name;
        this.stopIntMap.put(this, stopCounter);
        this.intStopMap.put(stopCounter, this);
        stopCounter++;
    }

    public int getStopCounter() { return stopCounter; }
    public String getStopName() {
        return stopName;
    }
    public int getStopIntMap(Stop s) { return stopIntMap.get(s); }
    public Stop getIntStopMap(int i) { return intStopMap.get(i); }
}
