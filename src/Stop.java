import java.util.HashMap;

public class Stop {

    private String stopName;
    private static HashMap<Stop, Integer> stopIntSet = new HashMap<>();
    private static HashMap<Integer, Stop> intStopSet = new HashMap<>();
    private static int stopCounter = 0;

    public Stop() {}

    public Stop(String name) {
        this.stopName = name;
        this.stopIntSet.put(this, stopCounter);
        this.intStopSet.put(stopCounter, this);
        stopCounter++;
    }

    public int getStopCounter() { return stopCounter; }
    public String getStopName() {
        return stopName;
    }
    public int getStopIntSet(Stop s) { return stopIntSet.get(s); }
    public Stop getIntStopSet(int i) { return intStopSet.get(i); }
}
