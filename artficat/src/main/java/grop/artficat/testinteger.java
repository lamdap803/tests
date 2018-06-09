package grop.artficat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class testinteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0 ;
		a = a +2;
		System.out.println (a);
		
		System.out.println (3/6);
		
//		int[] ar = {1, 2, 3};
//		//List<Integer> list = Arrays.stream(ar).collect(Collectors.toList());
//		List<Integer> list = new ArrayList<Integer>(List.of(ar));
		
		int[] ints = {1, 2, 3, 6, 3, 3, 6};
//		List<Integer> list = new ArrayList<Integer>();
//		Collections.addAll(list, Arrays.stream(ints).boxed().toArray(Integer[]::new));
//		int max = Collections.max(list);
		
		
		List <Integer> intList = new ArrayList<Integer>();
        for (int i = 0 ; i < ints.length; i++) {
            intList.add(ints[i]);
        }
        int max = Collections.max(intList);
        System.out.println("max" + max);
		List <Integer> canadleLeft = intList.stream().filter(x -> x<max).collect(Collectors.toList());
		System.out.println(canadleLeft.size());
		
		
	}

}
