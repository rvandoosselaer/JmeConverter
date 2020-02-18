package com.rvandoosselaer.jmeconverter;

import org.slf4j.bridge.SLF4JBridgeHandler;

import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.LogManager;

/**
 * Starts the converter application and converts the models that are passed as program arguments.
 *
 * @author rvandoosselaer
 */
public class Main {

    private static final String[] HEADER = {
            "      _                 ____                          _            \n" +
                    "     | |_ __ ___   ___ / ___|___  _ ____   _____ _ __| |_ ___ _ __ \n" +
                    "  _  | | '_ ` _ \\ / _ \\ |   / _ \\| '_ \\ \\ / / _ \\ '__| __/ _ \\ '__|\n" +
                    " | |_| | | | | | |  __/ |__| (_) | | | \\ V /  __/ |  | ||  __/ |   \n" +
                    "  \\___/|_| |_| |_|\\___|\\____\\___/|_| |_|\\_/ \\___|_|   \\__\\___|_|   \n" +
                    "                                                                   ",
            "JmeConverter v" + VersionHelper.getVersion(),
            ""
    };
    private static final String[] HELP_TEXT = {
            "Usage: jmeconverter [models]",
            "Where [models] is a list of jMonkeyEngine compatible model files."
    };

    public static void main(String[] args) {
        configureLogging();

        print(HEADER);

        if (args.length == 0) {
            print(HELP_TEXT);
            return;
        }

        Converter converter = new Converter();
        for (String arg : args) {
            converter.convert(Paths.get(arg));
        }
    }

    private static void configureLogging() {
        // send jul to slf4j
        LogManager.getLogManager().getLogger("").setLevel(Level.ALL);
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    private static void print(String... lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

}
