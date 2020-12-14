package dev.latvian.kubejs.bloodmagic;

import dev.latvian.kubejs.util.ListJS;

/**
 * @author LatvianModder
 */
public class AltarRecipeJS extends BMRecipeJS
{
	@Override
	public void create(ListJS args)
	{
		outputItems.add(parseResultItem(args.get(0)));
		inputItems.add(parseIngredientItem(args.get(1)));

		json.addProperty("upgradeLevel", 0);
		json.addProperty("altarSyphon", 1000);
		json.addProperty("consumptionRate", 5);
		json.addProperty("drainRate", 5);
	}

	public AltarRecipeJS upgradeLevel(int i)
	{
		json.addProperty("upgradeLevel", i);
		save();
		return this;
	}

	public AltarRecipeJS altarSyphon(int i)
	{
		json.addProperty("altarSyphon", i);
		save();
		return this;
	}

	public AltarRecipeJS consumptionRate(int i)
	{
		json.addProperty("consumptionRate", i);
		save();
		return this;
	}

	public AltarRecipeJS drainRate(int i)
	{
		json.addProperty("drainRate", i);
		save();
		return this;
	}

	@Override
	public void deserialize()
	{
		outputItems.add(parseResultItem(json.get("output")));
		inputItems.add(parseIngredientItem(json.get("input")));
	}

	@Override
	public void serialize()
	{
		if (serializeOutputs)
		{
			json.add("output", outputItems.get(0).toResultJson());
		}

		if (serializeInputs)
		{
			json.add("input", inputItems.get(0).toJson());
		}
	}
}
