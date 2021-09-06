package dev.latvian.kubejs.bloodmagic;

import com.google.gson.JsonArray;
import dev.latvian.kubejs.item.ingredient.IngredientJS;
import dev.latvian.kubejs.util.ListJS;

/**
 * @author LatvianModder
 */
public class AlchemyTableRecipeJS extends BMRecipeJS {
	@Override
	public void create(ListJS args) {
		outputItems.add(parseResultItem(args.get(0)));
		inputItems.addAll(parseIngredientItemList(args.get(1)));

		json.addProperty("syphon", 0);
		json.addProperty("ticks", 100);
		json.addProperty("upgradeLevel", 0);
	}

	@Override
	public void deserialize() {
		outputItems.add(parseResultItem(json.get("output")));
		inputItems.addAll(parseIngredientItemList(json.get("input")));
	}

	public AlchemyTableRecipeJS syphon(int i) {
		json.addProperty("syphon", i);
		save();
		return this;
	}

	public AlchemyTableRecipeJS ticks(int i) {
		json.addProperty("ticks", i);
		save();
		return this;
	}

	public AlchemyTableRecipeJS upgradeLevel(int i) {
		json.addProperty("upgradeLevel", i);
		save();
		return this;
	}

	@Override
	public void serialize() {
		if (serializeOutputs) {
			json.add("output", outputItems.get(0).toResultJson());
		}

		if (serializeInputs) {
			JsonArray array = new JsonArray();

			for (IngredientJS in : inputItems) {
				array.add(in.toJson());
			}

			json.add("input", array);
		}
	}
}
