import dao.ServidorH2;
import model.Medicamento;

public class Main {
    public static void main(String[] args) {

        Medicamento med1 = new Medicamento(1, "58495948", "Dorflex", "NeoQuimica", 15, 8.50);
        Medicamento med2 = new Medicamento(2, "58495948", "Dorflex", "NeoQuimica", 15, 8.50);
        ServidorH2 servidor = new ServidorH2();

        servidor.insert(med1);
        servidor.insert(med2);
        servidor.selectByCodigoNumerico(58495948);
        //servidor.select(med1.getId());
        //servidor.selectAll();
        servidor.delete(med1.getId());
        servidor.delete(med2.getId());

    }
}
