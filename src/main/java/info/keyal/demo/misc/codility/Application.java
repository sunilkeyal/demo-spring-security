package info.keyal.demo.misc.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


@SuppressWarnings("java:S106")
public class Application {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Rotate an array to the right by a given number of steps
        System.out.println("****** Array Rotation *******");
        int[] input = {2,6,8,3,1,3,9};
        System.out.println(Arrays.toString(input));
        int[] output = solution.rotation(input, 4);
        System.out.println(Arrays.toString(output));

        // Odd occurrence in array
        System.out.println("****** Odd Element *******");
        input = new int[]{6, 7, 5, 6, 7};
        System.out.println(solution.oddElement(input));

        // missing number in array
        System.out.println("****** missing Element *******");
        input = new int[]{2,1,3,5};  // answer should be 4
        System.out.println(solution.missing(input));

        // permutation
        System.out.println("****** permutation *******");
        input = new int[]{2,1,3,5};   // 0
        System.out.println(solution.permutation(input));
        input = new int[]{2,1,3,4};   // 1
        System.out.println(solution.permutation(input));

        // number of distinct values
        System.out.println("****** number of distinct values *******");
        input = new int[]{2,1,3,5, 3, 5, 1, 2, 2, 2,};   // 4
        System.out.println(solution.distinct(input));
        input = new int[]{2,1,3,4, 5, 4, 3, 2, 5, 1, 2, 4};   // 5
        System.out.println(solution.distinct(input));

        // passing cars
        System.out.println("****** passing cars *******");
        input = new int[]{0, 1, 0, 1, 1};   // 5
        System.out.println(solution.passingCars(input));
        input = new int[]{0, 0, 1, 0, 1, 1};   // 8
        System.out.println(solution.passingCars(input));

        // dominator
        System.out.println("****** dominator *******");
        input = new int[]{1, 1, 4, 4, 4};   // 0 or 3, or 4
        System.out.println(solution.dominator(input));
        input = new int[]{0, 5, 3, 0, 1, 1};   // -1
        System.out.println(solution.dominator(input));

        // FrogJmp
        System.out.println("****** frog jump  *******");
        System.out.println(solution.frogJump(1, 5, 2));
        System.out.println(solution.frogJump(10, 11, 5));
        System.out.println(solution.frogJump(3, 20, 5));
        System.out.println(solution.frogJump(3, 999111321, 7));

        // flags
        System.out.println("****** fMinAbsSumOfTwo *******");
        input = new int[]{1,4,-3}; // 1
        System.out.println(solution.MinAbsSumOfTwo(input));
        input = new int[]{-8,4,5,-10,3}; // 3
        System.out.println(solution.MinAbsSumOfTwo(input));


        System.out.println("This is a debug message");
        input = new int[]{ 2,-3,3,9,1,10,8,1,2,5,13,-5,3,-18,1,6 };

        int numberOfSeason = 4;
        // int[] input = {1,2,3,4};

        input = new int[]{ 2,-3,3,9,1,10,8,1,2};
        numberOfSeason = 3;

        System.out.println(answer(input, numberOfSeason));


    }

    public static int answer(int[] input, int numberOfSeason) {

        if (input.length < numberOfSeason * 2) throw new RuntimeException("Invalid number of days or blah blah");
        int count = input.length / numberOfSeason;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int diff = 0;
        int finaldiff = 0;
        for (int i = 0; i < input.length; i++) {
            int item = input[i];

            if (item > max) max = item;
            if (item < min) min = item;

            if ((i + 1) % count == 0) {
                // System.out.println(i);
                diff = max - min;
                if (finaldiff < diff) finaldiff = diff;
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                diff = 0;
            }
        }
        return finaldiff;

    }


}

@SuppressWarnings("java:S106")
class Solution {

    // Rotate an array to the right by a given number of steps
    public int[] rotation(int[] A, int K) {
        if (K > A.length && A.length > 0) {
            K = K % A.length;
        }
        int[] b = new int[A.length];
        int startingPoint = A.length - K;
        for (int i = 0; i < A.length; i++) {
            if (startingPoint + i < A.length) {
                b[i] = A[startingPoint + i];
            } else {
                b[i] = A[i - K];
            }
        }
        return b;
    }

