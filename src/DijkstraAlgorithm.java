import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class DijkstraAlgorithm {
    private Graph graph;
    Map<Vertex, Vertex> predecessors;
    Map<Vertex,Integer> duration;
    public DijkstraAlgorithm(Graph graph){
        this.graph=graph;
    }

    public LinkedList<Vertex> getPath(Vertex target) {
        LinkedList<Vertex> path = new LinkedList<Vertex>();
        Vertex step = target;
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }
    public void execute(Vertex source){
        MinHeap<Vertex> settledAndUnsettledNodes = new MinHeap<>();
        duration = new HashMap<>();
        predecessors= new HashMap<>();
        graph.getListVertices().forEach((v)->settledAndUnsettledNodes.add(Integer.MAX_VALUE,v));
        settledAndUnsettledNodes.decrease(source, 0);
        duration.put(source, 0);
        predecessors.put(source, null);
        while(!settledAndUnsettledNodes.isEmpty()){
            MinHeap<Vertex>.Node heapNode = settledAndUnsettledNodes.extractMinNode();
            Vertex current = heapNode.key;
            duration.put(current, heapNode.weight);
                current.getEdges().forEach(edge->{
                    VertexEdge adjacent =(Vertex vert, Edge edg)->edg.getSource().equals(vert) ? edg.getDestination() : edg.getSource();
                    if(settledAndUnsettledNodes.containsData(adjacent.get(current, edge))){
                    int newDistance = duration.get(current) + edge.getWeight();
                    if(settledAndUnsettledNodes.getWeight(adjacent.get(current, edge)) > newDistance) {
                        settledAndUnsettledNodes.decrease(adjacent.get(current, edge), newDistance);
                        predecessors.put(adjacent.get(current, edge), current);
                      }
                    }
                });



        }

    }




}