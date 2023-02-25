import java.util.ArrayList;
import java.util.Iterator;

public class EvenFree {

    static ArrayList<Integer> getEvenFree(ArrayList<Integer> list){
        Iterator<Integer> col = list.iterator();
        while (col.hasNext()) {
            if(col.next() % 2 == 0){
                col.remove();
            }
        }
        return list;
    }
    public static void main(String[] args){
        ArrayList<Integer> list = MergeSort.getRandomList(0, 1000, 128);
        list = getEvenFree(list);
        MergeSort.printArray(list);
    }
}
