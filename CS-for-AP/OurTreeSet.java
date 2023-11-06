import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class OurTreeSet<T> implements Set {

    private T data;
    private OurTreeSet<T> left;
    private OurTreeSet<T> right;
    private int size = 0;

    public OurTreeSet(T data) {
        this.data = data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if(o != null && o instanceof Comparable) {
            Comparable o2 = (Comparable)o;
            if(o2.compareTo(data) < 0) {
                size++;
                if(left == null) {
                    left = new OurTreeSet<T>(o2);
                    return true;
                } else {
                    return left.add(o2);
                }
            } else if(o2.compareTo(data) > 0) {
                size++;
                if(right == null) {
                    right = new OurTreeSet<T>(o2);
                    return true;
                } else {
                    return right.add(o2);
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
