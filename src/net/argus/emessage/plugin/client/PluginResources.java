package net.argus.emessage.plugin.client;

import java.io.File;

import net.argus.plugin.PluginFile;
import net.argus.util.ArrayManager;

public class PluginResources {
	
	public static final PluginFile en_US = getPluginFile("en_US", "lang", "lang", true,
			"menuitem.plugin.name=Plugin\n" + 
			"tree.pluginclient.name=Plugin Client\n" + 
			"tree.pluginsettings.name=Settings\n" + 
			"checkbox.notifyshow.name=Display a notification when the window is not selected \n" + 
			"");
	
	public static final PluginFile fr_FR = getPluginFile("fr_FR", "lang", "lang", true,
			"menuitem.plugin.name=Plugin\n" + 
			"tree.pluginclient.name=Plugin Client\n" + 
			"tree.pluginsettings.name=Paramètres\n" + 
			"checkbox.notifyshow.name=Afficher les notifications lorsque la fenêtre n'est pas sélectionnée\n" + 
			"");
	
	public static final PluginFile ja_JP = getPluginFile("ja_JP", "lang", "lang", true,
			"menuitem.plugin.name=プラグイン\n" + 
			"tree.pluginclient.name=プラグインクライアント\n" +
			"tree.pluginsettings.name=設定\n" +
			"checkbox.notifyshow.name=ウィンドウが選択されていないときに通知を表示する\n" +
			"");
	
	
	public static PluginFile getPluginFile(String fileName, String suff, String path, boolean overwritable, String lines) {
		return new PluginFile(fileName, suff, path, overwritable) {
			
			@Override
			public String[] getLines() {
				return ArrayManager.add(lines.split("\n"), new String[] {"\n"});
			}
		};
	}
	
	public static PluginFile getPluginFile(File file, boolean overwritable, String lines) {
		return new PluginFile(file, overwritable) {
			
			@Override
			public String[] getLines() {
				return ArrayManager.add(lines.split("\n"), new String[] {"\n"});
			}
		};
	}

}
