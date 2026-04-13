import java.util.ArrayList;
import java.util.List;

public class Country {
    private String name;
    private String capital;
    private String continent;
    private long population;
    private double gdp;
    private double area;

    private List<City> cities;

    public Country(String name, String capital, String continent,
                   long population, double gdp, double area) {
        this.name = name;
        this.capital = capital;
        this.continent = continent;
        this.population = population;
        this.gdp = gdp;
        this.area = area;
        this.cities = new ArrayList<>();
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getGdp() {
        return gdp;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPopulationDensity() {
        return population / area;
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public void removeCity(City city) {
        cities.remove(city);
    }

    public City findCity(String cityName) {
        for (City c : cities) {
            if (c.getName().equalsIgnoreCase(cityName)) return c;
        }
        return null;
    }


    public List<City> getCities() {
        return cities;
    }
}