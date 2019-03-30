import java.util.ArrayList;
import java.util.Set;

public interface LineInterface {

    /**
     * @return line number
     */
    int getLineNumber();

    /**
     * Method returns set of lists of pairs of integers which are representing connections between bus stops as graph vertices
     * @return connections
     */
    Set<ArrayList<Integer>> getConnections();
}
