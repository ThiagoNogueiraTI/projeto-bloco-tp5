package br.edu.infnet.pb;

import java.sql.Date;

public class SistemaPagamento {

	private String idPagamento;
	private String idUsuario;
	private Date dataPagamento;
	private enum FormaPagamento{Boleto, Pix, Cartao};
	private FormaPagamento formaPagamento;
	private double valor;
	
	public void efetuarPagamento() {
		System.out.println("Pagamento efetuado no valor de: " + valor);
	}
		
	public void definirFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public void confirmarPagamento() {
		System.out.println("Pagamento confirmado");
	}
	
	public void emitirNotaFiscal() {
		System.out.println("Emitindo Nota Fiscal");
	}
}
