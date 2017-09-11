package pomodoro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import home_card_view.HomeCard;
import home_card_view.TimePad;
import utils.PomodoroHistoryFileUtilities;

public class PomodoroTimer extends Pomodoro
						   implements ActionListener {

	private int UPDATE_TIME = 1000; // 1000 ms = 1 s
	
	private boolean counting;
	Timer stopWatch;
	TimePad timePad;
	
	HomeCard homeCard;
	
	public PomodoroTimer(final TimePad timePad, final HomeCard homeCard) {
		super(PomodoroHistoryFileUtilities.getMinutesInLastPomodoro(),
			  PomodoroHistoryFileUtilities.getSecondsInLastPomodoro());;
		
		setCounting(false);
		setTimePad(timePad);
		setStopWatch();
		setHome(homeCard);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(counting && this.getTotalTime() > 0) {
			this.update();
			
			final int currentMinutes = this.getMinutes();
			final int currentSeconds = this.getSeconds();
			
			timePad.update(currentMinutes, currentSeconds);
			updateLastTimeFile(this.getTotalTime());
			
		}
		else if(counting && this.isOver()) {
			stop();
			resetPomodoroTimerAndPad();
			updateLastTimeFile(PomodoroConstants.TOTAL_POMODORO_TIME_IN_SECONDS);
			
			if(homeCard != null) {
				homeCard.pomodoroIsOver();
			}
		}
	}
	
	private void updateLastTimeFile(final int totalTime) {
		PomodoroHistoryFileUtilities.updateLastTimeFile(totalTime);
	}
	
	private void setStopWatch() {
		stopWatch = new Timer(UPDATE_TIME, this);
	}
	
	private void setTimePad(final TimePad timePad) {
		this.timePad = timePad;
	}
	
	public void play() {
		setCounting(true);
		stopWatch.restart();
	}
	
	public void stop() {
		stopWatch.stop();
		setCounting(false);
	}
	
	private void setCounting(final boolean counting) {
		this.counting = counting;
	}
	
	private void setHome(final HomeCard homeCard) {
		this.homeCard = homeCard;
	}
 
	public boolean getCounting() {
		return counting;
	}
	
	public void restartTimePad() {
		timePad.update(this.getInitialMinutes(), this.getInitialSeconds());
	}
	
	public void resetPomodoroTimerAndPad() {
		this.restart();
		restartTimePad();
		setCounting(false);
	}
}
