package kop.ui;

import kop.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 4/20/11
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class StartGameWindow implements KopWindow {
	private JButton newGame;
	private JButton loadSave;
	private JButton options;
	private JButton quit;
	private JPanel contentPane;

	public StartGameWindow() {
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.displayFrame(new NewGameWindow());
			}
		});
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.exit();
			}
		});
	}

	@Override
	public JPanel getContentPane() {
		return contentPane;
	}

	@Override
	public String getTitle() {
		return "Welcome to KoP!";  //To change body of implemented methods use File | Settings | File Templates.
	}

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		newGame = new JButton();
		newGame.setText("New game");
		newGame.setMnemonic('N');
		newGame.setDisplayedMnemonicIndex(0);
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(20, 20, 20, 20);
		contentPane.add(newGame, gbc);
		loadSave = new JButton();
		loadSave.setText("Load saved game");
		loadSave.setMnemonic('L');
		loadSave.setDisplayedMnemonicIndex(0);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(20, 20, 20, 20);
		contentPane.add(loadSave, gbc);
		options = new JButton();
		options.setText("Options");
		options.setMnemonic('O');
		options.setDisplayedMnemonicIndex(0);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(20, 20, 20, 20);
		contentPane.add(options, gbc);
		quit = new JButton();
		quit.setText("Quit");
		quit.setMnemonic('Q');
		quit.setDisplayedMnemonicIndex(0);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(20, 20, 20, 20);
		contentPane.add(quit, gbc);
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return contentPane;
	}
}
