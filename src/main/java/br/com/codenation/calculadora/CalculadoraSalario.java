package br.com.codenation.calculadora;
import java.lang.Math;

public class CalculadoraSalario {
    final double SALARIO_MINIMO = 1039.00f;

	public long calcularSalarioLiquido(double salarioBruto) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		double salarioLiquido;
		if (salarioBruto < SALARIO_MINIMO)
		{
			return (Math.round(0.0));
		}
		salarioLiquido = salarioBruto-(calcularInss(salarioBruto)+calcularIrpf(salarioBruto));
		return (Math.round(salarioLiquido));		
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBruto) {
	//Primeiro deve ser calculado o valor do desconto do INSS
	double descontoInss,taxaInss;
	if (salarioBruto<=1500.00f)
		{
			taxaInss = 0.08f;
		}else if(salarioBruto<=4000.00f)
			{
				taxaInss = 0.09f;
			}else
			{
				taxaInss = 0.11f;
			}	
    descontoInss =  salarioBruto*taxaInss;
	return descontoInss;
	}
	
	private double calcularIrpf(double salarioBruto) {
	//Segundo deve ser calculado o valor do desconto do IRPF
	double salarioBase,taxaIrpf, descontoIrpf;
	salarioBase = salarioBruto - calcularInss(salarioBruto);
	if (salarioBase<=3000.00f) 
	{
		taxaIrpf = 0.0;
	}else if(salarioBase<=6000.00f)
			{	
				taxaIrpf = 0.075f;
			}else 
				{
					taxaIrpf = 0.15f;
				}
	descontoIrpf =  salarioBase*taxaIrpf;
	return descontoIrpf;
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/