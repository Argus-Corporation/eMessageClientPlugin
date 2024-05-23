package net.argus.emessage.plugin.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import net.argus.emessage.client.ClientResources;
import net.argus.emessage.client.gui.GUIClient;
import net.argus.gui.CList;
import net.argus.gui.Panel;
import net.argus.gui.TextArea;
import net.argus.gui.component.DialogComponent;
import net.argus.plugin.PluginRegister;
import net.argus.plugin.annotation.PluginInfo;

public class PluginDialog extends DialogComponent {
	
	private Panel mainPan, centerPan;
	
	private TextArea descriptionArea;

	public PluginDialog() {
		super();
		setTitle("Plugin");
		
		setIcon(ClientResources.ICON.getImage());
		//setDialogIcon(ClientResources.ICON.getImage());
		
		setSize(530, 430);
		setLocationRelativeTo(GUIClient.FRAME);
		
		setAlwaysOnTop(true);
		setResizable(true);
		
	}

	@Override
	public Panel getComponent() {
		mainPan = new Panel();
		mainPan.setLayout(new BorderLayout());
				
		Panel westPan = new Panel();
		westPan.setLayout(new BorderLayout());
		westPan.setBorder(BorderFactory.createEmptyBorder(35, 20, 20, 20));
		
		CList<String> list = new CList<String>(getPluginName());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(getListSelectionListener());
		
		JScrollPane sp = new JScrollPane(list);
		
		sp.setPreferredSize(new Dimension(100, 50));
		
		centerPan = new Panel();
		centerPan.setLayout(new BoxLayout(centerPan, BoxLayout.Y_AXIS));
		centerPan.setBorder(BorderFactory.createEmptyBorder(35, 0, 20, 5));
		
		descriptionArea = new TextArea();
		
		descriptionArea.setEditable(false);
		descriptionArea.setLineWrap(true);
		
		JScrollPane infoSp = new JScrollPane(descriptionArea);
		infoSp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		centerPan.add(infoSp);
		
		westPan.add(BorderLayout.CENTER, sp);
		mainPan.add(BorderLayout.WEST, westPan);
		
		mainPan.add(BorderLayout.CENTER, centerPan);
		return mainPan;
	}
	
	public static String[] getPluginName() {
		List<String> names = new ArrayList<String>();
		
		for(PluginInfo inf : PluginRegister.getInfos())
			names.add(inf.name());
		
		return (String[]) names.toArray(new String[names.size()]);
	}

	private ListSelectionListener getListSelectionListener() {
		return (e) -> {
			@SuppressWarnings("unchecked")
			JList<String> list = (JList<String>) e.getSource();
			
			int index = list.getSelectedIndex();
			
			if(PluginRegister.getInfos().size() < index)
				return;
			
			PluginInfo info = PluginRegister.getInfos().get(index);

			descriptionArea.setText("Name: " + info.name());
			descriptionArea.setText(descriptionArea.getText() + "\n\nPlugin ID: " + info.pluginId());
			
			if(info.authors().length != 0)
				descriptionArea.setText(descriptionArea.getText() + "\n\nAuthors: " + info.authors()[0]);
			
			for(int i = 1; i < info.authors().length; i++)
				descriptionArea.setText(descriptionArea.getText() + ", " + info.authors()[i]);
			
			descriptionArea.setText(descriptionArea.getText() + "\n\nDescription: " + info.description());
			descriptionArea.setText(descriptionArea.getText() + "\n\nVersion: " + PluginRegister.getVersion(index));
		};
	}
}
