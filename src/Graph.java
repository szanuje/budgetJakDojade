import java.util.ArrayList;

public class Graph {

    // A directed graph using
// adjacency list representation


        // No. of vertices in graph
        private int v;

        private ArrayList<ArrayList<Integer>> paths;
        // adjacency list
        private ArrayList<Integer>[] adjList;
        
        public ArrayList<ArrayList<Integer>> getPaths() {
            return paths;
        }

        //Constructor
        public Graph(int vertices){

            //initialise vertex count
            this.v = vertices;
            this.paths = new ArrayList<>();

            // initialise adjacency list
            initAdjList();
        }

        // utility method to initialise
        // adjacency list
        @SuppressWarnings("unchecked")
        private void initAdjList()
        {
            adjList = new ArrayList[v];

            for(int i = 0; i < v; i++)
            {
                adjList[i] = new ArrayList<>();
            }
        }

        // add edge from u to v
        public void addEdge(int u, int v)
        {
            // Add v to u's list.
            adjList[u].add(v);
        }

        // Prints all paths from
        // 's' to 'd'
        public ArrayList<ArrayList<Integer>> getAllPaths(int s, int d)
        {
            boolean[] isVisited = new boolean[v];
            ArrayList<Integer> pathList = new ArrayList<>();

            //add source to path[]
            pathList.add(s);

            //Call recursive utility
            getAllPathsUtil(s, d, isVisited, pathList);

            return this.paths;
        }

        // A recursive function to print
        // all paths from 'u' to 'd'.
        // isVisited[] keeps track of
        // vertices in current path.
        // localPathList<> stores actual
        // vertices in the current path
        private void getAllPathsUtil(Integer u, Integer d,
                                       boolean[] isVisited,
                                       ArrayList<Integer> localPathList) {

            // Mark the current node
            isVisited[u] = true;

            if (u.equals(d))
            {
                System.out.println(localPathList);
                paths.add(new ArrayList<>(localPathList));
                // if match found then no need to traverse more till depth
                isVisited[u]= false;
                return ;
            }

            // Recur for all the vertices
            // adjacent to current vertex
            for (Integer i : adjList[u])
            {
                if (!isVisited[i])
                {
                    // store current node
                    // in path[]
                    localPathList.add(i);
                    getAllPathsUtil(i, d, isVisited, localPathList);

                    // remove current node
                    // in path[]
                    localPathList.remove(i);
                }
            }

            // Mark the current node
            isVisited[u] = false;
        }


    }

