import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

public class WordNet
{
    private Map<String, Integer>    nouns   = new HashMap<>();
    private Map<Integer, String>    ids     = new HashMap<>();  
    private SAP                     wn;

    public WordNet(String synets, String hypernyms)
    {
        In synF = new In(synets);
        while (synF.hasNextLine())
        {
            String      line    = synF.readLine();
            String[]    fields  = line.split(",");
            String[]    words   = fields[1].split(" ");
            int         iter    = Integer.parseInt(fields[0]);
            for (int i = 0; i < words.length; i++)
                nouns.put(words[i], iter);
            ids.put(iter, fields[1]);
        }
        Digraph G = new Digraph(nouns.size());

        In hypF = new In(hypernyms);
        while (hypF.hasNextLine())
        {
            String      line    =   hypF.readLine();
            String[]    fields  =   line.split(",");
            int         v       =   Integer.parseInt(fields[0]);
            int         w;
            for (int i = 1; i < fields.length; i++)
            {
                w = Integer.parseInt(fields[i]);
                G.addEdge(v, w);
            }
        }
        wn = new SAP(G);
    }

    public Iterable<String> nouns()
    {   return nouns.keySet();   }

    public boolean isNoun(String word)
    {   return nouns.containsKey(word);    }

    public int distance(String nounA, String nounB)
    {
        if (!isNoun(nounA) || !isNoun(nounB))
            throw new IllegalArgumentException("One of the arguments is invalid");
        int a = nouns.get(nounA);
        int b = nouns.get(nounB);
        return wn.length(a, b);
    }

    public String sap(String nounA, String nounB)
    {
        if (!isNoun(nounA) || !isNoun(nounB))
            throw new IllegalArgumentException("One of the arguments is invalid");
        int a = nouns.get(nounA);
        int b = nouns.get(nounB);
        int i = wn.ancestor(a, b);
        return ids.get(i);
    }

    public static void main(String[] args)
    {}
}
