package GerenciamentoHotel;

public class Funcionario extends Pessoa {
	private String cargo;
	private Double salario;
	private String turnoDeTrabalho;
	private Integer qtdeHorasTrabalhadas;
	private Double valorHoras;
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(String nome, String cpf, String cargo, String tdt) {
		super(nome, cpf);
		this.setCargo(cargo);
		this.setTurnoDeTrabalho(tdt);
	}

	public Integer getQtdeHorasTrabalhadas() {
		return qtdeHorasTrabalhadas;
	}

	public void setQtdeHorasTrabalhadas(Integer qtdeHorasTrabalhadas) {
		this.qtdeHorasTrabalhadas = qtdeHorasTrabalhadas;
	}

	public Double getValorHoras() {
		return valorHoras;
	}

	public void setValorHoras(Double valorHoras) {
		this.valorHoras = valorHoras;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getTurnoDeTrabalho() {
		return turnoDeTrabalho;
	}

	public void setTurnoDeTrabalho(String turnoDeTrabalho) {
		this.turnoDeTrabalho = turnoDeTrabalho;
	}
	
}
