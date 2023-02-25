import java.util.ArrayList;
import java.util.Iterator;

public class MinMiddleMax {
    static int minIndex = 0;
    static int middleIndex = 1;
    static int maxIndex = 2;
    static int[] getMinMiddleMax(ArrayList<Integer> list){
        int[] answer = new int[3];
        Iterator<Integer> col = list.iterator();
        int i = 0;
        int iter;
        while (col.hasNext()) {
            iter = col.next();
            if(i == 0){
                for(int o = 0;o < answer.length; o++){
                    answer[o] = iter;
                }
            }
            else{
                answer[middleIndex] += iter;
                if (answer[minIndex] > iter) answer[minIndex] = iter;
                if (answer[maxIndex] < iter) answer[maxIndex] = iter;
            }
            i++;
        }
        answer[middleIndex] = (int)(answer[middleIndex]/i);
        return answer;
    }

    public static void main(String[] args){
        ArrayList<Integer> list = MergeSort.getRandomList(0, 1000, 128);
        list = MergeSort.getMergeSortedList(list);
        MergeSort.printArray(list);
        int[] answer = getMinMiddleMax(list);
        System.out.printf("Элемент минимального значения в массиве: %d\n",answer[minIndex]);
        System.out.printf("Среднее арифметическое значение элементов массива: %d\n",answer[middleIndex]);
        System.out.printf("Элемент максимального значения в массиве: %d\n",answer[maxIndex]);
    }
}
