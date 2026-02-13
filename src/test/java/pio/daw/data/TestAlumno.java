package pio.daw.data;

import static org.junit.jupiter.api.Assertions.assertTrue;
<<<<<<< HEAD
=======

>>>>>>> fc97fe4c56c2148dad73627c7542d803aa3b61d8
import org.junit.jupiter.api.Test;

import pio.daw.stats.EstadisticaTest;

public class TestAlumno {



    @Test
    public void testFromLine(){
        String line = "Pepe,3.5,4, 5.6";
        Alumno a = Alumno.fromLine(line);
        assertTrue(a.getNombre().equals("Pepe"));
<<<<<<< HEAD
        Double[] expected = {3.5, 4.0, 5.6};
=======
        Double[] expected = {3.5, 4. , 5.6};
>>>>>>> fc97fe4c56c2148dad73627c7542d803aa3b61d8
        for(int i = 0; i < expected.length ; i++){
            System.out.printf("%f == %f\n", expected[i], a.getNotas().get(i));
            assertTrue(EstadisticaTest.checkDouble(a.getNotas().get(i), expected[i] , 0.000000001));
        }
    }
    
}
