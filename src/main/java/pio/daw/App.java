package pio.daw;

import pio.daw.data.Aula;

public class App {
    public static void main(String[] args) {
        ArgParser argParser = null;
        try {
<<<<<<< HEAD
            argParser = ArgParser.fromArgs(args);
=======
            argParser = ArgParser.formArgs(args);
>>>>>>> fc97fe4c56c2148dad73627c7542d803aa3b61d8
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        Aula clase = Aula.fromFile(argParser.getPath());
        clase.printAulaStats();
        clase.printBarPlot();
    }
}
