package org.randomstack.jmeconverter;

import com.jme3.asset.AssetManager;
import com.jme3.asset.DesktopAssetManager;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.scene.Spatial;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Class loading the model using JME's {@link AssetManager}.
 * The loaded {@link Spatial} is wrapped and returned in a {@link Model}
 *
 * @author remy
 */
@Slf4j
public class ModelLoader {

    private static final String DESKTOP_CFG = "/com/jme3/asset/Desktop.cfg";

    public Model load(Path modelPath) {
        // create a new AssetManager for each model we load. If not we need to keep track of all the locators we add
        AssetManager assetManager = new DesktopAssetManager(getClass().getResource(DESKTOP_CFG));

        log.info("Loading {}", modelPath);
        // validate the model path
        validatePath(modelPath);

        // add the directory to the assetManager
        String parentDir = modelPath.getParent().toAbsolutePath().toString();
        assetManager.registerLocator(parentDir, FileLocator.class);
        log.debug("Registered FileLocator[{}] to the asset manager.", parentDir);

        // load the model
        String fileName = modelPath.getFileName().toString();
        Spatial spatial = assetManager.loadModel(fileName);
        log.debug("Loaded {}", fileName);

        return new Model(modelPath, spatial);
    }

    private void validatePath(Path modelPath) {
        if (modelPath == null || !Files.isRegularFile(modelPath.toAbsolutePath())) {
            throw new IllegalArgumentException("Specified argument '" + modelPath + "' isn't a valid model file path!");
        }
    }

}
