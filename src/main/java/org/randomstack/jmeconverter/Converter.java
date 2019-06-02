package org.randomstack.jmeconverter;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * The main starting point of the converter. First the model is loaded using the {@link ModelLoader}. The resulting
 * {@link Model} is then processed by the configured {@link Processor} list. The processors are executed in the order in
 * which they have been added to the list.
 *
 * @author remy
 */
@Slf4j
public class Converter {

    private final ModelLoader loader = new ModelLoader();
    private final List<Processor> processors = new ArrayList<>();

    public Converter() {
        processors.add(new GroovyProcessor());
        processors.add(new BinaryWriter());
    }

    public void convert(Path file) {
        Model model = loader.load(file);

        processors.forEach(processor -> processor.process(model));
    }

    public void addProcessor(int index, Processor processor) {
        processors.add(index, processor);
    }

    public void removeProcessor(Processor processor) {
        processors.remove(processor);
    }

}
