public class SortTimer {
	protected long comparisons;
        protected long moves;
        private long time;

        public SortTimer(){
          this.reset();
        }

	public void reset(){
		comparisons = 0;
		moves = 0;
		time = System.nanoTime();
        }
	public long getComparisons(){
		return comparisons;
	}
	public long getMoves(){
		return moves;
	}
	public long getElapsedTime(){
		return (System.nanoTime()-time)/1000;
	}

}
