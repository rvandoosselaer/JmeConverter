package com.rvandoosselaer.jmeconverter;

import com.jme3.scene.Spatial;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.nio.file.Path;

/**
 * Class representing the loaded model.
 *
 * @author rvandoosselaer
 */
@Getter
@ToString
@RequiredArgsConstructor
public class Model {

    @NonNull
    private final Path path;
    @NonNull
    private final Spatial spatial;

}
