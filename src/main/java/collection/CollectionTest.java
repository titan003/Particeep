package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
	 return input.stream().map(x-> Math.pow((x*2)+3, 5)).collect(Collectors.toList());
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
    if( input.isEmpty()) {
    	return new ArrayList<>();
    } 
    if(input.size() == 1 && input.get(0).equals("")) {
    	return Arrays.asList("");
    }
    return input.stream().map(ch-> {
						    	String chaine = ch.substring(0, 1).toUpperCase() + ch.substring(1);
						    	return chaine+=chaine;
						    	}).collect(Collectors.toList());
    
  }

}
