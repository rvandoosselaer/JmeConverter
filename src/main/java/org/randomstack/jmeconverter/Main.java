package org.randomstack.jmeconverter;

import org.slf4j.bridge.SLF4JBridgeHandler;

import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.LogManager;

/**
 * Starts the converter application and converts the models that are passed as program arguments.
 *
 * @author remy
 */
public class Main {

    private static final String[] HEADER = {
            "JmeConverter v" + VersionInfo.getVersion()
    };
    private static final String[] HELP_TEXT = {
            "Usage: jmeconverter [models]",
            "Where [models] is a list of jMonkeyEngine compatible model files."
    };

    public static void main(String[] args) {
        // send jul to slf4j
        LogManager.getLogManager().getLogger("").setLevel(Level.ALL);
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();

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

    private static void print(String... lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

}
