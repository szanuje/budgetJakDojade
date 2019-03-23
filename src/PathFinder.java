import java.util.ArrayList;

public class PathFinder {

    private Graph pf;
    private Line l = new Line();
    private Stop s = new Stop();

    public PathFinder() { }

    public void addVertices() {
        System.out.println(s.getStopCounter());

        ArrayList<ArrayList<Integer>> vertices = new ArrayList<>();
        vertices.addAll(l.getConnections());
        int graphSize = s.getStopCounter();
        pf = new Graph(graphSize);

        System.out.println(vertices);
        for (int i = 0; i < vertices.size() - 1; i++) {
            for (int j = 0; j < vertices.get(i).size(); j++) {
                pf.addEdge(vertices.get(i).get(j),vertices.get(i).get(j+1) );
                pf.addEdge(vertices.get(i).get(j+1),vertices.get(i).get(j) );
            }
        }
    }

    public ArrayList<ArrayList<Stop>> findPath(Stop first, Stop Last) {
        ArrayList<ArrayList<Integer>> intPaths = new ArrayList<>(pf.getPaths());
        ArrayList<ArrayList<Stop>> stopPaths = new ArrayList<>();
        for (int i = 0; i < intPaths.size(); i++) {
            ArrayList<Stop> temp = new ArrayList<>();
            for (int j = 0; j < intPaths.get(i).size(); j++) {
                temp.add(s.getIntStopSet(intPaths.get(i).get(j)));
            }
            stopPaths.add(temp);
        }
        return stopPaths;
    }
}
