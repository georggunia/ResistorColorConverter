public class ResistorColorConverter31 {
    public static void main(String[] args) {
        if (args.length < 3 || args.length > 4) { //zu wenig/viel args
            System.out.println("Fehler: Es müssen drei oder vier Farben angegeben werden.");
            return;
        }

        int value = 0;
        for (int i = 0; i < args.length - 1; i++) {
            int colorValue = colorToValue(args[i].toLowerCase());
            if (colorValue == -1) { //ungültiger wert
                System.out.println("Fehler: Farbe " + args[i] + " ist ungültig.");
                return;
            } else if (colorValue<0) {
                continue; //neue iteration (überspringen der spezialwerte
            }
            value = value * 10 + colorValue; //wird durch continue übersprungen
        }

        double multiplier = multiplierToValue(args[args.length - 1].toLowerCase()); //letzter Ring
        if (multiplier == -1.0) { //ungültiger wert
            System.out.println("Fehler: Farbe " + args[args.length - 1] + " ist ungültig.");
            return;
        }
        double resistance = value * multiplier;

        System.out.println("Der Widerstand hat den Wert: " + resistance + " Ohm");
    }

    private static int colorToValue(String color) {
        return switch (color) {
            case "schwarz" -> 0;
            case "braun" -> 1;
            case "rot" -> 2;
            case "orange" -> 3;
            case "gelb" -> 4;
            case "gruen" -> 5;
            case "blau" -> 6;
            case "violet" -> 7;
            case "grau" -> 8;
            case "weiß" -> 9;
            case "gold" -> -2; // spezieller wert zur erkennung
            case "silber" -> -3; //
            default -> -1; // ungültige Farbe
        };
    }

    private static double multiplierToValue(String color) {
        return switch (color) {
            case "schwarz" -> 1;
            case "braun" -> 10;
            case "rot" -> 100;
            case "orange" -> 1000;
            case "gelb" -> 10000;
            case "gruen" -> 100000;
            case "blau" -> 1000000;
            case "violet" -> 10000000;
            case "grau" -> 100000000;
            case "weiß" -> 1000000000;
            case "gold" -> 0.1;
            case "silber" -> 0.01;
            default -> -1.0; // ungültige Farbe
        };


    }
}
