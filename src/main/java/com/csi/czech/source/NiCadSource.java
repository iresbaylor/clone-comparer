package com.csi.czech.source;

/**
 * File source read from NiCad. Contains additional information.
 */
public class NiCadSource extends Source {
    /** Additional info read from NiCad (not used) */
    private Long pcId;

    /**
     * Constructor for a NiCad source
     * @param filename the name of the file containing the snippet
     * @param startLine the start of the snippet
     * @param endLine the end of the snippet
     * @param pcId additional NiCad info
     */
    public NiCadSource(String filename, Long startLine, Long endLine, Long pcId) {
        super(filename, startLine, endLine);
        this.pcId = pcId;
    }

    /**
     * Returns the PC ID of the source
     *
     * @return the PC ID
     */
    public Long getPcId() {
        return pcId;
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
        return "Source: " + this.filename + ": " + this.startLine + "-" + this.endLine + ", ID=" + this.pcId;
    }
}
