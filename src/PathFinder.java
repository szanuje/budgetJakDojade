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
        for (int i = 0; i < vertices.size(); i++) {
            pf.addEdge(vertices.get(i).get(0), vertices.get(i).get(1));
            pf.addEdge(vertices.get(i).get(1), vertices.get(i).get(0));
        }

    }

    public ArrayList<ArrayList<Stop>> findPath(Stop first, Stop Last) {
        int begin = s.getStopIntMap(first);
        int end = s.getStopIntMap(Last);
        ArrayList<ArrayList<Integer>> intPaths = new ArrayList<>(pf.getAllPaths(begin, end));
        ArrayList<ArrayList<Stop>> stopPaths = new ArrayList<>();
//        for (int i = 0; i < intPaths.size(); i++) {
//            ArrayList<Stop> temp = new ArrayList<>();
//            for (int j = 0; j < intPaths.get(i).size(); j++) {
//                temp.add(s.getIntStopSet(intPaths.get(i).get(j)));
//            }
//            stopPaths.add(temp);
//        }
        System.out.println(intPaths);
        return stopPaths;
    }
}
