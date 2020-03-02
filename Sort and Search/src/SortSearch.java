import java.util.ArrayList;

public class SortSearch {

	public static ArrayList<Comparable> sequentialSearch(ArrayList<Comparable> arr, Comparable item) {
		ArrayList<Comparable> list = new ArrayList<Comparable>();
		
		for(int i = arr.size()-1; i >= 0; i--) {
			Comparable c = arr.get(i);
			if(c.compareTo(item) == 0){
				//remove and add
				list.add(c);
				arr.remove(c);
			}
		}
		return list;
	}
}
