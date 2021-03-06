package com.csi.czech;

import com.csi.czech.cmd.CLIHandler;
import com.csi.czech.cmd.CLIParser;
import com.csi.czech.cmd.CloneOptions;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Main class - runs each of the comparer tools and prints a CSV line with
 * the results. Can also be used to print a header line for the results.
 */
public class Main {
    private static final PrintStream sysOut = System.out;

    public static void main(String[] args) throws IOException {
        CloneOptions options = new CLIParser().parseArgs(args);
        options.accept(new CLIHandler(sysOut));
    }
}
