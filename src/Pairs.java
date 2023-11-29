import java.util.*;

public class Pairs {
//     Given 2 arrays and  a number N, find all pairs composed of one element from each array that sum N.
//
//     Example:
//             [-1, 0, 3, 3, 5, 7, 0, 9, 10, -5 ]
//             [-2, 1, 4, 2, 2, 8, 10, 11, 0, 13]
//             N = 7
//             Expected Result:
//             [(-1, 8), (3, 4), (3, 4), (5, 2), (5, 2), (7, 0), (9, -2)]

    public static void PrintList(List list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            List<Integer> pair = (List<Integer>) list.get(i);
            System.out.println("(" + pair.get(0) + ", " + pair.get(1) + ")");
        }
    }
    public static List<Integer> pairsBrute(List<Integer> array1, List<Integer> array2, Integer n){
        List array = new ArrayList<>();
        for (int i = 0; i < array1.size(); i++ ){
            for (int j = 0; j < array2.size(); j++){
                if (array1.get(i) + array2.get(j) == n){
                    array.add(List.of(array1.get(i),array2.get(j)));
                }
            }
        }
        return array;
    }

    public static List pairsMath(List<Integer> array1, List<Integer> array2, Integer n){
        HashMap<Integer,Integer> ar1 = new HashMap<>();
        for (int i = 0; i < array1.size(); i++){
            int num = array1.get(i);
            if (ar1.containsKey(num)){
                ar1.put(num,ar1.get(num) + 1);
            } else {
                ar1.put(num,0);
            }
        }
        List res = new ArrayList<>();

        for (int i = 0; i < array2.size(); i++){
            int num = array2.get(i);
            int nmn = n - num;
            if(ar1.containsKey(nmn)){
                res.add(List.of(nmn, num));
                if(ar1.get(nmn) > 0) {
                    ar1.put(nmn, ar1.get(nmn) - 1);
                } else {
                    ar1.remove(nmn);
                }
            }
        }
        return res;
    }
    public static List<List<Integer>> findPairsAi(List<Integer> array1, List<Integer> array2, int N) {
        Set<Integer> set = new HashSet<>(array1);
        List<List<Integer>> result = new ArrayList<>();

        for (int num : array2) {
            int complement = N - num;
            if (set.contains(complement)) {
                result.add(Arrays.asList(complement, num));
            }
        }

        return result;
    }
    public static void main(String[] args) {
        List<Integer> array1 = Arrays.asList(-1, 0, 3, 3, 5, 7, 0, 9, 10, -5);
        List<Integer> array2 = Arrays.asList(-2, 1, 4, 2, 2, 8, 10, 11, 0, 13);
        Integer n = 7;
//        PrintList(pairsBrute(array1,array2,n));
        PrintList(pairsMath(array1, array2, n));
    }
}
