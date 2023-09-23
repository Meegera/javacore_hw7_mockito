package ru.netology.geo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @ParameterizedTest
    @ValueSource(strings = { "172.21.32.10", "172.0.32.11"})
    void byIpRussia(String ip) {
        Location result = new GeoServiceImpl().byIp(ip);
        System.out.println(result.getCity());
        assertEquals("Moscow", result.getCity());
        if (result.getStreet() != null){
            assertEquals("Lenina", result.getStreet());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"96.44.183.149", "96.4.100.105" })
    void byIpNewYork(String ip) {
        Location result = new GeoServiceImpl().byIp(ip);
        assertEquals("New York", result.getCity());
        if (result.getStreet() != null){
            assertEquals(" 10th Avenue", result.getStreet());
        }

    }
}