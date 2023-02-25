import java.util.*;
import java.util.random.RandomGenerator;

public class MergeSort {
    static int sizeList = 100;
    static int getRandomInt(int start, int stop){
        double returnInt;
        double equaliser = 2.147483648e+9;
        Random rnd = new Random();
        long random = rnd.nextInt();
        if(random < 0) random *= -1;
        long delta = stop - start;
        returnInt = ((double)(random * delta)/equaliser) + (double) start;
        double ost = (double)stop - returnInt;
        if(ost < 0.5) returnInt = (double)stop + 0.5;
        return (int)returnInt;
    }
    static ArrayList<Integer> getRandomList(int start, int stop, int size){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < size; i++){
            list.add(getRandomInt(start, stop));
        }
        return list;
    }

    static ArrayList<Integer> getMergeSortedList(ArrayList<Integer> list){
        int[][] merge = new int[list.size()][];
        int i = 0;
        for(int o: list){
            merge[i] = new int[1];
            merge[i++][0] = o;
        }
        return makeMergeSortedList(merge);
    }

    static ArrayList<Integer> makeMergeSortedList(int[][] merge){
        if(merge.length > 2) {
            int[][] newMerge = new int[merge.length/2][merge[0].length*2];
            for (int i = 0; i < newMerge.length; i ++) {
                int a = 0; int b = 0;
                for (int j = 0; j < newMerge[0].length; j++) {
                    if(a < merge[0].length){
                        if(b < merge[0].length){
                            if(merge[i][a] < merge[merge.length - 1 - i][b]){
                                newMerge[i][j] = merge[i][a++];
                            }
                            else{
                                newMerge[i][j] = merge[merge.length - 1 - i][b++];
                            }
                        }
                        else{
                                newMerge[i][j] = merge[i][a++];
                        }
                    }
                    else{
                                newMerge[i][j] = merge[merge.length - 1 - i][b++];
                    }
                }
            }
            merge = newMerge;
            return makeMergeSortedList(merge);
        }
        else{
            ArrayList<Integer> list = new ArrayList<Integer>();
            int[] newMerge = new int[merge[0].length*2];
            int a = 0; int b = 0;
            for (int j = 0; j < merge[0].length*2; j++) {
                if(a < merge[0].length){
                    if(b < merge[0].length){
                        if(merge[0][a] < merge[1][b]){
                            list.add(merge[0][a++]);
                        }
                        else{
                            list.add(merge[1][b++]);
                        }
                    }
                    else{
                            list.add(merge[0][a++]);
                    }
                }
                else{
                            list.add(merge[1][b++]);
                }
            }
            return list;
        }
    }

    static void printArray(ArrayList<Integer> list){
        Iterator<Integer> col = list.iterator();
        while (col.hasNext()){
            for (int i = 0; i < 10; i++) {
                if(col.hasNext()){
                    System.out.printf("%d ",col.next());
                }
                else{
                    break;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] Args) {
        ArrayList<Integer> list = getRandomList(0, 1000, 128);
        list = getMergeSortedList(list);
        printArray(list);
    }
}
