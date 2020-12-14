package dev.latvian.kubejs.bloodmagic;

import dev.latvian.kubejs.util.ListJS;

/**
 * @author LatvianModder
 */
public class ArrayRecipeJS extends BMRecipeJS
{
	@Override
	public void create(ListJS args)
	{
		outputItems.add(parseResultItem(args.get(0)));
		inputItems.add(parseIngredientItem(args.get(1)));
		inputItems.add(parseIngredientItem(args.get(2)));
	}

	@Override
	public void deserialize()
	{
		outputItems.add(parseResultItem(json.get("output")));
		inputItems.add(parseIngredientItem(json.get("baseinput")));
		inputItems.add(parseIngredientItem(json.get("addedinput")));
	}

	public ArrayRecipeJS texture(String tex)
	{
		json.addProperty("texture", tex);
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
			json.add("baseinput", inputItems.get(0).toJson());
			json.add("addedinput", inputItems.get(1).toJson());
		}
	}
}
