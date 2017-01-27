package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import pomodoro.PomodoroConstants;

public class TimePad extends JPanel {

	JLabel twoPoints;
	JLabel minutesLabel;
	JLabel secondsLabel;
	
	final int SECONDS_START = 2;
	final int MINUTES_START = 0;
	
	public TimePad() {
		super();
		
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		setAlignmentX(JPanel.CENTER_ALIGNMENT);
		
		setBackground(AppColors.HOME_BACKGROUND);
		setOpaque(true);
		
		setTimePadBorder();
		
		addAllDigits();
	}
	
	public void updateSeconds(final int seconds) {
		updateTextNumber(secondsLabel, seconds);
	}
	
	public void updateMinutes(final int minutes) {
		updateTextNumber(minutesLabel, minutes);
	}
	
	private void updateTextNumber(JLabel label, final Integer newText) {
		final String newTextString = String.format("%02d", newText);
		label.setText(newTextString);
	}
	
	private void initTimeDigits() {
		final String ZERO_ZERO = "00";
		minutesLabel = createDigitLabel(ZERO_ZERO);
		secondsLabel = createDigitLabel(ZERO_ZERO);
	}
	
	private JLabel createDigitLabel(final String text) {
		JLabel digitLabel = new JLabel();
		
		final Font digitFont = new Font(FontConstants.APP_FONT_NAME,
				FontConstants.APP_FONT_STYLE, FontConstants.TIMEPAD_DIGIT_SIZE);
		digitLabel.setFont(digitFont);
		digitLabel.setForeground(AppColors.TIME_PAD_DIGITS);
		digitLabel.setText(text);
		
		return digitLabel;
	}
	
	private void initDigits() {
		initTimeDigits();
		updateSeconds(PomodoroConstants.DEFAULT_SECONDS);
		updateMinutes(PomodoroConstants.DEFAULT_MINUTES);
		
		setTwoPointsLabel();
	}
	
	private void setTwoPointsLabel() {
		final String TWO_POINTS = ":";
		twoPoints = createDigitLabel(TWO_POINTS);
	}
	
	private void addAllDigits() {
		initDigits();
	
		add(minutesLabel);
		add(twoPoints);
		add(secondsLabel);
	}
	
	private void setTimePadBorder() {
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
		setBorder(border);
	}
}
