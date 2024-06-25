import java.math.BigDecimal;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Equipe equipe = new Equipe();
        Funcionario joao = new Funcionario(
            "João",
            LocalDate.of(1990, 5, 12),
            new BigDecimal("2284.38"),
            "Operador"
        );

        equipe.addFuncionario(
            new Funcionario(
                "Maria",
                LocalDate.of(2000, 10, 18),
                new BigDecimal("2009.44"),
                "Operador"
            )
        );
        equipe.addFuncionario(joao);
        equipe.addFuncionario(
            new Funcionario(
                "Caio",
                LocalDate.of(1961, 5, 2),
                new BigDecimal("9836.14"),
                "Coordenador"
            )
        );
        equipe.addFuncionario(
            new Funcionario(
                "Miguel",
                LocalDate.of(1988, 10, 14),
                new BigDecimal("19119.88"),
                "Diretor"
            )
        );
        equipe.addFuncionario(
            new Funcionario(
                "Alice",
                LocalDate.of(1995, 1, 5),
                new BigDecimal("2234.68"),
                "Recepcionista"
            )
        );
        equipe.addFuncionario(
            new Funcionario(
                "Heitor",
                LocalDate.of(1999, 11, 19),
                new BigDecimal("1582.72"),
                "Operador"
            )
        );
        equipe.addFuncionario(
            new Funcionario(
                "Arthur",
                LocalDate.of(1993, 3, 31),
                new BigDecimal("4071.84"),
                "Contador"
            )
        );
        equipe.addFuncionario(
            new Funcionario(
                "Laura",
                LocalDate.of(1994, 7, 8),
                new BigDecimal("3017.45"),
                "Gerente"
            )
        );
        equipe.addFuncionario(
            new Funcionario(
                "Heloísa",
                LocalDate.of(2003, 5, 24),
                new BigDecimal("1606.85"),
                "Eletricista"
            )
        );
        equipe.addFuncionario(
            new Funcionario(
                "Helena",
                LocalDate.of(1996, 9, 2),
                new BigDecimal("2799.93"),
                "Gerente"
            )
        );
        equipe.removeFuncionario(joao);
        equipe.printaListaFuncionario();
        equipe.addAumento(0.1);
        equipe.agrupar();
        equipe.filtrarPorMesAniversario();
        equipe.filtrarPorMaiorIdade();
        equipe.ordenarPorNome();
        equipe.somaDosSalarios();
        equipe.salarioMinimoPorFuncionario();
    }
}