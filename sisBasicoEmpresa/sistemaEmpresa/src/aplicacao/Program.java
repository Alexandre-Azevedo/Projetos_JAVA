package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.ContratoPorHora;
import entidades.Departamento;
import entidades.Trabalhadores;
import entidades.enums.NivelDoTrabalhador;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Digite o nome do deparatamento:" );
		String nomeDoDepartamento = sc.nextLine();
		System.out.println("Digite os dados do trabalhador: ");
		System.out.println("Nome: ");
		String nomeDoTrabalhador = sc.nextLine();
		System.out.println("Nivel: ");
		String nivel = sc.nextLine();
		System.out.println("S?lario Base: ");
		Double salarioBase = sc.nextDouble();
		Trabalhadores trabalhador = new Trabalhadores(nomeDoTrabalhador, NivelDoTrabalhador.valueOf(nivel), salarioBase, new Departamento(nomeDoDepartamento));
		System.out.println("Quantos contratos esse trabalhaor tem? ");
		int n = sc.nextInt();
		for(int i=1; i<n; i++) {
			System.out.println("Digite os dados do "+i+"? contrato: ");
			System.out.print("Data (DD/MM/AAAA): ");
			Date dataDoContrato = sdf.parse(sc.next());
			System.out.println("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.println("Horas: ");
			int hora = sc.nextInt();
			ContratoPorHora contrato = new ContratoPorHora(dataDoContrato, valorPorHora, hora);
			trabalhador.adicionarContrato(contrato);
		}
		System.out.println();
		System.out.println("Digite o m?s e o ano para calcular o montante (MM/YYYY): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println("Nome: "+trabalhador.getNome());
		System.out.println("Departamento: "+trabalhador.getDepartamento().getNome());
		System.out.println("Montante de "+mesEAno+": "+String.format("%.2f",trabalhador.calcularGanhos(ano, mes)));
		sc.close();
	}
	
}
