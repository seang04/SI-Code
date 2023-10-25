package Ants;

public abstract class Ant {
    private int id;
    private static int nextId = 0;
    private double size;
    private String name;


    public Ant(double size)
    {
        this.size = size;
        this.id = nextId;
        nextId++;
    }

    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Ant other)) return false;
        return other.size == this.size && other.name.equals(this.name) && other.id == this.id;
    }

    @Override
    public int hashCode()
    {
        return name.hashCode() + id + (int)size;
    }

    @Override
    public String toString()
    {
        return String.format("%d: %s", id, name);
    }

    //getters and setters

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
