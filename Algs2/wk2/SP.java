public class SP
{
    public SP(EdgeWeightedDigraph g, int s)
    public double distTo(int v)
    public Iterable <DirectedEdge> pathTo(int v)
    public static void main(String[] args)
    {
        SP sp = new SP(G, s);
        for (int i = 0; i < G.V(); v++)
        {
            StdOut.printf("%d to %d (%.2f): ", s, i, sp.distTo(i));
            for (DirectedEdge e : sp.pathTo(i))
                StdOut.print(e + " ");
            StdOut.println();
        }
}
