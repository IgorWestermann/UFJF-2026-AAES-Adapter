package org.example;

public class Main {
    public static void main(String[] args) {
        ArCondicionado arCondicionado = new ArCondicionado(new SensorDigital(27.5), 25);

        System.out.println("--- Sensor digital (Celsius) ---");
        System.out.println(arCondicionado.exibirStatus());

        System.out.println();
        System.out.println("--- Sensor antigo (Fahrenheit) com adaptador ---");
        arCondicionado.setSensor(new SensorFahrenheitAdapter(68));
        System.out.println(arCondicionado.exibirStatus());

        arCondicionado.setSensor(new SensorFahrenheitAdapter(86));
        System.out.println(arCondicionado.exibirStatus());
    }
}
