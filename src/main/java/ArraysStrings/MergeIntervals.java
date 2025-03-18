package ArraysStrings;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[]{1, 3});
        intervals.add(new int[]{2, 4});
        intervals.add(new int[]{3, 10});
        intervals.add(new int[]{15, 18});

        List<int[]> intervals2 = new ArrayList<>();
        intervals.add(new int[]{1,4});
        intervals.add(new int[]{4,5});

        merge(intervals);
        merge(intervals2);

    }

    public static int[][] merge(List<int[]> intervals){

        for (int i = 0; i < intervals.size() - 1; i++) {
                if(intervals.get(i)[1] >= intervals.get(i+1)[0]){ // se a segunda parte do intervalo for maior que o primeira do proximo intervalo
                    intervals.get(i)[1] = Math.max(intervals.get(i)[1], intervals.get(i+1)[1]); // pega o maior valor entre os dois intervalos
                    intervals.remove(i+1); // remove o intervalo que foi unido
                }else{
                    i++; // se não unir, passa para o proximo intervalo
            }
        }

        for(int[] interval : intervals){
            for(int num : interval){
                System.out.println(num + " ");
            }
            System.out.println(" ");
        }

        return null;
    }

}
