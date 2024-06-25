import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Equipe {
    private final List<Funcionario> funcionarios;

    public Equipe() {
        this.funcionarios = new ArrayList<>();
    }

    public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void removeFuncionario(Funcionario funcionario) {
        this.funcionarios.remove(funcionario);
    }

    public void printaListaFuncionario() {
        System.out.println("\nFuncionários:");

        for (Funcionario funcionario : this.funcionarios) {
            LocalDate dataNascimento = funcionario.getDataNascimento();

            System.out.println("\nNome: " + funcionario.getNome());
            System.out.printf(
                "Data de nascimento: %02d/%02d/%4d\n",
                dataNascimento.getDayOfMonth(),
                dataNascimento.getMonthValue(),
                dataNascimento.getYear()
            );
            System.out.printf("Salário: R$ %,.2f\n", funcionario.getSalario());
            System.out.println("Função: " + funcionario.getFuncao());
        }
        System.out.println("\n");
    }

    public void addAumento(double aumento) {
        System.out.println("Aumento de salário:");
        for (Funcionario funcionario : this.funcionarios) {
            double salarioAtual = funcionario.getSalario().doubleValue();
            double salarioNovo = salarioAtual * (1.0 + aumento);
            funcionario.setSalario(new BigDecimal(salarioNovo));
            System.out.printf(
                "Novo Salário de %s: R$ %,.2f -> R$ %,.2f\n",
                funcionario.getNome(),
                salarioAtual,
                funcionario.getSalario()
            );
        }
    }

    public void agrupar() {
        System.out.println("\nFuncionários por função:");
        Map<String, List<Funcionario>> resultsMap = this.funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        for (Map.Entry<String, List<Funcionario>> entry : resultsMap.entrySet()) {
            String funcao = entry.getKey();
            List<Funcionario> funcionarios = entry.getValue();

            System.out.println("\nFunção = " + funcao);

            for (int i = 0; i < funcionarios.size(); i++) {
                Funcionario funcionario = funcionarios.get(i);
                System.out.printf("Funcionário (%d): %s\n", (i + 1), funcionario.getNome());
            }
        }
    }

    public void filtrarPorMesAniversario() {
        System.out.println("\nAniversáriantes de outubro e dezembro:");
        for (Funcionario funcionario : this.funcionarios) {
            int mesAniversario = funcionario.getDataNascimento().getMonthValue();
            if (mesAniversario == 10 || mesAniversario == 12) {
                System.out.printf(
                    "\nAniversário de %s: %s ",
                    funcionario.getNome(),
                    funcionario.getDataNascimento().toString()
                );
            }
        }
    }

    public void filtrarPorMaiorIdade() {
        Funcionario funcionarioMaiorIdade = this.funcionarios.get(0);
        long maiorIdadeEmDias = funcionarioMaiorIdade.getAniversarioEmMeses();

        for (int i = 1; i < this.funcionarios.size(); i++) {
            Funcionario funcionario = this.funcionarios.get(i);
            long idadeEmDias = funcionario.getAniversarioEmMeses();

            if (idadeEmDias > maiorIdadeEmDias) {
                funcionarioMaiorIdade = funcionario;
                maiorIdadeEmDias = funcionarioMaiorIdade.getAniversarioEmMeses();
            }
        }

        System.out.printf(
            "\n\nFuncionário de maior idade: %s com %d anos\n",
            funcionarioMaiorIdade.getNome(),
            maiorIdadeEmDias / 12
        );
    }

    public void ordenarPorNome() {
        List<Funcionario> funcionarios = this.funcionarios;
        funcionarios.sort(Comparator.comparing(Pessoa::getNome));
        System.out.println("\nFuncionários ordenados alfabeticamente: ");

        for (Funcionario funcionario : funcionarios) {
            System.out.println("Funcionário nome: " + funcionario.getNome());
        }
    }

    public void somaDosSalarios() {
        double salarioTotal = 0;

        for (Funcionario funcionario : this.funcionarios) {
            salarioTotal += funcionario.getSalario().doubleValue();
        }

        System.out.println("\nSalário total da equipe: R$ " + salarioTotal + "\n");
    }

    public void salarioMinimoPorFuncionario() {
        for (Funcionario funcionario : this.funcionarios) {
            double salario = funcionario.getSalario().doubleValue() / 1212;
            System.out.printf(
                "Quantidade de Salários Mínimos de %s: %.2f\n",
                funcionario.getNome(),
                salario
            );
        }
    }
}
