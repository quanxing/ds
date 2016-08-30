package ds;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class CollectioSort {
	
	static class com implements Comparator<Object>{

        @Override
        public int compare(Object o1, Object o2) {
            // TODO Auto-generated method stub
            Integer i1 = (Integer)o1;
            Integer i2 = (Integer)o2;
            return i1.compareTo(i2);
            }
        
	}
    
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(49);
        list.add(45);
        list.add(545);
		list.add(4);
		list.add(9);
		
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				// ArrayList sort by desc order
				return o2.compareTo(o1);
				// ArrayList sort by asc order
//				return o1.compareTo(o2);
			}
		});
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + "  ");
		}
		System.out.println();
		
		// or in another way
		//void java.util.Collections.sort(List<Integer> list,
		//                             Comparator<? super Integer> c)

		Collections.sort(list, new com());
		
		Iterator<Integer> itt = list.iterator();
		while(itt.hasNext()){
			System.out.print(itt.next() + "  ");
		}
		System.out.println();
		//default asc sort  12 ,14, 18 ,20 ....
		Collections.sort(list);
		Iterator<Integer> ii = list.iterator();
		while(ii.hasNext()){
			System.out.print(ii.next() + "  ");
		}
	}
	
}
