package main.java8.ex.pgms.collectors;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsCountingEx {

  public static void main(String[] args) {
    Stream<String> s = Stream.of("Ace", "heart", "Club", "diamond");
    Map<Boolean, Long> m = s
        .collect(Collectors.partitioningBy(x -> Character.isUpperCase(x.charAt(0)), Collectors.counting()));
    System.out.println(m);
  }
}
