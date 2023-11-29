import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSort {
    private ArrayList<Integer> inputValues;

    MergeSort()
    {
        inputValues = new ArrayList<>();
    }

    public List<Integer> sort()
    {
        List<Integer> values = new ArrayList<>(inputValues);
        return sort(values);
    }

    public List<Integer> sort(List<Integer> values)
    {
        if(values.size() > 2)
        {
            List<Integer> first = sort(values.subList(0, values.size()/2));
            List<Integer> second = sort(values.subList(values.size()/2, values.size()));
            for(int i = 0; i < first.size(); i++)
            {
                if(second.get(0) < first.get(i))
                {
                    first.add(i, second.get(0));
                    second.remove(0);
                }
            }
            return first;
        }
        else
        {
            List<Integer> out = new ArrayList<>();
            out.add(Math.min(values.get(0), values.get(1)));
            out.add(Math.max(values.get(0), values.get(1)));
            return out;
        }

    }
    public void addInputValue(int i)
    {
        inputValues.add(i);
    }

    public static void main(String[] args) throws IOException
    {
        MergeSort sort = new MergeSort();
        System.out.println("Enter list of integer values to be sorted.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        Scanner stdin = new Scanner(line);

        while(stdin.hasNextInt())
        {
            sort.addInputValue(stdin.nextInt());
        }

        System.out.println(sort.sort());


    }

}
