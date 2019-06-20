package org.randomstack.jmeconverter;

import com.jme3.scene.Spatial;
import lombok.Data;
import lombok.NonNull;

import java.nio.file.Path;

/**
 * Class representing the loaded model.
 *
 * @author remy
 */
@Data
@NonNull
public class Model {

    @NonNull
    private Path path;
    @NonNull
    private Spatial spatial;

}
