import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

public class WordNet
{
    private Map<Integer, Bag<String>>   nouns   = new HashMap<>();
    private Queue<String>               single  = new LinkedList<>();
    private SAP                         wn;

    public WordNet(String synets, String hypernyms)
    {
        In synF = new In(synets);
        while (synF.hasNextLine())
        {
            String      line    = synF.readLine();
            String[]    fields  = line.split(",");
            String[]    words   = fields[1].split(" ");
            Bag<String> bag     = new Bag<>();
            for (int i = 0; i < words.length; i++)
            {
                bag.add(words[i]);
                single.add(words[i]);
            }
            nouns.put(Integer.parseInt(fields[0]), bag);
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
    }

    public Iterable<String> nouns()
    {   return single;   }

    public boolean isNoun(String word)
    {   return single.contains(word);    }

    // public int distance(String nounA, String nounB)
    // {}

    // public String sap(Sting nounA, String nounB)
    // {}

    public static void main(String[] args)
    {}
}
