/*
 * GoldBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/bzym2/GoldBounce/
 */

package net.ccbluex.liquidbounce.injection.forge.mixins.gui;

import net.ccbluex.liquidbounce.utils.MaterialButtonRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraftforge.fml.client.config.GuiButtonExt;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
@Mixin(GuiButtonExt.class)
@SideOnly(Side.CLIENT)
public abstract class MixinGuiButtonExt extends GuiButton {
    public MixinGuiButtonExt(int id, int x, int y, String text) { super(id, x, y, text); }
    public MixinGuiButtonExt(int id, int x, int y, int w, int h, String text) { super(id, x, y, w, h, text); }

    /**
     * @author IDK
     * @reason fuck mixin
     */
    @Overwrite
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        MaterialButtonRenderer.draw(this, mc, mouseX, mouseY);
    }
}
