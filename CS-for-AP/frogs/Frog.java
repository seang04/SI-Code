package frogs;

import java.util.Random;

public abstract class Frog {
    private String scientific_name;
    private String common_name;
    private double size;

    Frog(String scientific_name, String common_name, double min_size, double max_size) {
        this.scientific_name = scientific_name;
        this.common_name = common_name;
        Random rand = new Random();
        double size = min_size + rand.nextDouble(max_size - min_size);
        this.size = size;
    }

    abstract public void ribbit();

    abstract public void hunt();
}
