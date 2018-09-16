class Edge{
    private String id;
    private Vertex source;
    private Vertex destination;
    private int weight;
    Edge(Vertex source, Vertex destination,int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    Edge(String id,Vertex source, Vertex destination,int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    public Vertex getSource() {
        return source;
    }
    public Vertex getDestination() {
        return destination;
    }

    int getWeight(){
        return weight;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((source == null) ? 0 : source.hashCode());
        result = prime * result + ((destination == null) ? 0 : destination.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge other = (Edge) obj;
        if (source == null) {
            if (other.source != null)
                return false;
        } else if (!source.equals(other.source))
            return false;
        if (destination == null) {
            if (other.destination != null)
                return false;
        } else if (!destination.equals(other.destination))
            return false;
        return true;
    }


}
