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

    private final AssetManager assetManager;

    public ModelLoader() {
        this.assetManager = new DesktopAssetManager(getClass().getResource(DESKTOP_CFG));
    }

    public Model load(Path modelPath) {
        log.info("Loading {}", modelPath);
        // validate the model path
        validatePath(modelPath);

        // add the directory to the assetManager
        String parentDir = modelPath.toAbsolutePath().getParent().toString();
        assetManager.registerLocator(parentDir, FileLocator.class);
        log.debug("Registered FileLocator[{}] to the asset manager.", parentDir);

        // load the model
        String fileName = modelPath.getFileName().toString();
        Spatial spatial = assetManager.loadModel(fileName);
        log.debug("Loaded {}", fileName);

        // after the model is loaded we unregister the FileLocator
        assetManager.unregisterLocator(parentDir, FileLocator.class);
        log.debug("Unregistered FileLocator[{}] from the asset manager.", parentDir);

        return new Model(modelPath.toAbsolutePath(), spatial);
    }

    private void validatePath(Path modelPath) {
        if (modelPath == null || !Files.isRegularFile(modelPath.toAbsolutePath())) {
            throw new IllegalArgumentException("Specified argument '" + modelPath + "' isn't a valid model file path!");
        }
    }

}
