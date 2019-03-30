import java.util.ArrayList;

public class PathFinder {

    private Graph pf;
    private Line l = new Line();
    private Stop s = new Stop();
    private Stop first;
    private Stop last;
    private ArrayList<ArrayList<Stop>> stopPaths;
    private ArrayList<ArrayList<Line>> lines;

    public PathFinder(Stop first, Stop last) {
        this.first = first;
        this.last = last;
        this.stopPaths = new ArrayList<>();
        this.lines = new ArrayList<>();
        this.addVertices();
        this.findPath(first, last);
        System.out.println(this.getLines());
        this.printResults();
    }

    public void addVertices() {
        //System.out.println(s.getStopCounter());
        ArrayList<ArrayList<Integer>> vertices = new ArrayList<>(l.getConnections());
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
        for (int i = 0; i < intPaths.size(); i++) {
            ArrayList<Stop> temp = new ArrayList<>();
            for (int j = 0; j < intPaths.get(i).size(); j++) {
                temp.add(s.getIntStopMap(intPaths.get(i).get(j)));
            }
            this.stopPaths.add(temp);
        }
        System.out.println(intPaths);
        System.out.println(stopPaths);
        return stopPaths;
    }

    public ArrayList<ArrayList<Line>> getLines() {
        for (int i = 0; i < stopPaths.size(); i++) {
            ArrayList<Line> temp = new ArrayList<>();
            for (int j = 0; j < stopPaths.get(i).size(); j++) {
                if(j != stopPaths.get(i).size() - 1) {
                    ArrayList<Line> oneStop = new ArrayList<>(stopPaths.get(i).get(j).getStopLines());
                    ArrayList<Line> anotherStop = new ArrayList<>(stopPaths.get(i).get(j+1).getStopLines());
                    oneStop.retainAll(anotherStop);
                    temp.add(oneStop.get(0));
                }
            }
            lines.add(temp);
        }
        return lines;
    }

    public void printResults() {
        System.out.println();
        System.out.println("If you want to get from stop " + first.getStopName() + " to stop " + last.getStopName() +
                " you need to:");

        for (int i = 0; i < stopPaths.size(); i++) {
            Line temp = lines.get(i).get(0);
            for (int j = 0; j < stopPaths.get(i).size(); j++) {
                if(j == 0) {
                    System.out.println();
                    System.out.println("Get on the line " + temp.getLineNumber() +
                            " at stop " + first.getStopName());
                }
                    else if(j == stopPaths.get(i).size() - 1) {
                    System.out.println("Get off at stop " + last.getStopName());
                    }

                else {
                    if(!temp.equals(lines.get(i).get(j))) {
                        System.out.println("Then travel towards stop " + stopPaths.get(i).get(j).getStopName());
                        temp = lines.get(i).get(j);
                        System.out.println("Get on the line " + temp.getLineNumber());
                    }
                }
            }
        }
    }
}
