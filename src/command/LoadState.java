package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import Model.Model;

public class LoadState implements ActionListener {
	
	AbstractButton button;
	Model model;
	
	public LoadState(AbstractButton button, Model model) {
		this.button = button;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String file = JOptionPane.showInputDialog("Enter file name: (include extension)");
		System.out.println(file + " trying to load...");
		model.load(file);
		try {
			Thread.sleep(1000);
		} catch (Exception ex) {
			System.out.println("Errored.");
		}
	}

}
