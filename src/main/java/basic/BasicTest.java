package basic;

import java.math.BigInteger;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {
	  if(Integer.valueOf(i) < 0) {
		  Option.none();
	  }
	  BigInteger val = BigInteger.valueOf(1);
	  for(int k=0;k<n;k++) {
		  if(val.longValue() > Integer.MAX_VALUE)
			  return Option.none();
		  val = val.multiply(BigInteger.valueOf(i));
	  }
	  
    return Option.of(val.intValue());
  }
}
