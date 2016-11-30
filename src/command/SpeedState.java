package command;

import Model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;

public class SpeedState implements ActionListener {
	
	AbstractButton button;
	private int speed;
	private Model model;
	
	public SpeedState(AbstractButton button, int speed, Model model) {
		this.button = button;
		this.speed = speed;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(speed != 256) {
			speed = speed * 2;
		}
		else
			speed = 1;
		button.setText("Speed: x" + speed);
		model.setSpeed(speed);
	}

}