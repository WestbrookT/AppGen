package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

public class PauseState implements ActionListener {

	AbstractButton button;
	private int speed;
	private double power;

	public PauseState(AbstractButton button, int speed, double power) {
		this.button = button;
		this.speed = speed;
		this.power = power;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(speed != 0) {
			speed = 0;
			button.setText("Unpause");
		}
		else {
			speed = (int) Math.pow(2, power);
			button.setText("Pause");
		}

	}

}
