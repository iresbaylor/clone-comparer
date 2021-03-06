package com.csi.czech.comparer;

import com.csi.czech.clone.Clone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Compares clones which have been parsed from the input files.
 * Contains only the method to run the comparison.
 */
public class CloneComparer {
    /**
     * Private constructor to hide public constructor
     */
    private CloneComparer() {}

    /**
     * Takes two lists of parsed clones and compares them,
     * returning the percentage p of clones in the first list
     * which match clones in the second list (0 <= p <= 1)
     *
     * @param cloneList1 the first clone list to compare
     * @param cloneList2 the second clone list to compare
     * @return the percentage of similarity
     */
    public static double compareCloneLists(List<Clone> cloneList1,
                                    List<Clone> cloneList2) {
        if (cloneList1.isEmpty() || cloneList2.isEmpty()) {
            if (cloneList1.isEmpty() && cloneList2.isEmpty()) {
                // They caught the same clones, technically
                return 1.0;
            }
            // One of these is bad
            return 0.0;
        }

        Map<Clone, Clone> cloneMap = new HashMap<>();
        for (Clone clone1: cloneList1) {
            for (Clone clone2: cloneList2) {
                if (clone1.equals(clone2)) {
                    // Overwrite any existing clone so we only count each once
                    cloneMap.put(clone1, clone2);
                }
            }
        }

        double numMatchedClones = cloneMap.size();
        double numClones = cloneList1.size();
        return numMatchedClones / numClones;
    }
}
