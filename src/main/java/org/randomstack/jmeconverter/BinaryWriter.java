package org.randomstack.jmeconverter;

import com.jme3.export.binary.BinaryExporter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A processor implementation that saves the converted model as a JME binary (.j3o) next to the original model file.
 *
 * @author remy
 */
@Slf4j
public class BinaryWriter implements Processor {

    public static final String EXTENSION = ".j3o";
    
    @Override
    public void process(Model model) {
        Path output = Paths.get(model.getPath().getParent().toAbsolutePath().toString(), getFileName(model.getPath()));
        try {
            BinaryExporter.getInstance().save(model.getSpatial(), output.toFile());
            log.info("Saving {} to {}", model.getSpatial(), output.toAbsolutePath().toString());
        } catch (IOException e) {
            log.error("Error saving model: {}", e.getMessage(), e);
        }
    }

    private String getFileName(Path modelPath) {
        String fileName = modelPath.getFileName().toString();
        if (fileName.contains(".")) {
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
        }
        return fileName + EXTENSION;
    }

}
