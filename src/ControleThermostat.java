/**
 * Classe pour le controle du thermostat.
 *
 * @author Yoan Gauthier
 * @author Hakim-Anis Hamani*/
public class ControleThermostat {

    /** Temperature actuelle.*/
    private Double temperature;

    /** Service pour l'obtention de la température.*/
    private ServiceTemperature serviceTemperature;

    /** Service pour la modification de l'état du thermostat.*/
    private ServiceThermostat serviceThermostat;

    /** Permet l'obtention du servicepour la modification de l'état du thermostat.
     *
     * @param serviceThermostat utlisé pour le thermostat */
    void setServiceThermostat(ServiceThermostat serviceThermostat) {
        this.serviceThermostat = serviceThermostat;
    }

    /** Permet l'obtention du service de tempértature.
     *
     * @param serviceTemperature utlisé pour l'obtention de la température */
    void setserviceTemperature(ServiceTemperature serviceTemperature) {
        this.serviceTemperature = serviceTemperature;
    }

    /** Permet de définir la température actuelle.
     *
     * @param temperature actuelle */
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    /** Méthode permettant le changement d'état du thermostat par rapport à la température actuelle et
     * la nouvelle températyre enregistré.
     *
     * @return Message du thermostat*/
    String controlageThermostat() {

        if (temperature == null) {
            temperature = serviceTemperature.getTemperature();
            if (temperature < 21.0) {
                serviceThermostat.dermarrerChauffage();
                return temperature + " OK - Démarrer chauffage";
            } else {
                serviceThermostat.arreterChauffage();
                return temperature + " OK - Arrêter chauffage";
            }
        }
        if (temperature - serviceTemperature.getTemperature() <= 0.5 &&
                temperature - serviceTemperature.getTemperature() >= -0.5) {
            temperature = serviceTemperature.getTemperature();
            if (temperature < 21.0) {
                serviceThermostat.dermarrerChauffage();
                return temperature + " OK - Démarrer chauffage";
            } else {
                serviceThermostat.arreterChauffage();
                return temperature + " OK - Arrêter chauffage";
            }
        } else {
            return "Refusé";
        }
    }

}


