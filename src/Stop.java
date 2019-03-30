import java.util.ArrayList;
import java.util.HashMap;

public class Stop implements StopInterface {

    private String stopName;
    private static HashMap<Stop, Integer> stopIntMap = new HashMap<>();
    private static HashMap<Integer, Stop> intStopMap = new HashMap<>();
    private static int stopCounter = 0;
    private ArrayList<Line> stopLines;

    public Stop() {}

    public Stop(String name) {
        this.stopName = name;
        stopIntMap.put(this, stopCounter);
        intStopMap.put(stopCounter, this);
        stopCounter++;
        this.stopLines = new ArrayList<>();
    }

    public void addLineToStop(Line l) { this.stopLines.add(l); }
    public ArrayList<Line> getStopLines() { return this.stopLines; }
    public int getStopCounter() { return stopCounter; }
    public String getStopName() {
        return stopName;
    }
    public int getStopIntMap(Stop s) { return stopIntMap.get(s); }
    public Stop getIntStopMap(int i) { return intStopMap.get(i); }
}
