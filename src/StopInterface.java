import java.util.ArrayList;

public interface StopInterface {

    /**
     * Method stores bus lines connected with bus stop
     * @param l line
     */
    void addLineToStop(Line l);

    /**
     * @return list of stop lines that belongs to the bus stop
     */
    ArrayList<Line> getStopLines();

    /**
     * Method allows to set proper size of a graph needed to find the connections
     * @return number of existing bus stops
     */
    int getStopCounter();

    /**
     * @return stop name
     */
    String getStopName();

    /**
     * @param s stop
     * @return integer representing bus stop in a map
     */
    int getStopIntMap(Stop s);

    /**
     * @param i integer
     * @return bus stop representing integer in a map
     */
    Stop getIntStopMap(int i);
}
