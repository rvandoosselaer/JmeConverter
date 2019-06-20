package org.randomstack.jmeconverter;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * The main starting point of the converter. First the model is loaded using the {@link ModelLoader}. The resulting
 * {@link Model} is then processed by the configured {@link Processor} list. The processors are executed in the order in
 * which they have been added to the list.
 * The order of the processor list can be adapted by invoking the {@link #addProcessor(int, Processor)}, {@link #removeProcessor(Processor)}
 * and {@link #clearProcessors()} methods.
 * Make sure that processors that modify the model are processed before the {@link BinaryWriter} processor is invoked.
 * Changes made to the model after the {@link BinaryWriter} is invoked will not be stored.
 *
 * @author remy
 */
@Slf4j
public class Converter {

    private final ModelLoader loader = new ModelLoader();
    private final List<Processor> processors = new ArrayList<>();

    public Converter() {
        processors.add(new AnimationProcessor());
        processors.add(new GroovyProcessor());
        processors.add(new ModelLogger());
        processors.add(new BinaryWriter());
    }

    public void convert(Path file) {
        Model model = loader.load(file);

        processors.forEach(processor -> processor.process(model));
    }

    /**
     * Add a processor to the processor list.
     *
     * @param index     the index position of the processor in the list
     * @param processor the processor to add to the list
     */
    public void addProcessor(int index, Processor processor) {
        processors.add(index, processor);
    }

    /**
     * Add a processor to the back of the list.
     *
     * @param processor the processor to add
     */
    public void addProcessor(Processor processor) {
        processors.add(processor);
    }

    /**
     * Remove a processor from the list.
     *
     * @param processor the processor to remove
     */
    public void removeProcessor(Processor processor) {
        processors.remove(processor);
    }

    /**
     * Remove all processors
     */
    public void clearProcessors() {
        processors.clear();
    }

}
