import java.util.HashMap;
import java.util.Map;
import edu.princeton.cs.algs4.In;

public class WordNet
{
    private Map<int, String>   nouns   = new HashMap<>();
    private SAP             wn;

    public WordNet(String synets, String hypernyms)
    {
        In synF = new In(synets);
        while (synF.hasNextLine())
        {
            String      line        = synF.readLine();
            String[]    fields      = line.split(",");
            String[]    words       = fields[1].split(" ");
            for (int i = 0; i < words.length; i++)
                nouns.put(words[i]);
        }
        Digraph G = new Digraph(nouns.length);

    }

    public Iterable<String> nouns()
    {   return nouns.values();   }

    public boolean isNoun(String word)
    {   return nouns.containsValue(word);    }

    // public int distance(String nounA, String nounB)
    // {}

    // public String sap(Sting nounA, String nounB)
    // {}

    public static void main(String[] args)
    {}
}
