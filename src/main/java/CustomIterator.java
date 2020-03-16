import java.util.Collection;
import java.util.List;

public class CustomIterator {
//   1 2 3 2 3 4
    //    n 2
//    h true // 2
//    n 2
//    h true // 4
//    n 4
//    h false
//    n exception
    private List<Integer> array;
    private int count = 0;
    private int evenCounter = 0;

    public CustomIterator(Collection<Integer> array) {
        this.array = (List) array;
    }
    public int next() throws Exception {
        Integer element = array.get(count);
        int divider = element / 2;
        if (divider == 0) {
            count++;
            return element;
        } else {
            count++;
            if (hasNextElement()) next();
            else throw new Exception("no such element");
        }
        throw new Exception("unsupported operation");
    }

    public boolean hasNextElement() {
        return count < array.size();
    }

    public boolean hasNext(){
        Integer element = array.get(count);
        int i = element / 2;
        if(i == 0){
            evenCounter = count;
            evenCounter++;
            return getNextEven();
        }else{
            return getNextEven();
        }
    }
    public boolean getNextEven(){
        Integer element = array.get(evenCounter);
        int divider = element / 2;
        if (divider == 0) {
            return true;
        } else {
            evenCounter++;
        if(hasNextElement()) return getNextEven();
        else return false;
        }
    }
}
