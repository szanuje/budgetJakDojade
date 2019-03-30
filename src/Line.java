import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Line implements LineInterface {

    private int lineNumber;
    private ArrayList<Stop> stopList;
    private static Set<ArrayList<Integer>> connections = new HashSet<>();
    private ArrayList<Line> lines = new ArrayList<>();

    public Line() {
    }

    public Line(int lineNumber, ArrayList<Stop> stopList) {
        this.lineNumber = lineNumber;
        this.stopList = new ArrayList<>(stopList);
        lines.add(this);

        for (int i = 0; i < stopList.size(); i++) {

            stopList.get(i).addLineToStop(this);

            if(i != stopList.size() - 1) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(stopList.get(i).getStopIntMap(stopList.get(i)));
                temp.add(stopList.get(i + 1).getStopIntMap(stopList.get(i + 1)));
                connections.add(temp);
                temp = new ArrayList<>();
                temp.add(stopList.get(i + 1).getStopIntMap(stopList.get(i + 1)));
                temp.add(stopList.get(i).getStopIntMap(stopList.get(i)));
                connections.add(temp);
            }
        }
    }

    public ArrayList<Line> getLines() { return this.lines; }
    public int getLineNumber() {
        return this.lineNumber;
    }
    public ArrayList<Stop> getStopList() {
        return stopList;
    }
    public Set<ArrayList<Integer>> getConnections() { return connections; }
}
