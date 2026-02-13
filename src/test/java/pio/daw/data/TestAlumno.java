package pio.daw.data;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import pio.daw.stats.EstadisticaTest;

public class TestAlumno {



    @Test
    public void testFromLine(){
        String line = "Pepe,3.5,4, 5.6";
        Alumno a = Alumno.fromLine(line);
        assertTrue(a.getNombre().equals("Pepe"));
        Double[] expected = {3.5, 4.0, 5.6};
        for(int i = 0; i < expected.length ; i++){
            System.out.printf("%f == %f\n", expected[i], a.getNotas().get(i));
            assertTrue(EstadisticaTest.checkDouble(a.getNotas().get(i), expected[i] , 0.000000001));
        }
    }
    
}
