package com.dongha.fasteat.mixin;

import com.dongha.fasteat.FoodSpeeds;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public abstract class ConsumableMixin {

    @ModifyVariable(
            method = "eat(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Z)Lnet/minecraft/world/item/ItemStack;",
            at = @At("HEAD"),
            argsOnly = true
    )
    private ItemStack fasteat$applyCustomEatSpeed(ItemStack stack) {
        return stack;
    }
}
