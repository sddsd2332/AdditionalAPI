package com.swallows.additionalapi.mixin;

import com.swallows.additionalapi.Tags;
import com.swallows.additionalapi.config.AdditionalAPIConfig;
import net.minecraftforge.fml.common.Loader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.*;
import java.util.function.BooleanSupplier;

@SuppressWarnings({"unused", "SameParameterValue"})
public class AdditionalAPILateMixinLoader implements ILateMixinLoader {

    private static final Map<String, BooleanSupplier> MIXIN_CONFIGS = new LinkedHashMap<>();

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    static {
        addModdedMixinCFG("mixin/botania/mixins.saabotania.json", "botania", () -> AdditionalAPIConfig.ConfigBOTANIA.RuneRefunded);
        addModdedMixinCFG("mixin/tconevo/mixins.saatconevo.json", new String[]{"tconevo", "avaritia"}, () -> AdditionalAPIConfig.ConfigTCONEVO.OmnipotenceItemDrops);
    }

    @Override
    public List<String> getMixinConfigs() {
        return new ArrayList<>(MIXIN_CONFIGS.keySet());
    }

    @Override
    public boolean shouldMixinConfigQueue(final String mixinConfig) {
        BooleanSupplier supplier = MIXIN_CONFIGS.get(mixinConfig);
        if (supplier == null) {
            LOGGER.info("Mixin config {} is not found in config map! It will never be loaded.", mixinConfig);
            LOGGER.info("未找到 {} 对应的Mixin Config", mixinConfig);
            return false;
        }
        return supplier.getAsBoolean();
    }

    private static boolean modLoaded(final String modID) {
        return Loader.isModLoaded(modID);
    }

    private static void addModdedMixinCFG(final String mixinConfig, final String modID) {
        MIXIN_CONFIGS.put(mixinConfig, () -> modLoaded(modID));
    }

    private static void addModdedMixinCFG(final String mixinConfig, final String modID, final BooleanSupplier condition) {
        MIXIN_CONFIGS.put(mixinConfig, () -> modLoaded(modID) && condition.getAsBoolean());
    }

    private static void addModdedMixinCFG(final String mixinConfig, final String[] modIDs, final BooleanSupplier condition) {
        MIXIN_CONFIGS.put(mixinConfig, () -> Arrays.stream(modIDs).allMatch(Loader::isModLoaded) && condition.getAsBoolean());
    }

    private static void addModdedMixinCFG(final String mixinConfig, final String modID, final String... modIDs) {
        MIXIN_CONFIGS.put(mixinConfig, () -> modLoaded(modID) && Arrays.stream(modIDs).allMatch(Loader::isModLoaded));
    }

    private static void addMixinCFG(final String mixinConfig) {
        MIXIN_CONFIGS.put(mixinConfig, () -> true);
    }

    private static void addMixinCFG(final String mixinConfig, final BooleanSupplier conditions) {
        MIXIN_CONFIGS.put(mixinConfig, conditions);
    }
}
