package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import Model.Model;

public class ResetState implements ActionListener {
	
	AbstractButton button;
	Model model;
	
	public ResetState(AbstractButton button, Model model) {
		this.button = button;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		model.reset();
	}

}
