package dev.latvian.kubejs.bloodmagic;

import dev.latvian.kubejs.recipe.RegisterRecipeHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * @author LatvianModder
 */
@Mod(KubeJSBloodMagic.MOD_ID)
@Mod.EventBusSubscriber(modid = KubeJSBloodMagic.MOD_ID)
public class KubeJSBloodMagic
{
	public static final String MOD_ID = "kubejs_blood_magic";

	@SubscribeEvent
	public static void registerRecipeHandlers(RegisterRecipeHandlersEvent event)
	{
		event.register("bloodmagic:altar", AltarRecipeJS::new);
		event.register("bloodmagic:array", ArrayRecipeJS::new);
		event.register("bloodmagic:soulforge", SoulForgeRecipeJS::new);
		event.register("bloodmagic:arc", ArcRecipeJS::new);
		event.register("bloodmagic:alchemytable", AlchemyTableRecipeJS::new);
	}
}