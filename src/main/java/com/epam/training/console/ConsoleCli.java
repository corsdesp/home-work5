package com.epam.training.console;

import com.epam.training.console.operations.*;
import org.apache.commons.cli.*;

public class ConsoleCli {
    private String[] args;
    private Options options = new Options();
    private CommandLine cmd = null;

    public ConsoleCli(String[] args) {
        this.args = args;

        options.addOption("l", "left", true, "left operand");
        options.addOption("r", "right", true, "right operand");
        options.addOption("o", "operation", true, "operation command: mult, add, div, sub");
    }

    public void parse() {
        CommandLineParser parser = new DefaultParser();
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            help();
            System.exit(0);
        }
        int left = parseOperand("l");
        int right = parseOperand("r");
        String op = "";
        if (cmd.hasOption("o")){
            op = cmd.getOptionValue("o");
        }

        Operation operation = null;
        switch (op) {
            case "mult":
                operation = new Multiplication();
                break;
            case "add":
                operation = new Addition();
                break;
            case "div":
                operation = new Division();
                break;
            case "sub":
                operation = new Subtraction();
                break;
        }
        if (operation != null) {
            System.out.println(operation.calculate(left, right));
        }else {
            help();
        }
    }

    private void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.setOptionComparator(null);
        formatter.printHelp("application", options, true);
    }

    private int parseOperand(String opt) {
        int result = 0;
        if (cmd.hasOption(opt)) {
            result = Integer.parseInt(cmd.getOptionValue(opt));
        }
        return result;
    }
}

