import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * Méthode test pour tester les méthodes non implémemté.*/
public class TestThermostat {
    @Test
    public void testExemple1() {

        ServiceThermostat mockServiceThermostat = mock(ServiceThermostat.class);
        ServiceTemperature mockServiceTemperature = mock(ServiceTemperature.class);
        ControleThermostat controleur = new ControleThermostat();

        controleur.setServiceThermostat(mockServiceThermostat);
        controleur.setserviceTemperature(mockServiceTemperature);

        when(mockServiceTemperature.getTemperature()).thenReturn(20.0);
        assertEquals("20.0 OK - Démarrer chauffage", controleur.controlageThermostat());

        when(mockServiceTemperature.getTemperature()).thenReturn(22.0);
        assertEquals("Refusé", controleur.controlageThermostat());

        when(mockServiceTemperature.getTemperature()).thenReturn(20.5);
        assertEquals("20.5 OK - Démarrer chauffage", controleur.controlageThermostat());

        when(mockServiceTemperature.getTemperature()).thenReturn(21.0);
        assertEquals("21.0 OK - Arrêter chauffage", controleur.controlageThermostat());

        when(mockServiceTemperature.getTemperature()).thenReturn(19.0);
        assertEquals("Refusé", controleur.controlageThermostat());

        when(mockServiceTemperature.getTemperature()).thenReturn(21.5);
        assertEquals("21.5 OK - Arrêter chauffage", controleur.controlageThermostat());

        verify(mockServiceThermostat, times(2)).arreterChauffage();
        verify(mockServiceThermostat, times(2)).dermarrerChauffage();
        verify(mockServiceTemperature, times(13)).getTemperature();
    }
}
