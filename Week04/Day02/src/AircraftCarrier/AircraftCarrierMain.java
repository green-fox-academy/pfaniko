package AircraftCarrier;

public class AircraftCarrierMain {
  public static void main(String[] args) {
    Carrier carrier = new Carrier(2300, 5000);
    Aircrafts aircraft1 = new F35();
    Aircrafts aircraft2 = new F35();
    Aircrafts aircraft3 = new F35();
    Aircrafts aircraft4 = new F16();
    Aircrafts aircraft5 = new F16();
    carrier.addAircraft(aircraft1);
    carrier.addAircraft(aircraft2);
    carrier.addAircraft(aircraft3);
    carrier.addAircraft(aircraft4);
    carrier.addAircraft(aircraft5);

    Carrier carrier2 = new Carrier(2800, 2000);
    Aircrafts aircraft6 = new F16();
    Aircrafts aircraft7 = new F35();
    Aircrafts aircraft8 = new F35();
    Aircrafts aircraft9 = new F16();
    carrier2.addAircraft(aircraft6);
    carrier2.addAircraft(aircraft7);
    carrier2.addAircraft(aircraft8);
    carrier2.addAircraft(aircraft9);

    carrier.fill();
    carrier2.fill();

    carrier.getStatus();
    carrier2.getStatus();

    carrier.fight(carrier2);

    carrier.getStatus();
    carrier2.getStatus();
  }
}