package Ants;
import java.util.*;

public class QueenAnt extends Ant{

    public QueenAnt(double size)
    {
        super(size);
        this.setName("Queen-" + this.getId());

    }

    public MinorWorker spawnMinor()
    {
        return new MinorWorker(this.getSize() / 4.0);
    }

    public MajorWorker spawnMajor()
    {
        return new MajorWorker(this.getSize() / 2.0);
    }

    public SuperMajorWorker spawnSuperMajor()
    {
        return new SuperMajorWorker(this.getSize() - 1);
    }

    public Male spawnMale()
    {
        return new Male(this.getSize() / 3.0);
    }

    public Ant spawnAnt()
    {
        double rand = Math.random();
        if(rand < .5) return spawnMinor();
        else if (rand < .7) return spawnMajor();
        else if (rand < .9) return spawnSuperMajor();
        else return spawnMale();
    }
}
