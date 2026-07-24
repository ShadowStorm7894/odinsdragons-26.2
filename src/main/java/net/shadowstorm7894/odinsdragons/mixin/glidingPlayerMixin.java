package net.shadowstorm7894.odinsdragons.mixin;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.shadowstorm7894.odinsdragons.item.customitems.GliderItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HumanoidModel.class)
public class glidingPlayerMixin<T extends HumanoidRenderState> {

    @Shadow public ModelPart rightArm;
    @Shadow public ModelPart leftArm;
    private final float animationSpeed = 0.1F;
    private float animationFrame;

    @Inject(method = "setupAnim*", at = @At("TAIL"))
    private void odinsdragons$applyGliderPose(T renderState, CallbackInfo ci) {
        boolean gliding = GliderItem.isGliding;
        float deg180 = (float) Math.PI;
        if (gliding) {
            this.rightArm.zRot = (deg180/2)*animationFrame;
            this.leftArm.zRot = -(deg180/2)*animationFrame;
            animationFrame += animationSpeed;
            animationFrame = animationFrame > 1 ? 1 : animationFrame;
        } else {
            animationFrame = 0F;
        }
    }
}