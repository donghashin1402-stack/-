package com.dongha.fasteat;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FastEatMod implements ModInitializer {
    public static final String MOD_ID = "fast_eat_mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("[Fast Eat Mod] 음식/포션 섭취 속도 조절 활성화");
    }
}
