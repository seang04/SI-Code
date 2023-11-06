package frogs;

import java.util.Random;

public class AfricanBullfrog extends Frog{

    AfricanBullfrog()
    {
        super("Pyxicephalus adspersus", "African Bullfrog", 5, 10);

    }

    @Override
    public void ribbit() {
        System.out.println("Brrrrrrrrrrrrroak");
    }

    @Override
    public void hunt() {
        System.out.println("Small rodents and large insects");
    }
}
