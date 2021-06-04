package org.spring.backend.projetocurso.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import org.spring.backend.projetocurso.enums.EstadoPagamento;
@Entity
public class PagamentoComCartao extends PagamentoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Integer numeroDeParcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento pagamento, PedidoEntity pedido,Integer numeroDeParcelas) {
		super(id, pagamento, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
}
