import javax.sound.midi.*;

public class MiniMusicPlayer1 implements ControllerEventListener {

	public static void main(String[] args) {

		MiniMusicPlayer1 mini = new MiniMusicPlayer1();
		mini.go();
	}

	void go() {

		try {

			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			int[] events = {127};
			sequencer.addControllerEventListener(this, events);

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			for(int i = 5 ; i < 61 ; i += 4) {
				track.add(makeEvent(144, 1, i, 100, i));
				track.add(makeEvent(176, 1, 127, 0, i));
				track.add(makeEvent(128, 1, i, 100, i+2));
			}

			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();

		} catch(Exception e) {
			// DO NOTHING
		}
	}

	public void controlChange(ShortMessage event) {
		System.out.println("la");
	}

	public static MidiEvent makeEvent(int command, int channel, int note, int velocity, int tick) {

		MidiEvent event = null;

		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(command, channel, note, velocity);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {
			// DO NOTHING
		} 
		return event;

	}
}
