public class ControleThermostat {
    private double temperature;
    private ServiceTemperature serviceTemperature;
    private ServiceThermostat serviceThermostat;

    void setServiceThermostat(ServiceThermostat serviceThermostat){
        this.serviceThermostat = serviceThermostat;
    }

    void setserviceTemperature(ServiceTemperature serviceTemperature){
        this.serviceTemperature = serviceTemperature;
    }
    String controlageDITITAGAIN(){
        temperature = serviceTemperature.getTemperature();

        if(temperature == )
    }


}
