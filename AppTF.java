public class AppTF
{
    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();
        //EdgeWeightedGraph g = new EdgeWeightedGraph("casoa400.txt");
        GrafoDirigidoAlgo gfa = new GrafoDirigidoAlgo("casoa120.txt");
        long tempoTotal = (System.currentTimeMillis())-tempoInicial;

        //long tempoInicial = System.currentTimeMillis();
        //ExploraGrafo eg = new ExploraGrafo(g, "hidrogenio");        
        //long tempoTotal = (System.currentTimeMillis())-tempoInicial;
        System.out.println("hidrogenios necessarios para gerar ouro:");
        //System.out.println(eg.getCustoOuro().toString());
        System.out.println(gfa.getValorOuro());
        System.out.println("tempo total em ms: "+tempoTotal);
    }

}