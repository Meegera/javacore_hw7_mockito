package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void locale() {
        Country country = Country.RUSSIA;
        String result = "Добро пожаловать";

        String localizationServiceResult = new LocalizationServiceImpl().locale(country);

        assertEquals(result, localizationServiceResult);

        Set<Country> countries = Set.of(Country.BRAZIL, Country.GERMANY, Country.USA);
        Set<String> results = countries.stream()
                .map(x -> new LocalizationServiceImpl().locale(x))
                .collect(Collectors.toSet());

        assertEquals(Set.of("Welcome"), results);
    }

}