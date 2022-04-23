package net.argus.emessage.plugin.client;

import net.argus.emessage.EMessageDefault;

public class PluginDefault {
	
	public static boolean notifyAccept() {
		return EMessageDefault.isTrue("notify.accept", "true");
	}

}
