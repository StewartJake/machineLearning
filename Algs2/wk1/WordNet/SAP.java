import algs4.cs.princeton.edu.BreadthFirstDirectedPaths;
import algs4.cs.princeton.edu.Digraph;

public class SAP
{
    private Digraph                     D;
    private BreadthFirstDirectedPaths   singleBfs;
    private BreadthFirstDirectedPaths   multplBfs;

    public SAP(Digraph G)
    {
        D = new Digraph(G);
    }

    public int length(int v, int w)
    {
        singleBfs = new BreadthFirstDirectedPaths(D, v);
        if (!hasPathTo(w))  return -1;
        return singleBfs.distTo(w);
    }

    public int ancestor(int v, int w)
    {}

    public int length(iterable<Integer> v, Iterable<Integer> w)
    {}

    public int ancestor(Iterable<Integer> v, Iterable<Integer> w)
    {}

    public static void main(String[] args)
    {}
}
