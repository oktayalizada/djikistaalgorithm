import java.util.*;


public class Graph{

    private List<Edge> allEdges;
    private Map<String,Vertex> allVertex;
    private List<Vertex> alV;

    public Graph(){
        allEdges = new ArrayList<Edge>();
        allVertex = new HashMap<String,Vertex>();
        alV=new ArrayList<>();
    }

    public Vertex getVertex(String id){
        return allVertex.get(id);
    }

    public void addEdge(String source,String destination, int weight){
        Vertex vertex1 = null;


        if(allVertex.containsKey(source)){
            vertex1 = allVertex.get(source);
        }else{
            vertex1 = new Vertex(source);
            allVertex.put(source, vertex1);
        }
        Vertex vertex2 = null;
        if(allVertex.containsKey(destination)){
            vertex2 = allVertex.get(destination);
        }else{
            vertex2 = new Vertex(destination);
            allVertex.put(destination, vertex2);
        }

        Edge edge = new Edge(vertex1,vertex2,weight);
        allEdges.add(edge);
        vertex1.addNeighbourVertex(edge, vertex2);
        vertex2.addNeighbourVertex(edge, vertex1);

    }



    public Collection<Vertex> getListVertices(){
        return allVertex.values();
    }

}
