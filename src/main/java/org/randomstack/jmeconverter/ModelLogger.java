package org.randomstack.jmeconverter;

import com.jme3.material.MatParam;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import lombok.extern.slf4j.Slf4j;

/**
 * A processor implementation that logs the structure of the model to the configured logger.
 *
 * @author remy
 */
@Slf4j
public class ModelLogger implements Processor {

    @Override
    public void process(Model model) {
        logSpatial("", model.getSpatial());
    }

    private void logSpatial(String indent, Spatial spatial) {
        log.info(indent + spatial.getClass().getSimpleName() + "(" + (spatial.getName() == null ? "" : spatial.getName()) + ")");
        logAttributes(indent + "  - ", spatial);

        if (spatial instanceof Node) {
            for (Spatial child : ((Node) spatial).getChildren()) {
                logSpatial(indent + "  ", child);
            }
        } else if (spatial instanceof Geometry) {
            logMaterial(indent + "    ", ((Geometry) spatial).getMaterial());
        }
    }

    private void logMaterial(String indent, Material material) {
        log.info(indent + material);
        for (MatParam param : material.getParams()) {
            log.info(indent + "  " + param);
        }
    }

    private void logAttributes(String indent, Spatial spatial) {
        log.info(indent + "worldBounds: {}", spatial.getWorldBound());
        log.info(indent + "localTranslation: {}", spatial.getLocalTranslation());
        log.info(indent + "localRotation: {}", spatial.getLocalRotation());
        log.info(indent + "localScale: {}", spatial.getLocalScale());
        if (spatial.getNumControls() > 0) {
            log.info(indent + "controls:");
            for (int i = 0; i < spatial.getNumControls(); i++) {
                log.info(indent + "  [{}]:{}", i, spatial.getControl(i).getClass().getSimpleName());
            }
        }
    }
}
