import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.biblioteca.dvd;

public class Testes {
    
    @Test
    void testarCalcularMultaDvd(){
        Dvd dvd = new Dvd("Dvd", 3, 1.20, false);

        assertEquals(dvd.calcularMulta(5), 6);
    }
}
