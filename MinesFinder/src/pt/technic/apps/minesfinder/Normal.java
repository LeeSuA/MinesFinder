package pt.technic.apps.minesfinder;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

    
  
public class Normal extends JFrame{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public long score1;
   
   public static RecordTable recordEasy;
   public static RecordTable recordMedium;
   public static RecordTable recordHard;
   
     
   public void Normal() {
	   readGameRecords();
	    recordEasy = new RecordTable();
		recordMedium = new RecordTable();
		recordHard = new RecordTable();
		readGameRecords();
		recordEasy.addRecordTableListener(new RecordTableListener() {
			@Override
			public void recordUpdated(RecordTable record) {
				recordEasyUpdated(record);
			}
		});

		recordMedium.addRecordTableListener(new RecordTableListener() {
			@Override
			public void recordUpdated(RecordTable record) {
				recordMediumUpdated(record);
			}
		});

		recordHard.addRecordTableListener(new RecordTableListener() {
			@Override
			public void recordUpdated(RecordTable record) {
				recordHardUpdated(record);
			}
		});
		
		
	   Container contentPane = this.getContentPane();
	   contentPane.setLayout(new FlowLayout());
	   JButton btnEasy = new JButton("Easy");
	   JButton btnMedium = new JButton("Medium");
	   JButton btnHard = new JButton("Hard");
	   
	   
	   btnEasy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEasyActionPerformed(evt);
			}
		});
		contentPane.add(btnEasy);
		
		btnMedium.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnMediumActionPerformed(evt);
			}
		});
		contentPane.add(btnMedium);
		
		btnHard.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHardActionPerformed(evt);
			}
		});
		
	   contentPane.add(btnEasy);
	   contentPane.add(btnMedium);
	   contentPane.add(btnHard);
	   this.setSize(500, 300);
	   this.setTitle("Select Level");
	   this.setVisible(true);         
   }
   
   private void recordEasyUpdated(RecordTable record) {
		saveGameRecords();
	}

	private void recordMediumUpdated(RecordTable record) {
		saveGameRecords();
	}

	private void recordHardUpdated(RecordTable record) {
		saveGameRecords();
	}
	
	private void saveGameRecords() {
		ObjectOutputStream oos = null;
		try {
			File f = new File(System.getProperty("user.home") + File.separator + ".minesfinder.records");
			oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(recordEasy);
			oos.writeObject(recordMedium);
			oos.writeObject(recordHard);
			oos.close();
		} catch (IOException ex) {
			Logger.getLogger(MinesFinder.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void readGameRecords() {
		ObjectInputStream ois = null;
		File f = new File(System.getProperty("user.home") + File.separator + ".minesfinder.records");
		if (f.canRead()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(f));
				recordEasy = (RecordTable) ois.readObject();
				recordMedium = (RecordTable) ois.readObject();
				recordHard = (RecordTable) ois.readObject();
				ois.close();
			} catch (IOException | ClassNotFoundException ex) {
				Logger.getLogger(MinesFinder.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
   
   private void btnEasyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEasyActionPerformed
		GameWindowNormal gameWindow = new GameWindowNormal(new Minefield(9, 9, 10), recordEasy);
		MinesFinder.record = recordEasy;
		gameWindow.setVisible(true);
	}// GEN-LAST:event_btnEasyActionPerformed

	/*
	 * private void btnExitActionPerformed(java.awt.event.ActionEvent evt)
	 * {//GEN-FIRST:event_btnExitActionPerformed System.exit(0);
	 * }//GEN-LAST:event_btnExitActionPerformed
	 */

	private void btnMediumActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMediumActionPerformed
		GameWindowNormal gameWindow = new GameWindowNormal(new Minefield(16, 16, 40), recordMedium);		
		MinesFinder.record = recordMedium;
		gameWindow.setVisible(true);
	}// GEN-LAST:event_btnMediumActionPerformed

	private void btnHardActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHardActionPerformed
		GameWindowNormal gameWindow = new GameWindowNormal(new Minefield(16, 30, 90), recordHard);	
		MinesFinder.record = recordHard;
		gameWindow.setVisible(true);
	}// GEN-LAST:event_btnHardActionPerformed
   
 
    public static void main(String[] args) {
       new Normal();
    }
 
}
