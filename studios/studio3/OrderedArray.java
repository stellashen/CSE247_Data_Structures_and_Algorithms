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
			while(thing.compareTo(array[i])>=0 && i<size){
				i++;
			}

			if(i==size-1){
				array[size]=thing;
				size = size+1;
			}
			else{
				size = size + 1;
				//move all the elements on the right side to the next position
				for(int j = size-1; j > i;j--){
					array[j]=array[j-1];
				}

				array[i]=thing;
			}
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
			T head = array[0];
			size = 0;
			return head;
		}
		else{
			T head = array[0]; 
			for(int i=0;i<size;i++){
				array[i]=array[i+1];
			}
			size = size - 1;
			return head;
		}
	}

}
