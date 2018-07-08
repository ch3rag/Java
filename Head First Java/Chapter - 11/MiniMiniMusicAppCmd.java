import javax.sound.midi.*;

public class MiniMiniMusicAppCmd {

	public static void main(String[] args) {
		MiniMiniMusicAppCmd mini = new MiniMiniMusicAppCmd();
		if(args.length < 2) {
			System.out.println("Please mention instrument and note arguments before running! Example : MiniMiniMusicAppCmd 1 44");
		} else {
			int instrument = Integer.parseInt(args[0]);
			int note = Integer.parseInt(args[1]);
			mini.play(instrument, note);
		}
	}

	public void play(int instrument, int note) {

		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			// Sequence(float divisionType, int resolution)
			// PPQ : The tempo-based timing type, for which the resolution is expressed in pulses (ticks) per quarter note.

			Track track = seq.createTrack();
			
			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, instrument, 0);
			MidiEvent changeInstrument = new MidiEvent(first, 1);
			track.add(changeInstrument);

			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, note, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);

			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, note, 100);
			MidiEvent noteOff = new MidiEvent(b, 10);
			track.add(noteOff);
			player.setSequence(seq);
			player.start();

			Thread.sleep(2000);
			
			player.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}

	}
}
