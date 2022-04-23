package net.argus.emessage.plugin.client;

import net.argus.emessage.client.ClientResources;
import net.argus.emessage.client.event.ChatEvent;
import net.argus.emessage.client.event.ChatListener;
import net.argus.emessage.client.gui.GUIClient;
import net.argus.emessage.pack.EMessagePackageType;
import net.argus.net.pack.Package;
import net.argus.util.notify.DefaultNotify;
import net.argus.util.notify.Notify;

public class PluginClientListener implements ChatListener {
	
	private Notify notify = new DefaultNotify(ClientResources.ICON_PATH);


	@Override
	public void addMessage(ChatEvent e) {}

	@Override
	public void connect(ChatEvent e) {}

	@Override
	public void disconnect(ChatEvent e) {}

	@Override
	public void receiveMessage(ChatEvent e) {
		if(GUIClient.FRAME.isActive() || !PluginDefault.notifyAccept())
			return;
		
		Package pack = e.getPackage();
		
		if(pack.getType().equals(EMessagePackageType.MESSAGE))
			notify.show("New message", pack.getValue("Pseudo") + ": " +  pack.getValue("Message"));
	}

	@Override
	public void sendMessage(ChatEvent e) {}

}
