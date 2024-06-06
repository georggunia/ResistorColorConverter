public class ResisorColorConverter31 {
    public static void main(String[] args) {
        if (args.length < 3 || args.length > 4) { //zu wenig/viel args
            System.out.println("Error: You need 3 or 4 Colors.");
            return;
        }

        int value = 0;
        for (int i = 0; i < args.length - 1; i++) {
            int colorValue = colorToValue(args[i].toLowerCase());
            if (colorValue == -1) { //invalid value
                System.out.println("Error: Color " + args[i] + " is invalid.");
                return;
            } else if (colorValue<0) {
                continue; //new iteration (skip the special values)
            }
            value = value * 10 + colorValue; //gets skipped by continue (for special values)
        }

        double multiplier = multiplierToValue(args[args.length - 1].toLowerCase()); //last Ring
        if (multiplier == -1.0) { //invalid value
            System.out.println("Error: Color " + args[args.length - 1] + " is invalid.");
            return;
        }
        double resisance = value * multiplier;

        System.out.println("Restistance is: " + resisance + " Ohm");
    }

    private static int colorToValue(String color) {
        return switch (color) {
            case "black" -> 0;
            case "brown" -> 1;
            case "red" -> 2;
            case "orange" -> 3;
            case "yellow" -> 4;
            case "green" -> 5;
            case "blue" -> 6;
            case "violet" -> 7;
            case "grey" -> 8;
            case "weiß" -> 9;
            case "gold" -> -2; // special value for reckognition
            case "silver" -> -3; //
            default -> -1; // invalid Color
        };
    }

    private static double multiplierToValue(String color) {
        return switch (color) {
            case "black" -> 1;
            case "brown" -> 10;
            case "red" -> 100;
            case "orange" -> 1000;
            case "yellow" -> 10000;
            case "green" -> 100000;
            case "blue" -> 1000000;
            case "violet" -> 10000000;
            case "grey" -> 100000000;
            case "weiß" -> 1000000000;
            case "gold" -> 0.1;
            case "silver" -> 0.01;
            default -> -1.0; // invalid Color
        };


    }
}
