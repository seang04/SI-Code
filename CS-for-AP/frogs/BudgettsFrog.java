package frogs;

public class BudgettsFrog extends Frog{

    BudgettsFrog()
    {
        super("Lepidobatrachus Laevis", "Budgett's Frog", 2, 4);
    }

    @Override
    public void ribbit() {
        System.out.println("reeeeeeeeee");
    }

    @Override
    public void hunt() {
        System.out.println("");
    }
}
