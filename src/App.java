import java.util.List;

public class App {
    public static void main(String[] args) {
        WorldDatabase db = new WorldDatabase();

        System.out.println("==========================================================");
        System.out.println("       WORLD DATA EXPLORER - Full Demo");
        System.out.println("==========================================================\n");

        // ---- Step 1: Create continents ----
        printSection("1. CREATING CONTINENTS");
        Continent asia = new Continent("Asia");
        Continent europe = new Continent("Europe");
        Continent northAmerica = new Continent("North America");
        Continent africa = new Continent("Africa");
        Continent southAmerica = new Continent("South America");

        db.addContinent(asia);
        db.addContinent(europe);
        db.addContinent(northAmerica);
        db.addContinent(africa);
        db.addContinent(southAmerica);

        System.out.println("Added 5 continents: Asia, Europe, North America, Africa, South America");
        for (Continent c : db.getContinents()) {
            System.out.println("  -> " + c.getName());
        }

        // ---- Step 2: Create countries ----
        printSection("2. ADDING COUNTRIES");
        Country china = new Country("China", "Beijing", "Asia", 1425900000L, 17963.0, 9596961);
        Country india = new Country("India", "New Delhi", "Asia", 1428600000L, 3737.0, 3287263);
        Country usa = new Country("United States", "Washington D.C.", "North America", 339900000L, 27361.0, 9833520);
        Country brazil = new Country("Brazil", "Brasilia", "South America", 216400000L, 2126.0, 8515767);
        Country germany = new Country("Germany", "Berlin", "Europe", 84500000L, 4456.0, 357022);
        Country japan = new Country("Japan", "Tokyo", "Asia", 123300000L, 4231.0, 377975);
        Country uk = new Country("United Kingdom", "London", "Europe", 67700000L, 3332.0, 243610);
        Country nigeria = new Country("Nigeria", "Abuja", "Africa", 223800000L, 477.0, 923768);
        Country turkey = new Country("Turkey", "Ankara", "Asia", 85300000L, 1108.0, 783562);
        Country france = new Country("France", "Paris", "Europe", 68200000L, 3031.0, 643801);
        Country mexico = new Country("Mexico", "Mexico City", "North America", 128900000L, 1789.0, 1964375);
        Country egypt = new Country("Egypt", "Cairo", "Africa", 112700000L, 395.0, 1002450);

        Country[] countries = {china, india, usa, brazil, germany, japan, uk, nigeria, turkey, france, mexico, egypt};

        for (Country c : countries) {
            db.addCountry(c);
            System.out.println("  Added: " + c.getName() + " | Pop " + c.getPopulation() + " | GDP $" + c.getGdp() + "B");
        }

        // ---- Step 3: Assign countries to continents ----
        printSection("3. ASSIGNING COUNTRIES TO CONTINENTS");
        db.assignCountryToContinent("China", "Asia");
        db.assignCountryToContinent("India", "Asia");
        db.assignCountryToContinent("Japan", "Asia");
        db.assignCountryToContinent("Turkey", "Asia");
        db.assignCountryToContinent("United States", "North America");
        db.assignCountryToContinent("Mexico", "North America");
        db.assignCountryToContinent("Germany", "Europe");
        db.assignCountryToContinent("United Kingdom", "Europe");
        db.assignCountryToContinent("France", "Europe");
        db.assignCountryToContinent("Brazil", "South America");
        db.assignCountryToContinent("Nigeria", "Africa");
        db.assignCountryToContinent("Egypt", "Africa");

        for (Continent c : db.getContinents()) {
            System.out.println("  " + c.getName() + ": " + c.getCountries().size() + " countries");
        }

        // ---- Step 4: Create cities ----
        printSection("4. ADDING CITIES");
        City beijing = new City("Beijing", "China", 21500000L, true);
        City shanghai = new City("Shanghai", "China", 28500000L, false);
        City delhi = new City("New Delhi", "India", 32900000L, true);
        City mumbai = new City("Mumbai", "India", 21700000L, false);
        City nyc = new City("New York", "United States", 8300000L, false);
        City washington = new City("Washington D.C.", "United States", 700000L, true);
        City saoPaulo = new City("Sao Paulo", "Brazil", 22400000L, false);
        City brasilia = new City("Brasilia", "Brazil", 4800000L, true);
        City berlin = new City("Berlin", "Germany", 3700000L, true);
        City tokyo = new City("Tokyo", "Japan", 13900000L, true);
        City london = new City("London", "United Kingdom", 9000000L, true);
        City lagos = new City("Lagos", "Nigeria", 15900000L, false);
        City abuja = new City("Abuja", "Nigeria", 3600000L, true);
        City istanbul = new City("Istanbul", "Turkey", 15800000L, false);
        City ankara = new City("Ankara", "Turkey", 5700000L, true);
        City paris = new City("Paris", "France", 2100000L, true);
        City mexicoCity = new City("Mexico City", "Mexico", 9200000L, true);
        City cairo = new City("Cairo", "Egypt", 10100000L, true);

        City[] allCities = {
                beijing, shanghai, delhi, mumbai, nyc, washington, saoPaulo,
                brasilia, berlin, tokyo, london, lagos, abuja, istanbul,
                ankara, paris, mexicoCity, cairo
        };

        for (City c : allCities) {
            db.addCity(c);
            System.out.println("  Added: " + c.getName() + " | Pop " + c.getPopulation() +
                    (c.isCapital() ? " [Capital]" : ""));
        }

        // ---- Step 5: Assign cities to countries ----
        printSection("5. ASSIGNING CITIES TO COUNTRIES");
        db.assignCityToCountry("Beijing", "China");
        db.assignCityToCountry("Shanghai", "China");
        db.assignCityToCountry("New Delhi", "India");
        db.assignCityToCountry("Mumbai", "India");
        db.assignCityToCountry("New York", "United States");
        db.assignCityToCountry("Washington D.C.", "United States");
        db.assignCityToCountry("Sao Paulo", "Brazil");
        db.assignCityToCountry("Brasilia", "Brazil");
        db.assignCityToCountry("Berlin", "Germany");
        db.assignCityToCountry("Tokyo", "Japan");
        db.assignCityToCountry("London", "United Kingdom");
        db.assignCityToCountry("Lagos", "Nigeria");
        db.assignCityToCountry("Abuja", "Nigeria");
        db.assignCityToCountry("Istanbul", "Turkey");
        db.assignCityToCountry("Ankara", "Turkey");
        db.assignCityToCountry("Paris", "France");
        db.assignCityToCountry("Mexico City", "Mexico");
        db.assignCityToCountry("Cairo", "Egypt");

        for (Country c : db.listCountries()) {
            if (!c.getCities().isEmpty()) {
                System.out.print("  " + c.getName() + ": ");
                for (City city : c.getCities()) {
                    System.out.print(city.getName() + ", ");
                }
                System.out.println();
            }
        }

        // ---- Step 6: Update a country ----
        printSection("6. UPDATING A COUNTRY (Turkey)");
        Country foundTurkey = db.searchCountryByName("Turkey");
        if (foundTurkey != null) {
            System.out.println("  Before: " + foundTurkey.getName() + " | Pop " +
                    foundTurkey.getPopulation() + " | GDP $" + foundTurkey.getGdp());
        }

        db.updateCountry("Turkey", 86000000L, 1154.0, 783562);

        foundTurkey = db.searchCountryByName("Turkey");
        if (foundTurkey != null) {
            System.out.println("  After:  " + foundTurkey.getName() + " | Pop " +
                    foundTurkey.getPopulation() + " | GDP $" + foundTurkey.getGdp());
        }

        // ---- Step 7: Update a city ----
        printSection("7. UPDATING A CITY (Istanbul)");
        City ist = null;
        for (City c : db.listCities()) {
            if (c.getName().equalsIgnoreCase("Istanbul")) {
                ist = c;
                break;
            }
        }

        if (ist != null) {
            System.out.println("  Before: " + ist.getName() + " | Pop " + ist.getPopulation());
        }

        db.updateCity("Istanbul", 16000000L, false);

        for (City c : db.listCities()) {
            if (c.getName().equalsIgnoreCase("Istanbul")) {
                ist = c;
                break;
            }
        }

        if (ist != null) {
            System.out.println("  After:  " + ist.getName() + " | Pop " + ist.getPopulation());
        }

        // ---- Step 8: Delete a country ----
        printSection("8. DELETING A COUNTRY (Egypt)");
        System.out.println("  Countries before delete: " + db.listCountries().size());
        db.deleteCountry("Egypt");
        System.out.println("  Countries after delete:  " + db.listCountries().size());
        System.out.println("  Search Egypt: " + db.searchCountryByName("Egypt"));

        // ---- Step 9: Delete a city ----
        printSection("9. DELETING A CITY (Cairo)");
        System.out.println("  Cities before delete: " + db.listCities().size());
        db.deleteCity("Cairo");
        System.out.println("  Cities after delete:  " + db.listCities().size());

        // ---- Step 10: List all countries ----
        printSection("10. LIST ALL COUNTRIES");
        for (Country c : db.listCountries()) {
            System.out.println("  " + c.getName() + " - " + c.getCapital());
        }

        // ---- Step 11: List all cities ----
        printSection("11. LIST ALL CITIES");
        for (City c : db.listCities()) {
            System.out.println("  " + c.getName() + " - " + c.getCountry());
        }

        // ---- Step 12: Search country by name ----
        printSection("12. SEARCH COUNTRY BY NAME");
        String[] searchTerms = {"Germany", "Japan", "Atlantis"};
        for (String term : searchTerms) {
            Country found = db.searchCountryByName(term);
            if (found != null) {
                System.out.println("  Search '" + term + "': " + found.getName());
            } else {
                System.out.println("  Search '" + term + "': NOT FOUND");
            }
        }

        // ---- Step 13: Filter countries by continent ----
        printSection("13. FILTER COUNTRIES BY CONTINENT (Asia)");
        List<Country> asianCountries = db.filterByContinent("Asia");
        for (Country c : asianCountries) {
            System.out.println("  " + c.getName());
        }

        printSection("FILTER COUNTRIES BY CONTINENT (Europe)");
        List<Country> europeanCountries = db.filterByContinent("Europe");
        for (Country c : europeanCountries) {
            System.out.println("  " + c.getName());
        }

        // ---- Step 14: Sort by population ----
        printSection("14. SORT BY POPULATION (descending)");
        List<Country> byPop = db.sortByPopulation(true);
        int rank = 1;
        for (Country c : byPop) {
            System.out.println("  " + rank++ + ". " + c.getName() + " - " + c.getPopulation());
        }

        // ---- Step 15: Sort by GDP ----
        printSection("15. SORT BY GDP (descending)");
        List<Country> byGdp = db.sortByGdp(true);
        rank = 1;
        for (Country c : byGdp) {
            System.out.println("  " + rank++ + ". " + c.getName() + " - $" + c.getGdp() + "B");
        }

        // ---- Step 16: Sort by area ----
        printSection("16. SORT BY AREA (descending)");
        List<Country> byArea = db.sortByArea(true);
        rank = 1;
        for (Country c : byArea) {
            System.out.println("  " + rank++ + ". " + c.getName() + " - " + c.getArea() + " km2");
        }

        // ---- Step 17: Top 5 most populated ----
        printSection("17. TOP 5 MOST POPULATED COUNTRIES");
        List<Country> top5Pop = db.topMostPopulated(5);
        rank = 1;
        for (Country c : top5Pop) {
            System.out.println("  " + rank++ + ". " + c.getName() + " - " + c.getPopulation());
        }

        // ---- Step 18: Top 5 richest ----
        printSection("18. TOP 5 RICHEST COUNTRIES (by GDP)");
        List<Country> top5Gdp = db.topRichest(5);
        rank = 1;
        for (Country c : top5Gdp) {
            System.out.println("  " + rank++ + ". " + c.getName() + " - $" + c.getGdp() + "B");
        }

        System.out.println("\n==========================================================");
        System.out.println("       Demo complete.");
        System.out.println("==========================================================");
    }

    private static void printSection(String title) {
        System.out.println("\n----------------------------------------------------------");
        System.out.println(title);
        System.out.println("----------------------------------------------------------");
    }
}