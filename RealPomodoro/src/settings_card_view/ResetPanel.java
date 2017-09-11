package settings_card_view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import home_view.AppColors;
import home_view.Home;
import home_view.StyledViewFactory;

public class ResetPanel extends JPanel {
	
	private final int PANEL_X_SIZE = Home.HOME_X_SIZE;
	private final int PANEL_Y_SIZE = 26	;
	
	private final Dimension PANEL_DIMENSION = new Dimension(PANEL_X_SIZE, PANEL_Y_SIZE);
	
	private JPanel verticalPanel;
	private JLabel resetLabel;
	
	private ResetTimerPanel resetTimerPanel;
	
	public ResetPanel() {
		super();
		
		setResetLabel();
		setResetPanel();
		setResetTimerPanel();
		setVerticalPanel();
	
		addAllComponents();
	}
	
	private void setResetTimerPanel() {
		resetTimerPanel = new ResetTimerPanel();
		resetTimerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
	}

	private void addAllComponents() {
		this.add(verticalPanel);
		addComponentsToVerticalPanel();
	}
	
	private void setResetPanel() {
		FlowLayout flowLayout = StyledViewFactory.createFlowLayoutWithNoGaps();
		this.setLayout(flowLayout);
		
		this.setOpaque(true);
		//this.setBackground(AppColors.HOME_BACKGROUND);
		this.setBackground(Color.RED);
	}
	
	private void setResetLabel() {
		final String RESET_PANEL_TEXT = "Reset history";
		final int fontSize = 17;
		resetLabel = StyledViewFactory.createStyledLabel(RESET_PANEL_TEXT, fontSize);
		resetLabel.setBackground(AppColors.HOME_BACKGROUND);
		resetLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
	}
	
	private void setVerticalPanel() {
		verticalPanel = new JPanel();
		verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
		verticalPanel.setBackground(AppColors.HOME_BACKGROUND);

	}
	
	private void addComponentsToVerticalPanel() {
		verticalPanel.add(resetLabel);
		verticalPanel.add(Box.createRigidArea(new Dimension(0, 7)));
		verticalPanel.add(resetTimerPanel);
	}
}
