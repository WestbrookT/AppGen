package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.AbstractButton;

public class SaveState implements ActionListener {
	
	AbstractButton button;
	File file = new File("saved data.prop");
	JSONObject save = new JSONObject();
	
	public SaveState(AbstractButton button) {
		this.button = button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		save.setProperty(ArrayList<Creature>, creature);
		
		BufferedWriter pen;
		try {
			pen = new BufferedWriter(new FileWriter(file));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			save.store(pen, "properties of creatures");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
