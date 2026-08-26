package net.ccbluex.liquidbounce.features.module.modules.movement

import net.ccbluex.liquidbounce.event.UpdateEvent
import net.ccbluex.liquidbounce.event.handler
import net.ccbluex.liquidbounce.features.module.Category
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.utils.extensions.getDistanceToEntityBox
import net.minecraft.entity.EntityLivingBase

object Entityspeed : Module("Entityspeed", Category.MOVEMENT) {
    val distance = float("Distance", 1f, 0.5f..2.5f)
    val speedUp = boolean("SpeedUp", true)
    val speed = float("Speed", 1f, 1f..15f)
    val onUpdate = handler<UpdateEvent>  {
        for (entity in mc.theWorld!!.loadedEntityList) {
            if (entity is EntityLivingBase && entity.entityId != mc.thePlayer!!.entityId && mc.thePlayer!!.getDistanceToEntityBox(
                    entity
                ) <= distance.get() && !mc.thePlayer!!.onGround
            ) {
                if(speedUp.get()) {
                    mc.thePlayer!!.motionX *= (1 + (speed.get() * 0.01))
                    mc.thePlayer!!.motionZ *= (1 + (speed.get() * 0.01))
                }
                return@handler
            }
        }
    }
}