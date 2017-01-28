package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pomodoro.PomodoroTimer;

public class HomeCard extends JPanel {
	
	JPanel settingsButtonPanel;
	
	private TimePad timePad;
	
	private JPanel startButtonPanel;
	private StartButton startButton;
	
	private PomodoroTimer pomodoroTimer;
	private Home home;
	
	private PomodoroCounting pomodoroCounting;
	
	public HomeCard(Home home) {
		super();
		sethome(home);
		
		setHomeCard();
		
		setSettingsButtonPanel();
		setTimePad();
		setPomodoroTimer();
		setStartButton(pomodoroTimer);
		setStartButtonPanel();
		setPomodoroCounting();
		
		addAllComponentsToHomeCard();
	}
	
	private void setHomeCard() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBackground(AppColors.HOME_BACKGROUND);
		home.getRootPane().setDefaultButton(startButton);
	}
	
	private void addAllComponentsToHomeCard() {
		add(settingsButtonPanel);
		addPad(1, 5);
		add(timePad);
		addPad(1, 200);
		add(startButtonPanel);
		addPad(1, 10);
		add(pomodoroCounting);
	}
	
	private void setSettingsButtonPanel() {
		settingsButtonPanel = new JPanel();
		settingsButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		settingsButtonPanel.setBackground(AppColors.HOME_BACKGROUND);
		
		SettingsButton settingsButton = new SettingsButton(home);
		settingsButtonPanel.add(settingsButton);
	}
	
	private void setStartButtonPanel() {
		startButtonPanel = new JPanel();
		startButtonPanel.setLayout(new BoxLayout(startButtonPanel, BoxLayout.LINE_AXIS));
		startButtonPanel.add(startButton);
		startButtonPanel.setBackground(AppColors.HOME_BACKGROUND);
		startButtonPanel.setOpaque(true);
	}
	
	public void pomodoroIsOver() {
		home.toFront();
		startButton.setStartButtonStyle();
		pomodoroCounting.update();
		JOptionPane.showMessageDialog(null, "Pomodoro is over.");
	}

	private void setPomodoroTimer() {
		pomodoroTimer = new PomodoroTimer(timePad, this);
	}
	
	
	private void setStartButton(final PomodoroTimer pomodoroTime) {
		startButton = new StartButton(pomodoroTime);
	}
	
	private void addPad(final int width, final int height) {
		add(Box.createRigidArea(new Dimension(width, height)));
	}
	
	private void setTimePad() {
		timePad = new TimePad();
	}
	
	private void sethome(final Home home) {
		this.home = home;
	}
	
	
	private void setPomodoroCounting() {
		pomodoroCounting = new PomodoroCounting();
	}
	
}