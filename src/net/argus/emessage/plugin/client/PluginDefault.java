package net.argus.emessage.plugin.client;

import net.argus.emessage.ChatDefault;

public class PluginDefault {
	
	public static boolean notifyAccept() {
		return ChatDefault.isTrue("notify.accept", "true");
	}

}
