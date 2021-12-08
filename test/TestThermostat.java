import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestThermostat{
    @Test
    public void testExemple1() {

        ServiceThermostat mockServiceThermostat = mock(ServiceThermostat.class);
        ServiceTemperature mockServiceTemperature = mock(ServiceTemperature.class);
        ControleThermostat controleur =  new ControleThermostat();

        when(mockServiceTemperature.getTemperature()).thenReturn(20.0);


        controleur.setServiceThermostat(mockServiceThermostat);
        controleur.setserviceTemperature(mockServiceTemperature);

        assertEquals("20.0 OK - Démarrer chauffage",controleur.controlageThermostat());


        verify(mockServiceThermostat, times(1)).dermarrerChauffage();
        verify(mockServiceTemperature, times(1)).getTemperature();
    }

    @Test
    public void testExemple2() {

        ServiceThermostat mockServiceThermostat = mock(ServiceThermostat.class);
        ServiceTemperature mockServiceTemperature = mock(ServiceTemperature.class);
        ControleThermostat controleur =  new ControleThermostat();

        when(mockServiceTemperature.getTemperature()).thenReturn(22.0);
        controleur.setTemperature(20.0);

        controleur.setServiceThermostat(mockServiceThermostat);
        controleur.setserviceTemperature(mockServiceTemperature);

        assertEquals("Refusé", controleur.controlageThermostat());

    }
    @Test
    public void testExemple3() {

        ServiceThermostat mockServiceThermostat = mock(ServiceThermostat.class);
        ServiceTemperature mockServiceTemperature = mock(ServiceTemperature.class);
        ControleThermostat controleur =  new ControleThermostat();

        when(mockServiceTemperature.getTemperature()).thenReturn(20.5);
        controleur.setTemperature(20.0);

        controleur.setServiceThermostat(mockServiceThermostat);
        controleur.setserviceTemperature(mockServiceTemperature);

        assertEquals("20.5 OK - Démarrer chauffage", controleur.controlageThermostat());

        verify(mockServiceThermostat, times(1)).dermarrerChauffage();
        verify(mockServiceTemperature, times(3)).getTemperature();
    }
    @Test
    public void testExemple4() {

        ServiceThermostat mockServiceThermostat = mock(ServiceThermostat.class);
        ServiceTemperature mockServiceTemperature = mock(ServiceTemperature.class);
        ControleThermostat controleur =  new ControleThermostat();

        when(mockServiceTemperature.getTemperature()).thenReturn(21.0);
        controleur.setTemperature(20.5);

        controleur.setServiceThermostat(mockServiceThermostat);
        controleur.setserviceTemperature(mockServiceTemperature);

        assertEquals("21.0 OK - Arrêter chauffage", controleur.controlageThermostat());

        verify(mockServiceThermostat, times(1)).arreterChauffage();
        verify(mockServiceTemperature, times(3)).getTemperature();


    }
    @Test
    public void testExemple5() {

        ServiceThermostat mockServiceThermostat = mock(ServiceThermostat.class);
        ServiceTemperature mockServiceTemperature = mock(ServiceTemperature.class);
        ControleThermostat controleur =  new ControleThermostat();

        when(mockServiceTemperature.getTemperature()).thenReturn(19.0);
        controleur.setTemperature(21.0);

        controleur.setServiceThermostat(mockServiceThermostat);
        controleur.setserviceTemperature(mockServiceTemperature);

        assertEquals("Refusé", controleur.controlageThermostat());



    }
    @Test
    public void testExemple6() {

        ServiceThermostat mockServiceThermostat = mock(ServiceThermostat.class);
        ServiceTemperature mockServiceTemperature = mock(ServiceTemperature.class);
        ControleThermostat controleur =  new ControleThermostat();

        when(mockServiceTemperature.getTemperature()).thenReturn(21.5);
        controleur.setTemperature(21.0);

        controleur.setServiceThermostat(mockServiceThermostat);
        controleur.setserviceTemperature(mockServiceTemperature);

        assertEquals("21.5 OK - Arrêter chauffage", controleur.controlageThermostat());

        verify(mockServiceThermostat, times(1)).arreterChauffage();
        verify(mockServiceTemperature, times(3)).getTemperature();


    }
}
