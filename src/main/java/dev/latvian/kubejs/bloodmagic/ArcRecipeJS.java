package dev.latvian.kubejs.bloodmagic;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.latvian.kubejs.fluid.FluidStackJS;
import dev.latvian.kubejs.item.ItemStackJS;
import dev.latvian.kubejs.util.ListJS;

/**
 * @author LatvianModder
 */
public class ArcRecipeJS extends BMRecipeJS {
	@Override
	public void create(ListJS args) {
		outputItems.add(parseResultItem(args.get(0)));
		inputItems.add(parseIngredientItem(args.get(1)));
		inputItems.add(parseIngredientItem(args.get(2)));

		if (args.size() >= 4) {
			outputItems.addAll(parseResultItemList(args.get(3)));
		}

		json.addProperty("consumeingredient", true);
	}

	@Override
	public void deserialize() {
		outputItems.add(parseResultItem(json.get("output")));
		inputItems.add(parseIngredientItem(json.get("input")));
		inputItems.add(parseIngredientItem(json.get("tool")));

		if (json.has("addedoutput")) {
			for (JsonElement e : json.get("addedoutput").getAsJsonArray()) {
				JsonObject o = e.getAsJsonObject();
				outputItems.add(parseResultItem(o.get("type")).chance(o.get("chance").getAsDouble()));
			}
		}
	}

	public ArcRecipeJS consumeIngredient(boolean v) {
		json.addProperty("consumeingredient", v);
		save();
		return this;
	}

	public ArcRecipeJS outputFluid(Object o) {
		json.add("outputfluid", FluidStackJS.of(o).toJson());
		save();
		return this;
	}

	@Override
	public void serialize() {
		if (serializeOutputs) {
			json.add("output", outputItems.get(0).toResultJson());

			if (outputItems.size() > 1) {
				JsonArray array = new JsonArray();

				for (int i = 1; i < outputItems.size(); i++) {
					ItemStackJS is = outputItems.get(i);
					JsonObject o = new JsonObject();
					o.add("type", is.toResultJson());
					o.addProperty("chance", is.hasChance() ? is.getChance() : 1D);
					array.add(o);
				}

				json.add("addedoutput", array);
			}
		}

		if (serializeInputs) {
			json.add("input", inputItems.get(0).toJson());
			json.add("tool", inputItems.get(1).toJson());
		}
	}
}
