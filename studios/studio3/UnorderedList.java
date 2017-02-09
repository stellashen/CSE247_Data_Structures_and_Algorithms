package studio3;

import java.util.LinkedList;
import java.util.List;

public class UnorderedList<T extends Comparable<T>> implements PriorityQueue<T> {

	public List<T> list;
	
	public UnorderedList() {
		list = new LinkedList<T>();
	}
	
	@Override
	public boolean isEmpty() {
		//
		// FIXME
		//
		return list.isEmpty();
	}

	@Override
	public void insert(T thing) {
		//
		// FIXME
		//
		list.add(thing);
	}

	@Override
	public T extractMin() {
		//
		// FIXME
		//
		if(list.size()==0){
			return null;
		}
		else if(list.size()==1){
//			T firstElement = list.get(0);
//			list.remove(0);
//			return firstElement;
			return list.remove(0);
		}
		else{
			int minPos = 0;
			for (int i=0; i < list.size(); i++){
				if (list.get(i).compareTo(list.get(minPos)) < 0){
					minPos = i;
				}
			}
			return list.remove(minPos);
		}
	}

}
