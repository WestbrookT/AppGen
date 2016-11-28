package command;

import Model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

public class PauseState implements ActionListener {

	AbstractButton button;
	private int speed;
	private boolean paused;
	private Model model;

	public PauseState(AbstractButton button, int speed, double power, Model model) {
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
