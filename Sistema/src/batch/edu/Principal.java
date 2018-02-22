package batch.edu;

public class Principal {
	
	public static void main (String args[]) {
		BancoImplementacao banco = new BancoImplementacao();
		banco.deletarDados();
		banco.adicionar();
		System.out.println("A média final é: "+banco.mediaIntervalo() + "\n");
		System.out.println("Segue abaixo a lista dos clientes utilizados para o cálculo da média:\n\n"+banco.pesquisarClientes());
	}
}