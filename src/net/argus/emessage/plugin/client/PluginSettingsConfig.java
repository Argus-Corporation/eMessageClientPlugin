package net.argus.emessage.plugin.client;

import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.BoxLayout;

import net.argus.emessage.client.ClientResources;
import net.argus.emessage.client.gui.config.ConfigManager;
import net.argus.gui.CheckBox;
import net.argus.gui.Panel;
import net.argus.util.Error;
import net.argus.util.debug.Debug;
import net.argus.util.debug.Info;

public class PluginSettingsConfig extends ConfigManager {
	
	public static final int ID = 1;
	
	private CheckBox notify = new CheckBox("notifyshow");
	
	public PluginSettingsConfig() {
		super(ID, "emessage-client");
	}

	@Override
	public Panel getConfigPanel() {
		Panel main = new Panel();
		main.setLayout(new BorderLayout());
		
		main.add(BorderLayout.CENTER, getCenterPanel());
		main.add(BorderLayout.SOUTH, getSouthPanel());
		
		return main;
	}
	
	private Panel getCenterPanel() {
		Panel center = new Panel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		
		notify.setSelected(PluginDefault.notifyAccept());
		
		notify.addItemListener(getCheckBoxChangeListener());
		
		center.add(notify);
		return center;
	}
	
	private ItemListener getCheckBoxChangeListener() {
		return (e) -> {
			apply.setEnabled(true);
		};
	}
	
	private Panel getSouthPanel() {
		Panel south = new Panel();
		
		south.add(apply);
		
		return south;
	}

	@Override
	public void setDefault() {}
	
	@Override
	public int apply() {
		try {
			ClientResources.CONFIG.setKey("notify.accept", notify.isSelected());
		}catch(IOException e) {
			Error.createErrorFileLog(e);
			Debug.log("Error on writing config file", Info.ERROR);
			return ERROR_APPLY;
		}
		
		apply.setEnabled(false);
		return VALID_APPLY;
	}

}
