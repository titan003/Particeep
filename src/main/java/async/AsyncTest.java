package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
	  List<Ceo> ceo = ceos.filter(c-> c.id.equals(ceo_id));
	  if(ceo == null || ceo.isEmpty()) {
		  return CompletableFuture.completedFuture(Option.none());
	  } else {
		  return CompletableFuture.completedFuture(Option.of(ceo.get(0)));
	  }
  }

  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
	  List<Enterprise> entreprises = enterprises.filter(e-> e.ceo_id.equals(ceo_id));
	  if(entreprises == null || entreprises.isEmpty())
		  return CompletableFuture.completedFuture(Option.none());
	  else {
		  return CompletableFuture.completedFuture(Option.of(entreprises.get(0)));
	  }
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) throws InterruptedException, ExecutionException {
	  Tuple2<Option<Ceo>, Option<Enterprise>> tuples = new Tuple2<>(getCeoById(ceo_id).get(), getEnterpriseByCeoId(ceo_id).get());
	  return CompletableFuture.completedFuture(tuples);
  }

}
