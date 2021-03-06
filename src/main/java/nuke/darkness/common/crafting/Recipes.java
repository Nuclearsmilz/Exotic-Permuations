package nuke.darkness.common.crafting;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.registry.*;
import net.minecraftforge.oredict.*;
import nuke.darkness.common.*;

public class Recipes {

	public static void oreDict() {
		OreDictionary.registerOre("nuggetDarkRunic", Content.droplet_darkrunic);
		OreDictionary.registerOre("ingotDarkRunic", Content.ingot_darkrunic);
		OreDictionary.registerOre("woolDarkened", Content.block_darkened_wool);
	}

	public static void init() {
		oreDict();

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Content.book_binding), true, new Object[] { "Ss ", "Ss ", "Ss ", 'S', Items.STICK, 's', Items.STRING }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Content.compendium), true, new Object[] { "Bb ", "Bb ", "Bb ", 'B', Content.book_binding, 'b', Items.WRITABLE_BOOK }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Content.scroll_bag), true, new Object[] { "   ", "LSL", " L ", 'L', Items.LEATHER, 'S', Items.STRING }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Content.darkened_string, 9), new Object[] { Content.block_darkened_wool }));

		/*
		 * Material Sets
		 */
		Recipes.regMatSet("ingotDarkRunic", "nuggetDarkRunic", Content.ingot_darkrunic, Content.droplet_darkrunic, Content.pickaxe_darkrunic, Content.axe_darkrunic, Content.sword_darkrunic,
				Content.shovel_darkrunic, Content.hoe_darkrunic);
	}

	/**
	 *  If there ever are too many materials this is an easier way of creating the recipes for the whole material set
	 *  i.e. Block to ingot (and reversed), ingot to droplet (and reversed), tool set
	 * @param ingotKey ingot value
	 * @param dropletKey nugget value
	 * @param blockKey block value
	 * @param ingot the ingot it will become
	 * @param droplet the droplet it will become
	 * @param block the block it will become
	 * @param pickaxe the pickaxe it will become
	 * @param axe the axe it will become
	 * @param sword the sword it will become
	 * @param shovel the shovel it will become
	 * @param hoe the hoe it will become
	 */
	public static void regMatSet(String ingotKey, String dropletKey, String blockKey, Item ingot, Item droplet, Block block, Item pickaxe, Item axe, Item sword, Item shovel, Item hoe) {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingot), true, new Object[] { "XXX", "XXX", "XXX", 'X', droplet }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(block), true, new Object[] { "XXX", "XXX", "XXX", 'X', ingot }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(droplet, 9), new Object[] { ingot }));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ingot, 9), new Object[] { block }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(pickaxe, 1), true, new Object[] { "XXX", " S ", " S ", 'X', ingotKey, 'S', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(axe, 1), true, new Object[] { " XX", " SX", " S ", 'X', ingotKey, 'S', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(axe, 1), true, new Object[] { "XX ", "XS ", " S ", 'X', ingotKey, 'S', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(sword, 1), true, new Object[] { " X ", " X ", " S ", 'X', ingotKey, 'S', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(shovel, 1), true, new Object[] { " X ", " S ", " S ", 'X', ingotKey, 'S', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(hoe, 1), true, new Object[] { " XX", " S ", " S ", 'X', ingotKey, 'S', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(hoe, 1), true, new Object[] { "XX ", " S ", " S ", 'X', ingotKey, 'S', "stickWood" }));
	}
	
	/**
	 * Same but without block
	 * @param ingotKey ingot value
	 * @param dropletKey nugget value
	 * @param ingot the ingot it will become
	 * @param droplet the droplet it will become
	 * @param pickaxe the pickaxe it will become
	 * @param axe the axe it will become
	 * @param sword the sword it will become
	 * @param shovel the shovel it will become
	 * @param hoe the hoe it will become
	 */
	public static void regMatSet(String ingotKey, String dropletKey, Item ingot, Item droplet, Item pickaxe, Item axe, Item sword, Item shovel, Item hoe) {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingot), true, new Object[] { "XXX", "XXX", "XXX", 'X', droplet }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(droplet, 9), new Object[] { ingot }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(pickaxe, 1), true, new Object[] { "XXX", " S ", " S ", 'X', ingotKey, 'S', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(axe, 1), true, new Object[] { " XX", " SX", " S ", 'X', ingotKey, 'S', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(axe, 1), true, new Object[] { "XX ", "XS ", " S ", 'X', ingotKey, 'S', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(sword, 1), true, new Object[] { " X ", " X ", " S ", 'X', ingotKey, 'S', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(shovel, 1), true, new Object[] { " X ", " S ", " S ", 'X', ingotKey, 'S', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(hoe, 1), true, new Object[] { " XX", " S ", " S ", 'X', ingotKey, 'S', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(hoe, 1), true, new Object[] { "XX ", " S ", " S ", 'X', ingotKey, 'S', "stickWood" }));
	}
}