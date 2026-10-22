import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.empresa.Carro;
import com.empresa.Transporte;
import com.empresa.Veiculo;

public class TestesProjeto {

    @Test
    void testarCustoDeViagem() {
        Carro carro = new Carro("132mn", 50, 50, true);

        double custo = carro.custoDeViagem(350, 15);

        assertEquals(custo, 116.67, 0.01);
    }

    @Test
    void testarVeiculoMaisEconomico() {
        Carro carro = new Carro("132mn", 50, 50, true);
        Carro outroCarro = new Carro("456abc", 50, 10, false);

        Transporte transporte = new Transporte();
        transporte.addVeiculo(carro);
        transporte.addVeiculo(outroCarro);

        Veiculo resultado = transporte.veiculoMaisEconomico(15);

        assertEquals("132mn", resultado.getPlaca());
    }

}
