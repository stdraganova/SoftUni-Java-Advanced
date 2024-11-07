package JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class CitiesByContinentAndCountryWithMaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfContinents = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> continents =  new LinkedHashMap<>();

        for (int continent = 1; continent <= numberOfContinents ; continent++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continentName = input[0];
            String countryName = input[1];
            String cityName = input[2];

            continents.putIfAbsent(continentName, new LinkedHashMap<>());

            Map<String, List<String>> countries = continents.get(continentName);
            countries.putIfAbsent(countryName, new ArrayList<>());
            List<String> cities = countries.get(countryName);
            cities.add(cityName);
            countries.put(countryName, cities);

            continents.put(continentName,countries);
        }

        for (String continent : continents.keySet()){
            System.out.println(continent + ":");
            Map<String, List<String> > countries = continents.get(continent);

            for (String country : countries.keySet()){
                System.out.printf(" %s -> ",country);

                for (int city = 0; city < countries.get(country).size(); city++) {
                    if (city < countries.get(country).size() - 1){
                        System.out.print(countries.get(country).get(city) + ", ");
                    }else {
                        System.out.println(countries.get(country).get(city));
                    }
                }
            }

        }
    }
}
