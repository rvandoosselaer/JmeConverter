package org.randomstack.jmeconverter;

import lombok.extern.slf4j.Slf4j;

import javax.script.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A processor implementation that loads and runs groovy file against the supplied model.
 *
 * @author remy
 */
@Slf4j
public class GroovyProcessor implements Processor {

    private static final String GROOVY_EXT = ".groovy";

    private ScriptEngine engine;

    public GroovyProcessor() {
        engine = new ScriptEngineManager().getEngineByName("groovy");
    }

    @Override
    public void process(Model model) {
        Path scriptPath = getScript(model.getPath());

        if (scriptPath == null) {
            return;
        }

        log.debug("Loading {}", scriptPath);
        try {
            String script = new String(Files.readAllBytes(scriptPath));
            Bindings bindings = engine.createBindings();
            bindings.put("model", model);

            CompiledScript compiledScript = ((Compilable) engine).compile(script);

            log.info("Running script {}", scriptPath);
            compiledScript.eval(bindings);
        } catch (IOException e) {
            log.error("Error reading script: {}", e.getMessage(), e);
        } catch (ScriptException e) {
            log.error("Error compiling script: {}", e.getMessage(), e);
        }
    }

    /**
     * Returns the path to the groovy script file.
     *
     * @param modelPath the path of the model
     * @return the path to the groovy script or null when no script is found
     */
    private Path getScript(Path modelPath) {
        String fileName = modelPath.getFileName().toString();
        if (fileName.contains(".")) {
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
        }
        fileName += GROOVY_EXT;

        Path script = Paths.get(modelPath.toAbsolutePath().getParent().toString(), fileName);

        return Files.isRegularFile(script) ? script : null;
    }

}
