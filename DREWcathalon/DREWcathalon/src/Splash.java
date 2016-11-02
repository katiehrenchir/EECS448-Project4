import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.*;
import java.io.*;

public class Splash
{
	static private Clip clip;
	static private boolean hold = true;
	static private JFrame frame;
	public Splash()
	{
		frame = new JFrame("DREWcathalon");
		
		JButton start = new JButton("Start Game");
		JLabel title = new JLabel("DREWcathalon");
		JPanel content = new JPanel();
		
		content.add(title);
		content.add(start);

		frame.getContentPane().add(content);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1000, 750);
		frame.setVisible(true);
		
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				clip.stop();
				frame.dispose();
				frame = null;
				hold = false;
			}
		});
	}
	
	public void splashSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		
		File soundFile = new File("TEST.wav");
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
		clip = AudioSystem.getClip();
		clip.open(audioIn);

		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public boolean holdState()
	{
		return hold;
	}
}
