import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Line {

    private int lineNumber;
    private ArrayList<Stop> stopList;
    private static Set<ArrayList<Integer>> connections = new HashSet<>();

    public Line() {}

    public Line(int lineNumber, ArrayList<Stop> stopList) {
        this.lineNumber = lineNumber;
        this.stopList = new ArrayList<>(stopList);

        for (int i = 0; i < stopList.size() - 1; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(stopList.get(i).getStopIntSet(stopList.get(i)));
            temp.add(stopList.get(i+1).getStopIntSet(stopList.get(i+1)));
            connections.add(temp);
            temp = new ArrayList<>();
            temp.add(stopList.get(i+1).getStopIntSet(stopList.get(i+1)));
            temp.add(stopList.get(i).getStopIntSet(stopList.get(i)));
            connections.add(temp);
        }
    }

    public int getLineNumber() {
        return this.lineNumber;
    }
    public ArrayList<Stop> getStopList() {
        return stopList;
    }
    public Set<ArrayList<Integer>> getConnections() { return connections; }
}
