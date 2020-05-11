package com.renanmendonca.servicos.execoes;

public class ExcecaoDeObjetosNaoEncontrados extends RuntimeException {
	private static final long serialVersionUID = 1L;

	
	public ExcecaoDeObjetosNaoEncontrados(String msg) {
		super(msg);
	}
}
