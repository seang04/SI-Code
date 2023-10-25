package Ants;

import java.util.*;

public class AntFarm {

    public static void main(String[] args)
    {
        if(args.length < 1)
        {
            System.err.println("At least one commandline argument required. Given " +args.length);
            return;
        }

        List<QueenAnt> queens =  new ArrayList<>();

        for(int i = 0; i < args.length; i++)
        {
            queens.add(new QueenAnt(Double.parseDouble(args[i])));
        }

        //declare some collections here.

        long prev_time = System.currentTimeMillis();
        long one_second_timer = 0;
        while(true)
        {
            one_second_timer += System.currentTimeMillis() - prev_time;
            prev_time = System.currentTimeMillis();

            if(one_second_timer >= 1000)
            {
                //Things that should happen every second occur here.
                for(QueenAnt queen : queens)
                {
                    Ant spawn = queen.spawnAnt();

                }
                one_second_timer = 0;
            }
        }
    }
}
