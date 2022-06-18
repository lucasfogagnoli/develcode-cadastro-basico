package br.com.develcode.cadastro.response;

import java.time.LocalDateTime;

public class Response<T> {

	LocalDateTime dataExecucao;
	Integer nrStatus;
	String txMensagem;
	transient T dados;

	public Response(T dados, Integer nrStatus, String txMensagem) {
		this.dataExecucao = LocalDateTime.now();
		this.dados = dados;
		this.nrStatus = nrStatus;
		this.txMensagem = txMensagem;
	}

	public LocalDateTime getDataExecucao() {
		return dataExecucao;
	}

	public void setDataExecucao(LocalDateTime dataExecucao) {
		this.dataExecucao = dataExecucao;
	}

	public T getDados() {
		return dados;
	}

	public void setDados(T dados) {
		this.dados = dados;
	}

	public String getTxMensagem() {
		return txMensagem;
	}

	public void setTxMensagem(String txMensagem) {
		this.txMensagem = txMensagem;
	}

	public Integer getNrStatus() {
		return nrStatus;
	}

	public void setNrStatus(Integer nrStatus) {
		this.nrStatus = nrStatus;
	}

}
