import java.util.LinkedList;
import java.util.List;


public class TicModel{
    private char[][] board = new char[3][3];
    private List<Observer<TicModel>> observerList = new LinkedList<>();

    TicModel()
    {
        for(char[] row : board)
        {
            for(int i = 0; i < 3; i++)
            {
                row[i] = '.';
            }
        }
    }

    public boolean placeO(int row, int col)
    {
        char c = board[row][col];
        if(c == 'O' || c == 'X') return false;
        board[row][col] = 'O';
        alertObservers();
        return true;
    }

    private boolean placeX(int row, int col)
    {
        return false;
    }
    private void alertObservers()
    {
        for( Observer< TicModel> observer : observerList)
        {
            observer.update(this);
        }
    }

    public void addObserver( Observer< TicModel > observer) { observerList.add(observer);}

    public char[][] getBoard() {return  board;}
}
