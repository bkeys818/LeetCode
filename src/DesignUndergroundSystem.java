import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    Map<String, Integer> averages, tally;
    Map<Integer, Integer> customerTimes;
    Map<Integer, String> customerLocations;

    public UndergroundSystem() {
        averages = new HashMap<>();
        tally = new HashMap<>();
        customerTimes = new HashMap<>();
        customerLocations = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        customerLocations.put(id, stationName);
        customerTimes.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        String key = customerLocations.remove(id) + "->" + stationName;
        averages.put(
                key,
                averages.getOrDefault(key, 0) + t - customerTimes.remove(id)
        );
        tally.put(key, tally.getOrDefault(key, 0) + 1);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;
        return ((double) averages.get(key)) / tally.get(key);
    }
}
