package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import Model.Model;

public class SaveState implements ActionListener {
	
	AbstractButton button;
	Model model;
	
	public SaveState(AbstractButton button, Model model) {
		this.button = button;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String file = JOptionPane.showInputDialog("Enter file name: (include extension)");
		model.save(file);
	}

}
