package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelDoTrabalhador;

public class Trabalhadores {
	private String nome;
	private NivelDoTrabalhador nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<ContratoPorHora> contratos = new ArrayList<>();//Ler mais


	public Trabalhadores(String nome, NivelDoTrabalhador nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public NivelDoTrabalhador getNivel() {
		return nivel;
	}


	public void setNivel(NivelDoTrabalhador nivel) {
		this.nivel = nivel;
	}


	public Double getSalarioBase() {
		return salarioBase;
	}


	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public List<ContratoPorHora> getContratos() {
		return contratos;
	}

	
	public void adicionarContrato(ContratoPorHora contrato) {
		contratos.add(contrato);
	}
	
	public void removerContrato(ContratoPorHora contrato) {
		contratos.remove(contrato);
	}
	
	public double calcularGanhos(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for(ContratoPorHora c : contratos) {//Ler mais
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = cal.get(Calendar.MONTH);
			if(c_ano == ano && c_mes == mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
}
