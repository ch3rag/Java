import javax.swing.*;
import java.awt.*;
import javax.sound.midi.*;

public class MiniMusicPlayerGUI {

	static JFrame frame;
	static MyDrawPanel panel;

	public static void main(String[] args) {

		MiniMusicPlayerGUI mini = new MiniMusicPlayerGUI();
		mini.go();
	} 

	public void setupGUI() {
		frame = new JFrame();
		panel = new MyDrawPanel();
		
		//frame.getContentPane().add(panel);
		//frame.setSize(300,300);

		frame.setContentPane(panel);
		frame.setBounds(30,30,300,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void go() {

		setupGUI();

		try {

			Sequencer player = MidiSystem.getSequencer();
			player.open();

			int events[] = {127};
			player.addControllerEventListener(panel, events);

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track track = seq.createTrack();

			for(int i = 0 ; i < 60 ; i += 4) {

				track.add(makeEvent(144, 1, i, 100, i));
				track.add(makeEvent(176, 1, 127, 0, i));
				track.add(makeEvent(128, 1, i, 100, i+2));
			}

			player.setSequence(seq);
			player.setTempoInBPM(220);
			player.start();
		} catch(Exception e) {
			//
		} 
			
	}

	class MyDrawPanel extends JPanel implements ControllerEventListener {

		boolean msg = false;

		public void controlChange(ShortMessage ev) {
			msg = true;
			repaint();
		}

		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;

			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
		
			g2d.setColor(new Color(red, green, blue));

			int h = (int) ((Math.random() * 120) + 10);
			int w = (int) ((Math.random() * 120) + 10);
			
			int x = (int) ((Math.random() * 40) + 10);
			int y = (int) ((Math.random() * 40) + 10);

			g2d.fillRect(x,y, w, h);
			msg = false;

		}


	}

	static MidiEvent makeEvent(int command, int channel, int note, int velocity, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(command, channel, note, velocity);
			event = new MidiEvent(a, tick);
		} catch (Exception e) { }

		return event;
	}
}
