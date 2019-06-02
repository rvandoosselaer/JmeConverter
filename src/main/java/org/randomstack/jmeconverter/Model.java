package org.randomstack.jmeconverter;

import com.jme3.scene.Spatial;
import lombok.*;

import java.nio.file.Path;

/**
 * Class representing the loaded model.
 *
 * @author remy
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Model {

    private Path path;
    private Spatial spatial;

}
