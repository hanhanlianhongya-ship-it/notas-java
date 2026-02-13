package pio.daw;

import java.nio.file.Path;

public class ArgParser {
    private Path csvPath;

<<<<<<< HEAD
    public static ArgParser fromArgs(String[] args) throws Exception{
=======
    public static ArgParser formArgs(String[] args) throws Exception{
>>>>>>> fc97fe4c56c2148dad73627c7542d803aa3b61d8
        if (args.length != 1){
            throw new Exception("Argumentos invalidos");
        }
        Path p = Path.of(args[0]);
        if(p.getFileName().toString().endsWith("csv") && p.toFile().exists()){
            return new ArgParser(p);
        }
        else {
            throw new Exception("El archivo no es válido");
        }
    }

    public ArgParser(Path csvPath){
        this.csvPath = csvPath;
    }

    public Path getPath(){
        return this.csvPath;
    }
    
}
