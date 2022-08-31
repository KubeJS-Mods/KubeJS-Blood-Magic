package dev.latvian.kubejs.bloodmagic;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.RegisterRecipeHandlersEvent;

/**
 * @author LatvianModder
 */
public class KubeJSBloodMagicPlugin extends KubeJSPlugin {
	@Override
	public void addRecipes(RegisterRecipeHandlersEvent event) {
		event.register("bloodmagic:altar", AltarRecipeJS::new);
		event.register("bloodmagic:array", ArrayRecipeJS::new);
		event.register("bloodmagic:soulforge", SoulForgeRecipeJS::new);
		event.register("bloodmagic:arc", ArcRecipeJS::new);
		event.register("bloodmagic:alchemytable", AlchemyTableRecipeJS::new);
	}
}
