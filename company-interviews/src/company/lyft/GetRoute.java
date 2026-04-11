package company.lyft;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GetRoute {

  public String getRoute(List<List<String>> travels) {

    Map<String, String> travelInfo = new HashMap<>();

    for (int i = 0; i < travels.size(); i++) {
      List<String> currentTravel = travels.get(i);

      String origin      = currentTravel.get(0);
      String destination = currentTravel.get(1);

      travelInfo.put(origin, destination);
    }

    String travelOrigin = null;

    for (String origin : travelInfo.keySet()) {
      if (!travelInfo.containsValue(origin)) {
        travelOrigin = origin;
        break;
      }
    }

    int routeIndex = 0;
    StringBuilder userTravel = new StringBuilder(travelOrigin);

    while (routeIndex < travels.size()) {
      String currentTravel = travelInfo.get(travelOrigin);

      userTravel.append(" -> ");
      userTravel.append(currentTravel);

      travelOrigin = currentTravel;
      routeIndex++;
    }

    return userTravel.toString();
  }

  public static void main(String[] args) {
    GetRoute getRoute = new GetRoute();

    List<List<String>> routes = List.of(
            List.of("SFO", "LA"),
            List.of("NYC", "SFO"),
            List.of("OAK", "NYC"));

    // OAK → NYC → SFO → LA

    List<List<String>> routes2 = List.of(
            List.of("A", "E"),
            List.of("M", "B"),
            List.of("C", "A"),
            List.of("B", "C"));
    // Output: M → B → C → A → E

    List<List<String>> routes3 = List.of(
            List.of("Taco Bell", "Shake Shack"),
            List.of("Starbucks", "Wingstop"),
            List.of("Wingstop", "Taco Bell"));

    // Output: Starbucks → Wingstop → Taco Bell → Shake Shack
    System.out.println(getRoute.getRoute(routes));
    System.out.println(getRoute.getRoute(routes2));
    System.out.println(getRoute.getRoute(routes3));
  }
}
