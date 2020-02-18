package com.rvandoosselaer.jmeconverter;

import com.jme3.anim.SkinningControl;
import com.jme3.anim.util.AnimMigrationUtils;
import com.jme3.scene.Spatial;
import lombok.extern.slf4j.Slf4j;

/**
 * A processor implementation that migrates the deprecated {@link com.jme3.animation.AnimControl} and {@link com.jme3.animation.SkeletonControl}
 * to the new {@link com.jme3.anim.AnimComposer} and {@link SkinningControl}.
 *
 * @author rvandoosselaer
 */
@Slf4j
public class AnimationProcessor implements Processor {

    @Override
    public void process(Model model) {
        log.debug("Running animation migration");
        AnimMigrationUtils.migrate(model.getSpatial());

        // save the initial pose
        model.getSpatial().depthFirstTraversal(AnimationProcessor::saveInitialPose);
    }

    private static void saveInitialPose(Spatial spatial) {
        SkinningControl skinningControl = spatial.getControl(SkinningControl.class);
        if (skinningControl != null) {
            skinningControl.getArmature().saveInitialPose();
        }
    }

}
