package org.spring.backend.projetocurso.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import org.spring.backend.projetocurso.enums.EstadoPagamento;
@Entity
public class PagamentoComBoleto extends PagamentoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento pagamento, PedidoEntity pedido, Date dataVencimento, Date dataPagamento) {
		super(id, pagamento, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
}
