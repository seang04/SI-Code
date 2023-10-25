import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node<T> {
    private T data;
    private List<Node<T>> children;

    public Node(T data, Node<T> ... children)
    {
        this.children = new ArrayList<>(Arrays.asList(children));
        this.data = data;
    }
    public Node(T data)
    {
        this.children = new ArrayList<>();
        this.data = data;
    }

    public T getData()
    {
        return data;
    }

    public Node<T> getChild(int i)
    {
        return children.get(i);
    }

    public List<Node<T>> getChildren()
    {
        return children;
    }

    public boolean hasChild()
    {
        return children.size() == 0;
    }

}
