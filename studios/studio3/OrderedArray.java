package studio3;

public class OrderedArray<T extends Comparable<T>> implements PriorityQueue<T> {

	public T[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public OrderedArray(int maxSize) {
		array = (T[]) new Comparable[maxSize];
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		//
		// FIXME
		//
		return (size==0);
	}

	@Override
	public void insert(T thing) {
		//
		// FIXME
		//
		if(size==0){
			array[0]=thing;
			size = 1;
		}

		else{
			int i=0;
			while(thing.compareTo(array[i])>0 && i<size){
				i++;
			}

			size = size + 1;
			//move all the elements on the right side to the next position
			for(int j = size-1; j > i;j--){
				array[j]=array[j-1];
			}
			array[i]=thing;
		}
	}

	@Override
	public T extractMin() {
		//
		// FIXME
		//
		if(size==0){
			return null;
		}
		else if(size==1){
			T min = array[0];
			size = 0;
			return min;
		}
		else{
			T min = array[0]; 
			//move all elements 1 position to the left
			//the 0th element is removed during this process
			for(int i=0;i < size-1;i++){
				array[i]=array[i+1];
			}
			size = size - 1;
			return min;
		}
	}

}
