import java.util.ArrayList;
import java.util.List;

public class Continent {
    private String name;
    private List<Country> countries;

    public Continent(String name) {
        this.name = name;
        this.countries = new ArrayList<>();
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public void removeCountry(Country country) {
        countries.remove(country);
    }

    public Country findCountry(String countryName) {
        for (Country c : countries) {
            if (c.getName().equalsIgnoreCase(countryName)) return c;
        }
        return null;
    }

    public List<Country> getCountries() {
        return countries;
    }
}