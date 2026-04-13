import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WorldDatabase {
    private List<Continent> continents;
    private List<Country> allCountries;
    private List<City> allCities;

    public WorldDatabase() {
        continents = new ArrayList<>();
        allCountries = new ArrayList<>();
        allCities = new ArrayList<>();
    }

    // ---- Continent CRUD ----
    public void addContinent(Continent continent) {
        continents.add(continent);
    }

    public Continent findContinent(String name) {
        for (Continent c : continents) {
            if (c.getName().equalsIgnoreCase(name)) return c;
        }
        return null;
    }

    public List<Continent> getContinents() {
        return continents;
    }

    // ---- Country CRUD ----
    public void addCountry(Country country) {
        allCountries.add(country);
    }

    public boolean updateCountry(String name, long newPop, double newGdp, double newArea) {
        Country c = searchCountryByName(name);
        if (c != null) {
            c.setPopulation(newPop);
            c.setGdp(newGdp);
            c.setArea(newArea);
            return true;
        }
        return false;
    }

    public boolean deleteCountry(String name) {
        Country c = searchCountryByName(name);
        if (c == null) return false;

        // remove from continent
        Continent cont = findContinent(c.getContinent());
        if (cont != null) cont.removeCountry(c);

        return allCountries.remove(c);
    }

    public List<Country> listCountries() {
        return new ArrayList<>(allCountries);
    }

    // ---- City CRUD ----
    public void addCity(City city) {
        allCities.add(city);
    }

    public boolean updateCity(String name, long newPop, boolean newIsCapital) {
        City city = findCityGlobal(name);
        if (city != null) {
            city.setPopulation(newPop);
            city.setCapital(newIsCapital);
            return true;
        }
        return false;
    }

    public boolean deleteCity(String name) {
        City city = findCityGlobal(name);
        if (city == null) return false;

        // remove from country
        Country parent = searchCountryByName(city.getCountry());
        if (parent != null) parent.removeCity(city);

        return allCities.remove(city);
    }

    public List<City> listCities() {
        return new ArrayList<>(allCities);
    }

    private City findCityGlobal(String name) {
        for (City c : allCities) {
            if (c.getName().equalsIgnoreCase(name)) return c;
        }
        return null;
    }

    // ---- Assignment ----
    public boolean assignCityToCountry(String cityName, String countryName) {
        City city = findCityGlobal(cityName);
        Country country = searchCountryByName(countryName);

        if (city != null && country != null) {
            country.addCity(city);
            return true;
        }
        return false;
    }

    public boolean assignCountryToContinent(String countryName, String continentName) {
        Country country = searchCountryByName(countryName);
        Continent continent = findContinent(continentName);

        if (country != null && continent != null) {
            continent.addCountry(country);
            return true;
        }
        return false;
    }

    // ---- Search ----
    public Country searchCountryByName(String name) {
        for (Country c : allCountries) {
            if (c.getName().equalsIgnoreCase(name)) return c;
        }
        return null;
    }

    // ---- Filter ----
    public List<Country> filterByContinent(String continentName) {
        List<Country> result = new ArrayList<>();
        for (Country c : allCountries) {
            if (c.getContinent().equalsIgnoreCase(continentName)) {
                result.add(c);
            }
        }
        return result;
    }

    // ---- Sorting ----
    public List<Country> sortByPopulation(boolean descending) {
        List<Country> sorted = new ArrayList<>(allCountries);
        sorted.sort(Comparator.comparingLong(Country::getPopulation));
        if (descending) Collections.reverse(sorted);
        return sorted;
    }

    public List<Country> sortByGdp(boolean descending) {
        List<Country> sorted = new ArrayList<>(allCountries);
        sorted.sort(Comparator.comparingDouble(Country::getGdp));
        if (descending) Collections.reverse(sorted);
        return sorted;
    }

    public List<Country> sortByArea(boolean descending) {
        List<Country> sorted = new ArrayList<>(allCountries);
        sorted.sort(Comparator.comparingDouble(Country::getArea));
        if (descending) Collections.reverse(sorted);
        return sorted;
    }

    // ---- Top N ----
    public List<Country> topMostPopulated(int n) {
        List<Country> sorted = sortByPopulation(true);
        return sorted.subList(0, Math.min(n, sorted.size()));
    }

    public List<Country> topRichest(int n) {
        List<Country> sorted = sortByGdp(true);
        return sorted.subList(0, Math.min(n, sorted.size()));
    }
}