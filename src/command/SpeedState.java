package command;

import Model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

public class SpeedState implements ActionListener {
	
	AbstractButton button;
	private int speed;
	private double power;
	private Model model;
	
	public SpeedState(AbstractButton button, int speed, double power, Model model) {
		this.button = button;
		this.speed = speed;
		this.power = power;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(speed != 256) {
			speed = speed * 2;
			if(speed == 1)
				power = 0;
			if(speed == 2)
				power = 1;
			if(speed == 4)
				power = 2;
			if(speed == 8)
				power = 3;
			if(speed == 16)
				power = 4;
			if(speed == 32)
				power = 5;
		}
		else
			speed = 1;
			power = 0;
		button.setText("Speed: x" + speed);
		model.setSpeed(speed);
	}

}
