package dev.latvian.kubejs.bloodmagic;

import dev.latvian.kubejs.util.ListJS;

/**
 * @author LatvianModder
 */
public class SoulForgeRecipeJS extends BMRecipeJS
{
	@Override
	public void create(ListJS args)
	{
		outputItems.add(parseResultItem(args.get(0)));
		inputItems.addAll(parseIngredientItemList(args.get(1)));

		json.addProperty("minimumDrain", 0D);
		json.addProperty("drain", 0D);
	}

	@Override
	public void deserialize()
	{
		outputItems.add(parseResultItem(json.get("output")));

		for (int i = 0; i < 4; i++)
		{
			inputItems.add(parseIngredientItem(json.get("input" + i)));
		}
	}

	public SoulForgeRecipeJS minimumDrain(double i)
	{
		json.addProperty("minimumDrain", i);
		save();
		return this;
	}

	public SoulForgeRecipeJS drain(double i)
	{
		json.addProperty("drain", i);
		save();
		return this;
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
			for (int i = 0; i < inputItems.size(); i++)
			{
				json.add("input" + i, inputItems.get(i).toJson());
			}
		}
	}
}
