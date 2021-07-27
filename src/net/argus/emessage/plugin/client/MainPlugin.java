package net.argus.emessage.plugin.client;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import net.argus.emessage.client.gui.GUIClient;
import net.argus.file.FileLang;
import net.argus.gui.MenuItem;
import net.argus.lang.Lang;
import net.argus.lang.LangType;
import net.argus.plugin.Plugin;
import net.argus.plugin.PluginEvent;
import net.argus.plugin.PluginFile;
import net.argus.plugin.annotation.PluginInfo;

@PluginInfo(pluginId = MainPlugin.PLUGIN_ID, name = MainPlugin.NAME, authors = {MainPlugin.AUTHOR}, description = MainPlugin.DESCRIPTION, version = MainPlugin.VERSION)
public class MainPlugin extends Plugin {
	
	public static final String PLUGIN_ID = "emessage-client";
	public static final String NAME = "eMessage";
	public static final String AUTHOR = "Argus";
	public static final String VERSION = "1.0";
	
	public static final String DESCRIPTION = "eMessage official client plugin.";
	
	private PluginDialog dialog;
	
	@Override
	public void preInit(PluginEvent e) {
		Lang.addLang(LangType.en_US, new FileLang("en_US", "lang"));
		Lang.addLang(LangType.fr_FR, new FileLang("fr_FR", "lang"));
		Lang.addLang(LangType.ja_JP, new FileLang("ja_JP", "lang"));
		
		dialog = new PluginDialog();
	}

	@Override
	public void init(PluginEvent e) {}

	@Override
	public void postInit(PluginEvent e) {
		MenuItem pluginMenuItem = new MenuItem("plugin");
		pluginMenuItem.addActionListener(getPluginActionListener());
		
		GUIClient.MENU_BAR.getHelp().add(pluginMenuItem);
	}
	
	@Override
	public List<PluginFile> getPluginFiles() {		
		List<PluginFile> files = new ArrayList<PluginFile>();
		files.add(PluginResources.en_US);
		files.add(PluginResources.fr_FR);
		files.add(PluginResources.ja_JP);
		return files;
	}
	
	private ActionListener getPluginActionListener() {
		return (e) -> dialog.show();
	}

}
