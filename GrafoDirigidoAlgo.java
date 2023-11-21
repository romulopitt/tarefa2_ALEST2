import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GrafoDirigidoAlgo {
  protected static final String NEWLINE = System.getProperty("line.separator");

  protected Map<String, List<Edge>> graph;
  private Map<String,BigInteger> m;


  public GrafoDirigidoAlgo() {
    graph = new HashMap<>();    
  }

  public GrafoDirigidoAlgo(String filename) {
    this();
    m = new HashMap<>();
    m.put("hidrogenio", BigInteger.valueOf(1));
    In in = new In(filename);
    String line;
    while((line = in.readLine()) != null) {
      String[] edge = line.split(" ");
      int tamanho = edge.length;
      String destino = edge[tamanho-1];
      BigInteger valor = BigInteger.valueOf(0);
      tamanho -=4;
      while(tamanho>0){
        int peso = Integer.parseInt(edge[tamanho-1]);
        String origem = edge[tamanho];
        addEdge(origem, destino, peso);
        tamanho-=2;
        BigInteger addValor = BigInteger.valueOf(peso);
        addValor = addValor.multiply(m.get(origem));
        valor = valor.add(addValor);
      }
      m.put(destino,valor);
    }
    in.close();
  }

  public BigInteger getValorOuro(){
    return m.get("ouro");
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
