package net.argus.emessage.plugin.client;

import java.io.File;

import net.argus.plugin.PluginFile;
import net.argus.util.ArrayManager;

public class PluginResources {
	
	public static final PluginFile en_US = getPluginFile("en_US", "lang", "lang",
			"menuitem.plugin.name=Plugin\r\n" + 
			"");
	
	public static final PluginFile fr_FR = getPluginFile("fr_FR", "lang", "lang",
			"menuitem.plugin.name=Plugin\r\n" + 
			"");
	
	public static final PluginFile ja_JP = getPluginFile("ja_JP", "lang", "lang",
			"menuitem.plugin.name=プラグイン\r\n" + 
			"");
	
	
	public static PluginFile getPluginFile(String fileName, String suff, String path, String lines) {
		return new PluginFile(fileName, suff, path) {
			
			@Override
			public String[] getLines() {
				return ArrayManager.add(lines.split("\r\n"), new String[] {"\n\r"});
			}
		};
	}
	
	public static PluginFile getPluginFile(File file, String lines) {
		return new PluginFile(file) {
			
			@Override
			public String[] getLines() {
				return ArrayManager.add(lines.split("\r\n"), new String[] {"\n\r"});
			}
		};
	}

}
