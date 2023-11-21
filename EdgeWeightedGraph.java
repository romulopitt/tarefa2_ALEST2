import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EdgeWeightedGraph {
  protected static final String NEWLINE = System.getProperty("line.separator");

  protected Map<String, List<Edge>> graph;


  public EdgeWeightedGraph() {
    graph = new HashMap<>();
  }

  public EdgeWeightedGraph(String filename) {
    this();
    In in = new In(filename);
    String line;
    while((line = in.readLine()) != null) {
      String[] edge = line.split(" ");
      int tamanho = edge.length;
      String destino = edge[tamanho-1];
      tamanho -=4;
      while(tamanho>0){
        addEdge(edge[tamanho], destino, Integer.parseInt(edge[tamanho-1]));
        tamanho-=2;
      }
    }
    in.close();
  }

  public void addEdge(String v, String w, int weight) {
    Edge e = new Edge(v, w, weight);
    addToList(v, e);
  }

  public Iterable<Edge> getAdj(String v) {
    List<Edge> adjList = graph.get(v);
    if(adjList == null)
      adjList = Collections.emptyList();
    return adjList;
  }

  public Set<String> getVerts() {
    return graph.keySet();
  }

  protected List<Edge> addToList(String v, Edge e) {
    List<Edge> list = graph.get(v);
    if (list == null)
      list = new LinkedList<>();
    list.add(e);
    graph.put(v, list);
    return list;
  }
}
