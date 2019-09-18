import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;

public class SAP
{
    private Digraph D;

    public SAP(Digraph G)
    {
        D = new Digraph(G);
    }

    public int length(int v, int w)
    {
        Bag<Integer> iterV = new Bag<>();
        Bag<Integer> iterW = new Bag<>();
        iterV.add(v);
        iterV.add(w);
        return length(iterV, iterW);
    }

    public int ancestor(int v, int w)
    {
        Bag<Integer> iterV = new Bag<>();
        Bag<Integer> iterW = new Bag<>();
        iterV.add(v);
        iterV.add(w);
        return ancestor(iterV, iterW);
    }

    public int length(Iterable<Integer> v, Iterable<Integer> w)
    {   return calcBfs(v, w, true); }

    public int ancestor(Iterable<Integer> v, Iterable<Integer> w)
    {   return calcBfs(v, w, false);   }
    
    private int calcBfs(Iterable<Integer> v, Iterable<Integer> w, boolean returnLen)
    {   
        int                         length      = -1;
        int                         ancestor    = -1;
        int                         min         = Integer.MAX_VALUE;
        BreadthFirstDirectedPaths   bfsV        = new BreadthFirstDirectedPaths(D, v);
        BreadthFirstDirectedPaths   bfsW        = new BreadthFirstDirectedPaths(D, w);
     
        for (int i = 0; i < D.V(); i++)
        {
            if (bfsV.hasPathTo(i) && bfsW.hasPathTo(i))
            {
                length = bfsV.distTo(i) + bfsW.distTo(i);
                if (length < min)
                {
                    min         = length;
                    ancestor    = i;
                }
            }
        }
        if (!returnLen)                 return ancestor;
        if (min == Integer.MAX_VALUE)   return length;
        return min;
    }

    public static void main(String[] args)
    { // no unit tests present }

}
