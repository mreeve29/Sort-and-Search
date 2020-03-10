import java.util.ArrayList;

public class SortSearch {

	public static ArrayList<Comparable> sequentialSearch(ArrayList<Comparable> pre, Comparable item) {
		ArrayList<Comparable> arr = new ArrayList<Comparable>(pre);
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
	
	public static ArrayList<Comparable> binarySearch(ArrayList<Comparable> arr, Comparable item){
		ArrayList<Comparable> list = new ArrayList<Comparable>(arr);
		ArrayList<Comparable> results = new ArrayList<Comparable>();
		int first = 0;
		int last = list.size()-1;
		int n = list.size()/2;
		
		while(first <= last) {
			if(list.get(n).compareTo(item) < 0) {
				//right half
				first = n + 1;
			}else if (list.get(n).compareTo(item) > 0) {
				//left half
				last = n - 1;
			}else {
				//equals
				results.add(list.get(n));
				list.remove(n);
				first = 0;
				last = list.size()-1;
				n = list.size()/2;
				continue;
			}
			n = (first + last)/2;
		}
		return results;
	}
	
	
	public static ArrayList<Comparable> insertionSort(ArrayList<Comparable> arr) {
		ArrayList<Comparable> list = new ArrayList<Comparable>(arr);
		for(int i = 1; i < list.size(); i++) {
			Comparable num = list.get(i);
			int pos = i;
			
			while(pos > 0 && list.get(pos-1).compareTo(num) > 0) {
				list.set(pos, list.get(pos-1));
				pos--;
			}
			
			list.set(pos, num);	
		}
		
		return list;
	}
	
	public static ArrayList<Comparable> selectionSort(ArrayList<Comparable> arr){
		ArrayList<Comparable> list = new ArrayList<Comparable>(arr);
		for(int i = 0; i < list.size(); i++) {
            int min = i;
            for(int j = i + 1; j < list.size(); j++) {
                if(list.get(j).compareTo(list.get(min)) < 0)
                    min = j;
            }
            if(min != i) {
                Comparable a = list.get(min);
                Comparable b = list.get(i);
                list.set(min, b);
                list.set(i, a);
            }
        }
		return list;
	}
}