    // Odd occurrence in array
    public int oddElement(int[] A) {
        // write your code in Java SE 8
//        List<Integer> answer = new ArrayList<>();
//        for (int value : A) {
//            if (answer.contains(value)) {
//                answer.remove(Integer.valueOf(value));
//            } else {
//                answer.add(value);
//            }
//        }
//        return answer.get(0);

        int res = 0;
        for (int value : A) {
            res = res ^ value;
        }
        return res;
    }


    // PermMissingElem
    public int missing(int[] A) {
        // write your code in Java SE 8
//        List<Integer> list = Arrays.stream(A).boxed().sorted().collect(Collectors.toList());
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) != i + 1) return i + 1;
//        }
//        return list.size() + 1;

        int[] anotherList = new int[A.length + 1];
        for (int position : A) {
            anotherList[position - 1] = 1;
        }
        int found = 0;
        for (int i = 0; i < anotherList.length; i++) {
            if (anotherList[i] == 0) {
                found = i + 1;
                break;
            }
        }
        return found;
    }

    // smallest positive integer (greater than 0) that does not occur in A
    public int solution(int[] A) {
        // write your code in Java SE 8
        List<Integer> finalIntegerList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            finalIntegerList.add(i + 1);
        }
        for (int value : A) {
            finalIntegerList.remove(Integer.valueOf(value));
        }
        return finalIntegerList.get(0);
    }

    // permutation
    public int permutation(int[] A) {
        // write your code in Java SE 8
        int[] anotherList = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            int position = A[i] - 1;
            if (value > A.length) return 0;
            if (anotherList[position] > 0) return 0;
            anotherList[position] = value;
        }

        for (int i = 0; i < anotherList.length; i++) {
            if (anotherList[i] == 0) return 0;
        }
        return 1;
    }

    // number of distinct values
    public int distinct(int[] A) {
        Set<Integer> solutions = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            solutions.add(A[i]);
        }
        return solutions.size();
    }

    public int passingCars(int[] A) {
//        int total = 0;
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] == 0) {
//                for (int k = i + 1; k < A.length; k ++ ) {
//                    if (A[k] == 1) total++;
//                }
//            }
//        }
//        return total;


        int count = 0;
        int multiply = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                multiply = multiply + 1;
            }
            if (A[i] == 1) {
                count = count + multiply;
                if (count > 1000000000) {
                    return -1;
                }
            }
        }
        return count;
    }

    public int dominator(int[] A) {

        Map<Integer, Integer> finalMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (finalMap.containsKey(A[i])) {
                finalMap.put(A[i], finalMap.get(A[i]) + 1);
            } else {
                finalMap.put(A[i], 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> hmIterator = finalMap.entrySet().iterator();
        boolean found = false;
        int resultValue = 0;
        while (hmIterator.hasNext()) {
            Map.Entry<Integer, Integer> mapElement = (Map.Entry<Integer, Integer>) hmIterator.next();
            if (mapElement.getValue() > A.length / 2) {
                found = true;
                resultValue = mapElement.getKey();
            }
        }
        if (!found) return -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == resultValue) {
                return i;
            }
        }
        return -1;
    }

    // Frog jump
    public int frogJump(int X, int Y, int D) {
//        if (X == Y) return 0;
//
//        int totalSteps = 0;
//        int currentPosition = X;
//        while (currentPosition < Y) {
//            currentPosition = currentPosition + D;
//            totalSteps++;
//        }
//        return totalSteps;

        if (X == Y) return 0;

        if ((Y - X) % D == 0) {
            return (Y - X) / D;
        } else {
            return (Y - X) / D + 1;
        }

    }


//    public static int solution(int[] input) {
//
//        int count = input.length / 4;
//
//        System.out.println(solution(count));
//        return 0;
//    }


    public int MinAbsSumOfTwo(int[] A) {

//        int minimum = 2000000000;
//        for (int i = 0; i < A.length; i++) {
//            for (int j = i; j < A.length; j++) {
//                int current = A[i] + A[j];
//                if (current < 0) current = current * (-1);
//                if (minimum > current) minimum = current;
//            }
//        }
//        return minimum;


        int N = A.length;
        Arrays.sort(A);
        int tail = 0;
        int head = N - 1;
        int minAbsSum = Math.abs(A[tail] + A[head]);
        while (tail <= head) {
            int currentSum = A[tail] + A[head];
            minAbsSum = Math.min(minAbsSum, Math.abs(currentSum));
            // If the sum has become
            // positive, we should know that the head can be moved left
            if (currentSum <= 0)
                tail++;
            else
                head--;
        }
        return minAbsSum;
    }
}
