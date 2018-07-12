import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;

public class BeatBox {

	JPanel mainPanel;
	ArrayList <JCheckBox> checkboxList;
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame frame;

	String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
								"High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-Mid Tom",
								"High Agogo", "Open Hi Conga"};

	int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

	public static void main(String[] args) {
		new BeatBox().buildGUI();
	}

	public void buildGUI() {
		
		frame = new JFrame("Cyber BeatBox");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		checkboxList = new ArrayList <JCheckBox> ();
		Box buttonBox = new Box(BoxLayout.Y_AXIS);

		JButton start = new JButton("Start");
		start.addActionListener(new startListener());
		buttonBox.add(start);

		JButton stop = new JButton("Stop");
		stop.addActionListener(new stopListener());
		buttonBox.add(stop);

		JButton tempoUp = new JButton("Tempo Up");
		tempoUp.addActionListener(new tempoUpListener());
		buttonBox.add(tempoUp);

		JButton tempoDown = new JButton("Tempo Down");
		tempoDown.addActionListener(new tempoDownListner());
		buttonBox.add(tempoDown);

		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for(int i = 0 ; i < instrumentNames.length ; i++) {
			nameBox.add(new Label(instrumentNames[i]));
		}

		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);

		frame.getContentPane().add(background);

		GridLayout grid = new GridLayout(16, 16);
		grid.setVgap(1);
		grid.setHgap(2);
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER, mainPanel);

		for(int i = 0 ; i < 256 ; i++) {
			JCheckBox cBox = new JCheckBox();
			cBox.setSelected(false);
			checkboxList.add(cBox);
			mainPanel.add(cBox);
		}
		setUpMidi();
		frame.setBounds(50, 50, 300, 300);
		frame.pack();
		frame.setVisible(true);
	}


	public void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(120);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void buildTrackAndStart() {
		int[] trackList = null;

		sequence.deleteTrack(track);
		track = sequence.createTrack();

		for(int i = 0 ; i < 16 ; i++) {
			trackList = new int[16];

			int key = instruments[i];

			for(int j = 0 ; j < 16 ; j++) {

				JCheckBox jc = checkboxList.get(j + (16 * i));
				if(jc.isSelected()) {
					trackList[j] = key;
				} else {
					trackList[j] = 0;
				}
			}

			makeTracks(trackList);
			track.add(makeEvent(176, 1, 127, 0, 16));
		}

		track.add(makeEvent(192, 9, 1, 0, 15));
		try {
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	class startListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			buildTrackAndStart();
		}
	}

	class stopListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			sequencer.stop();
		}
	}

	class tempoUpListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor * 1.03));
		}
	}

	class tempoDownListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor * 0.97));
		}
	}

	public MidiEvent makeEvent(int command, int channel, int note, int velocity, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(command, channel, note, velocity);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return event;
	}

	public void makeTracks(int[] list) {

		for(int i = 0 ; i < 16 ; i++) {
			int key = list[i];

			if(key != 0) {
				track.add(makeEvent(144, 9, key, 100, i));
				track.add(makeEvent(128, 9, key, 100, i+1));
			}
		}
	}
}
