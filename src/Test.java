import java.util.ArrayList;

public class Test {

    public static void main(String[] args)
    {
        Stop A = new Stop("A");
        Stop B = new Stop("B");
        Stop C = new Stop("C");
        Stop D = new Stop("D");
        Stop E = new Stop("E");
        ArrayList<Stop> Line1list = new ArrayList<>();
        Line1list.add(A);
        Line1list.add(B);
        Line1list.add(C);
        Line1list.add(D);
        Line1list.add(E);
        Line l1 = new Line(1, Line1list);

        Stop F = new Stop("F");
        Stop G = new Stop("G");
        ArrayList<Stop> Line2list = new ArrayList<>();
        Line2list.add(D);
        Line2list.add(F);
        Line2list.add(G);
        Line l2 = new Line(2, Line2list);

        ArrayList<Stop> Line3list = new ArrayList<>();
        Line3list.add(A);
        Line3list.add(G);

        Line l3 = new Line(3, Line3list);

        PathFinder p = new PathFinder(A, G);
//        p.addVertices();
//        p.findPath(A, G);
//        System.out.println(p.getLines());

    }
}
