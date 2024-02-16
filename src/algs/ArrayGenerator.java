package algs;

import java.util.ArrayList;
import java.util.List;

public class ArrayGenerator {

    private List<List<Integer>> permutations;

    public ArrayGenerator() {
        this.permutations = new ArrayList<>();
    }

    public void generatePermutations(int n) {
        permutations.clear(); // Clear previous results
        List<Integer> initialList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            initialList.add(i);
        }
        permute(initialList, 0);
    }

    private void permute(List<Integer> array, int start) {
        if (start >= array.size()) {
            permutations.add(new ArrayList<>(array));
        } else {
            for (int i = start; i < array.size(); i++) {
                java.util.Collections.swap(array, start, i);
                permute(array, start + 1);
                java.util.Collections.swap(array, start, i);
            }
        }
    }

    public List<List<Integer>> getPermutations() {
        return permutations;
    }
}