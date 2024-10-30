package hotel;

public class Funcionario extends Pessoa {
	private String cargo;
	private Double salario;
	private String turnoDeTrabalho;
	private Integer qtdeHorasTrabalhadas = 0;
	private Double valorHoras = 50.0;
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(String nome, String cpf, String cargo, String tdt) {
		super(nome, cpf);
		this.setCargo(cargo);
		this.setTurnoDeTrabalho(tdt);
	}
	
	public String toString() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("CPF: " + this.getCpf());
		System.out.println("Cargo: " + this.getCargo());
		System.out.println("Turno de Trabalho: " + this.getTurnoDeTrabalho());
		return "";
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
		cargo = trataEntrada(cargo);
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
		turnoDeTrabalho = trataEntrada(turnoDeTrabalho);
		this.turnoDeTrabalho = turnoDeTrabalho;
	}
	
	public Double calculaSalario() {
		Double salario = this.getValorHoras() * this.getQtdeHorasTrabalhadas();
		
		this.setSalario(salario);
		
		return this.getSalario();
	}
	
}