import java.util.LinkedList;
import java.util.Queue;
import edu.princeton.cs.algs4.In;

public class WordNet
{
    private Queue<String> nouns = new LinkedList<String>();


    public WordNet(String synets, String hypernyms)
    {
        In synF = new In(synets);
        while (synF.hasNextLine())
        {
            String      line        = synF.readLine();
            String[]    fields      = line.split(",");
            String[]    words       = fields[1].split(" ");
            for (int i = 0; i < words.length; i++)
                if (!nouns.contains(words[i]))
                    nouns.add(words[i]);
        }
    }

    // public Iterable<String> nouns()
    // {}

    // public boolean isNoun(String word)
    // {}

    // public int distance(String nounA, String nounB)
    // {}

    // public String sap(Sting nounA, String nounB)
    // {}

    public static void main(String[] args)
    {}
}
