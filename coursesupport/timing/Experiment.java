package timing;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import timing.results.LeastChooser;
import timing.results.Output;

public class Experiment implements Runnable {
	
	final private GensRepeatRunnable grr;
	final private Iterable<Integer> sizes;
	private Iterable<Duration> times;
	private Iterable<Long> ticks;
	private boolean ran;
	private int count;
	private int repeats;


	/**
	 * Run an experiment on a number of input sizes.
	 * The constructor sets up the experiment but you must call
	 * run() to run the experiment.
	 * @param grr generates the RepeatRunnable for each input size
	 * @param sizes the input sizes for the experiment
	 * @param repeats the number of times to repeat each run on each size
	 */
	public Experiment(GensRepeatRunnable grr, Iterable<Integer> sizes, int repeats) {
		this.grr     = grr;
		this.sizes   = sizes;
		this.ran     = false;
		this.repeats = repeats;
		this.count = 0;
	}
	
	public Iterable<SizeAndTiming> getSizeAndTiming() {
		Iterator<Duration> iter = getTimes().iterator();
		LinkedList<SizeAndTiming> result = new LinkedList<SizeAndTiming>();
		for (int size : getSizes()) {
			result.add(new SizeAndTiming(size, iter.next()));
		}
		return result;
	}
	
	public Iterable<SizeAndLong> getSizeAndTicks() {
		Iterator<Long> iter = getTicks().iterator();
		LinkedList<SizeAndLong> result = new LinkedList<SizeAndLong>();
		for (int size : getSizes()) {
			result.add(new SizeAndTicks(size, iter.next()));
		}
		return result;
	}
	
	public Iterable<Integer> getSizes() {
		return this.sizes;
	}
	
	public Iterable<Duration> getTimes() {
		return this.times;
	}
	
	public Iterable<Long> getTicks() {
		return this.ticks;
	}
	
	/**
	 * Actually do the experiment
	 */
	public void run() {
		if (ran) {
			throw new Error("Already ran");
		}
		ran = true;
		List<Duration> times = new LinkedList<Duration>();
		List<Long> ticks     = new LinkedList<Long>();
		for (int size : sizes) {
			//System.out.println("Experiment size " + size);
			RepeatRunnable rr = grr.gen(size);
			TimeAndTicks tt = TimedRunnable.getResultsFor(rr, repeats, new LeastChooser<Duration>(), new LeastChooser<Long>());
			Duration time = tt.time;
			times.add(time);
			ticks.add(tt.ticks);
			++count;
		}
		this.times = times;
		this.ticks = ticks;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public static void runExperiment(String name, GensRepeatRunnable grr, Iterable<Integer> sizes, int repeats) {
		Experiment e = new Experiment(grr, sizes, repeats);
		e.run();
		Output.writeSizeTiming("outputs/"+name+ "ticks.csv", name, e.getSizeAndTicks());
	}

}
