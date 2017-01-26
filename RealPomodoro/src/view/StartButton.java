package view;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import pomodoro.PomodoroTimer;

public class StartButton extends JButton {
	
	PomodoroTimer pomodoroTimer;
	
	private final static String START_BUTTON_NAME = "S";
	private final static String PAUSE_BUTTON_NAME = "P";
	
	private static final long serialVersionUID = -6839276097281926270L;
	
	public StartButton(final PomodoroTimer pomodoroTimer) {
		super();
		
		initButton();
		setPomodoroTimer(pomodoroTimer);
	}
	
	private class StartButtonListener implements ActionListener {
	

		public void actionPerformed(final ActionEvent event) {
			final String currentStatusText = getStatusText();
			boolean startStatus = currentStatusText.equals(START_BUTTON_NAME);
			
			if(startStatus) {
				setPauseButtonStyle();
				pomodoroTimer.play();
			}
			else {
				setStartButtonStyle();
				pomodoroTimer.stop();
			}
		}
	}
	
	public void setStartButtonStyle() {
		setText(START_BUTTON_NAME);
		setBackground(AppColors.APP_GREEN);
		setForeground(AppColors.APP_GREEN);

		final String playIconName = "play.png";
		setImageIcon(playIconName);
	}
	
	private void setPauseButtonStyle() {
		setText(PAUSE_BUTTON_NAME);
		setBackground(AppColors.APP_RED);
		setForeground(AppColors.APP_RED);
		
		final String playIconName = "pause.png";
		setImageIcon(playIconName);
	}
	
	private void setPomodoroTimer(final PomodoroTimer pomodoroTime) {
		this.pomodoroTimer = pomodoroTime;
	}
	
	private String getStatusText() {
		return getText();
	}
	
	private void setImageIcon(final String fileName) {
		try {
			ImageIcon imageIcon = (new AppColors()).createIconFromResources(fileName);
			setIcon(imageIcon);
			
		} catch (Exception ex) {
		    System.out.println("Can't load icon with name: " + fileName);
		}
		
	}
	
	private void initButton() {
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(true);
		
		final int BUTTON_X_DIMENSION = (int) (Home.HOME_X_SIZE * 0.90);
		final int BUTTON_Y_DIMENSION = 40;
		final Dimension buttonDimension = new Dimension(BUTTON_X_DIMENSION, BUTTON_Y_DIMENSION);
		setMinimumSize(buttonDimension);
		setMaximumSize(buttonDimension);
		
		addActionListener(new StartButtonListener());
		setStartButtonStyle();
	}
}
