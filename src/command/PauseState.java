package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;

import Model.Model;

public class PauseState implements ActionListener {

	AbstractButton button;
	private int speed;
	private boolean paused;
	private Model model;

	public PauseState(AbstractButton button, int speed, Model model) {
		this.button = button;
		this.speed = speed;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (model.pause()) {
			button.setText("Unpause");
		}
		else button.setText("Pause");

	}

}
