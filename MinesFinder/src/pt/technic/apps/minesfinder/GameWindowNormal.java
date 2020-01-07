package pt.technic.apps.minesfinder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class GameWindowNormal extends GameWindow{
	public GameWindowNormal(Minefield minefield, RecordTable record) {
		super(minefield , record);
		super.action = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ButtonMinefield button = (ButtonMinefield) e.getSource();           
	            int x = button.getCol();
	            int y = button.getLine();
	            minefield.revealGrid(x, y);
	            if(firstThread.getState()==Thread.State.NEW)
	            firstThread.start();
	            updateButtonsStates();
	            if (minefield.isGameFinished()) {
	                if (minefield.isPlayerDefeated()) {
	                	Sound bomb = new Sound();
						try {
							bomb.bombPlay();

						} catch(Exception ex) {

						}
	                   firstThread.interrupt();
	                   secondThread.interrupt();
	                   minefield.revealMines();
	                   updateButtonsStates();
	                    int answer = JOptionPane.showConfirmDialog(null, "Oh, a mine broke. ReGame?",
	                            "Lost!", JOptionPane.YES_NO_OPTION);
	                    if(answer == JOptionPane.YES_OPTION) {
	                    	setVisible(false);
							GameWindowNormal gameWindow = new GameWindowNormal(new Minefield(Minefield.getWidth(), Minefield.getHeight(), Minefield.getNumMines()), MinesFinder.getRecord());
					        gameWindow.setVisible(true);
	                    }
	                } else {
	                   firstThread.interrupt();
	                   secondThread.interrupt();
	                   getTimeGameDuration = System.currentTimeMillis()-minefield.returnTimeGameStarted()-startTime; 
	                    JOptionPane.showMessageDialog(null, "Congratulations. You managed to discover all the mines in "
	                            + (getTimeGameDuration / 1000) + " seconds",
	                            "victory", JOptionPane.INFORMATION_MESSAGE
	                    );                                                                                      
	                        String name = JOptionPane.showInputDialog("Enter your name");
	                        if(name != "")
	                            record.setRecord(name, getTimeGameDuration);
	                }
	                setVisible(false);                     
	            }
	        }
	    }; 
		restartBtn();
		createButtons();
	}
	
}