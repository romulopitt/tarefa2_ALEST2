import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class ExploraGrafo {
    private Map<String, BigInteger> m;
    BigInteger custoOuro;

    public ExploraGrafo(EdgeWeightedGraph g, String s) {
        m = new HashMap<>();
        custoOuro = BigInteger.valueOf(0);
        dfs(g, s);
    }

    private void dfs(EdgeWeightedGraph g, String v) {
        for (Edge e : g.getAdj(v)) {
            if(v=="hidrogenio")
                m.clear();
                m.put("hidrogenio",BigInteger.valueOf(1));
            String w = e.getW();
            int peso = e.getWeight();
            BigInteger pesoW = BigInteger.valueOf(peso).multiply(m.get(v));
            m.put(w, pesoW);
            if (w.equals("ouro")){
                custoOuro = custoOuro.add(pesoW);
            }
            dfs(g, w);
            }
    }

    public BigInteger getCustoOuro(){
        return custoOuro;
    }
}