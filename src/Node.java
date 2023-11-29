public class Node {
    Integer id;
    Integer IdParent;
    public Node() {
    }

    public Node(Integer id, Integer idParent) {
        this.id = id;
        IdParent = idParent;
    }

    public Node(Integer id) {
        this.id = id;
        this.IdParent = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdParent() {
        return IdParent;
    }

    public void setIdParent(Integer idParent) {
        IdParent = idParent;
    }
}
