package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.AbstractButton;

import neural.Creature;

public class SaveState implements ActionListener, java.io.Serializable {
	
	AbstractButton button;
	
	public SaveState(AbstractButton button) {
		this.button = button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ArrayList<Creature> creatures = new ArrayList<Creature>();
		
		
		try {
			FileOutputStream fout = new FileOutputStream("SavedData.ser");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			
		} catch (Exception ex) {}
	}

}
