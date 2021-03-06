package com.csi.czech.clone;

import com.csi.czech.source.CycloneSource;
import com.csi.czech.source.Source;

/**
 * Represents a clone detected by the Cyclone tool
 */
public class CycloneClone extends Clone {
    /** Represents the Python AST classification of the code snippet */
    private final String value;
    /** Number representing the similarity between the two code snippets */
    private final Long matchWeight;

    /**
     * Constructor for the Cyclone clone class
     *
     * @param value the Python AST class of the snippet
     * @param matchWeight the similarity between the snippets
     */
    public CycloneClone(String value, Long matchWeight) {
        super();
        this.value = value;
        this.matchWeight = matchWeight;
    }

    /**
     * Returns the Python AST class of the clone
     *
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Returns the match weight of the clone
     *
     * @return the match weight
     */
    public Long getMatchWeight() {
        return this.matchWeight;
    }

    @Override
    public void addSource(Source source) {
        if (!(source instanceof CycloneSource)) {
            throw new IllegalArgumentException("Only Cyclone sources can be "
                    + "attached to a Cyclone clone");
        }
        super.addSource(source);
    }

    // Don't want to take tool-specific parameters into account
    @Override
    public boolean equals(Object o1) {
        return super.equals(o1);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("Cyclone Clone: value: ").append(this.value)
                .append(", match weight: ").append(this.matchWeight).append(", origins: ").append("\n");
        for (Source origin: this.sources) {
            ret.append(origin.toString());
        }
        return ret.toString();
    }
}
