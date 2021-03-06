package nuke.darkness.core;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.relauncher.*;
import nuke.darkness.client.util.*;
import nuke.darkness.common.*;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, acceptedMinecraftVersions = References.ACCEPTEDMCVERSIONS)

@Mod.EventBusSubscriber
public class Darkness {

	@Instance(References.MODID)
	public static Darkness instance;

	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(new Config());
		Config.initConfig(e.getSuggestedConfigurationFile());
		References.LOGGER.info("Config is loaded!");
		Darkness.proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		Darkness.proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		References.LOGGER.info("Darkness has loaded!");
		Darkness.proxy.postInit(e);
	}

	public static CreativeTabs darknessTab = new CreativeTabs("darkness.general") {
		@Override
		public String getTabLabel() {
			return "darkness.general";
		}

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(Content.scroll);
		}
	};

	public static String prependModID(String name) {
		return References.MODID + ":" + name;
	}

	public static String prependModIDCapacity(String name) {
		return References.MODID + ":" + name + "Capacity";
	}
}