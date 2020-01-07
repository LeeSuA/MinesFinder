package pt.technic.apps.minesfinder;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;

public class MinesFinder extends javax.swing.JFrame {

	private RecordTable recordChallenge;	
	public static RecordTable record;

	/**
	 * Creates new form MinesFinder
	 */
	public MinesFinder() {
		initComponents();		
		recordChallenge = new RecordTable();		
		readGameRecords();
		Normal.readGameRecords();
		recordChallenge.addRecordTableListener(new RecordTableListener() {
			@Override
			public void recordUpdated(RecordTable record) {
				recordChallengeUpdated(record);
			}
		});
	}

	private void recordChallengeUpdated(RecordTable record) {
		labelChallengeName.setText(record.getChName(0));
		labelChallengePoints.setText(Long.toString(record.getChScore(0)));
		saveGameRecords();
	}

	private void saveGameRecords() {
		ObjectOutputStream oos = null;
		try {
			File f = new File(System.getProperty("user.home") + File.separator + ".minesfinder.records");
			oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(recordChallenge);
			oos.close();
		} catch (IOException ex) {
			Logger.getLogger(MinesFinder.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void readGameRecords() {
		ObjectInputStream ois = null;
		File f = new File(System.getProperty("user.home") + File.separator + ".minesfinder.records");
		if (f.canRead()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(f));
				recordChallenge = (RecordTable) ois.readObject();
				ois.close();
			} catch (IOException | ClassNotFoundException ex) {
				Logger.getLogger(MinesFinder.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {
		panelTitle = new javax.swing.JLabel();
		panelRecords = new javax.swing.JPanel();
		panelNormal = new javax.swing.JPanel();
		Records = new javax.swing.JLabel();
		labelChallengeName = new javax.swing.JLabel();
		labelChallengePoints = new javax.swing.JLabel();
		panelBtns = new javax.swing.JPanel();
		btnEasy = new javax.swing.JButton();
		btnMedium = new javax.swing.JButton();
		btnHard = new javax.swing.JButton();
		btnChallenge = new javax.swing.JButton();
		btnItem = new javax.swing.JButton();
		btnRecordMenu = new javax.swing.JButton();
		// btnExit = new javax.swing.JButton();
		btnNormal = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("MinesFinder");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setPreferredSize(new java.awt.Dimension(600, 450));
		setResizable(false);

		panelTitle.setBackground(new java.awt.Color(136, 135, 217));
		panelTitle.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
		panelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		panelTitle.setText("Minesfinder");
		panelTitle.setOpaque(true);
		getContentPane().add(panelTitle, java.awt.BorderLayout.PAGE_START);

		panelNormal.setLayout(new java.awt.GridLayout(3, 0));
		panelBtns.setLayout(new java.awt.GridLayout(2, 0));

		btnNormal.setFont(new Font("Gothic", Font.BOLD, 20));
		btnNormal.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/pt/technic/apps/minesfinder/resources/easy.png"))); // NOI18N
		btnNormal.setText("Normal");

		btnNormal.setHorizontalTextPosition(JButton.CENTER);
		btnNormal.setVerticalTextPosition(JButton.CENTER);
		btnNormal.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNormalActionPerformed(evt);
			}
		});
		panelBtns.add(btnNormal);

		btnChallenge.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/pt/technic/apps/minesfinder/resources/challenge.png"))); // NOI18N 이미지 바꾸기
		btnChallenge.setText("ChallengeMode");
		btnChallenge.setFont(new Font("Gothic", Font.BOLD, 20));
		btnChallenge.setHorizontalTextPosition(JButton.CENTER);
		btnChallenge.setVerticalTextPosition(JButton.CENTER);
		btnChallenge.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChallengeActionPerformed(evt);
			}
		});
		panelBtns.add(btnChallenge);

		btnItem.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/pt/technic/apps/minesfinder/resources/item.png")));
		btnItem.setText("ItemMode");
		btnItem.setFont(new Font("Gothic", Font.BOLD, 20));
		btnItem.setHorizontalTextPosition(JButton.CENTER);
		btnItem.setVerticalTextPosition(JButton.CENTER);
		btnItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnItemActionPerformed(evt);
			}
		});
		panelBtns.add(btnItem);

		btnRecordMenu.setText("Record");
		btnRecordMenu.setFont(new Font("Gothic", Font.BOLD, 20));
		btnRecordMenu.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/pt/technic/apps/minesfinder/resources/record.png")));
		btnRecordMenu.setHorizontalTextPosition(JButton.CENTER);
		btnRecordMenu.setVerticalTextPosition(JButton.CENTER);
		btnRecordMenu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRecordMenuActionPerformed(evt);
			}
		});
		panelBtns.add(btnRecordMenu);

		getContentPane().add(panelBtns, java.awt.BorderLayout.CENTER);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public static RecordTable getRecord() {
		return record;
	}

	private void btnNormalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHardActionPerformed
		Normal normal = new Normal();
		normal.Normal();
	}// GEN-LAST:event_btnHardActionPerformed

	private void btnChallengeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHardActionPerformed
		GameWindowCh gameWindow = new GameWindowCh(new Minefield(4, 4, 3), recordChallenge);
		record = recordChallenge;
		gameWindow.setVisible(true);
	}// GEN-LAST:event_btnHardActionPerformed

	private void btnItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHardActionPerformed
		GameWindowItem gameWindow = new GameWindowItem(new Minefield(9, 9, 10));		
		gameWindow.setVisible(true);
	}// GEN-LAST:event_btnHardActionPerformed

	private void btnRecordMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHardActionPerformed
		RecordMenu recordmenu = new RecordMenu(Normal.recordEasy, Normal.recordMedium, Normal.recordHard, recordChallenge);
	}
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MinesFinder.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MinesFinder.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MinesFinder.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MinesFinder.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MinesFinder().setVisible(true);
			}
		});

		Sound mainmusic = new Sound();
		while (true) {
			try {
				mainmusic.mainmusicPlay();
				Thread.sleep(68000); // 68초에 한번씩 재생하도록 설정
			} catch (Exception e) {

			}
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel Records;
	public static javax.swing.JButton btnEasy;
	// public javax.swing.JButton btnExit;
	public static javax.swing.JButton btnHard;
	public static javax.swing.JButton btnMedium;
	public javax.swing.JButton btnChallenge;
	public javax.swing.JButton btnItem;
	public javax.swing.JButton btnRecordMenu;
	public javax.swing.JButton btnNormal;
	private javax.swing.JLabel labelChallengeName;
	private javax.swing.JLabel labelChallengePoints;
	private javax.swing.JPanel panelBtns;
	private javax.swing.JPanel panelRecords;
	public static javax.swing.JPanel panelNormal;
	private javax.swing.JLabel panelTitle;
	// End of variables declaration//GEN-END:variables
}
