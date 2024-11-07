package com.Curso.Curso.entity;

import jakarta.persistence.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double nota;
    private boolean maisContribuicoesNoForum;
    private int cursosConcluidos;
    private boolean temVoucher;
    private boolean premium;

    @Embedded
    private Endereco endereco;

    public Aluno() {
    }

    public Aluno(double nota, boolean maisContribuicoesNoForum, int cursosConcluidos, boolean temVoucher, boolean premium, Endereco endereco) {
        this.nota = nota;
        this.maisContribuicoesNoForum = maisContribuicoesNoForum;
        this.cursosConcluidos = cursosConcluidos;
        this.temVoucher = temVoucher;
        this.premium = premium;
        this.endereco = endereco;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean isMaisContribuicoesNoForum() {
        return maisContribuicoesNoForum;
    }

    public void setMaisContribuicoesNoForum(boolean maisContribuicoesNoForum) {
        this.maisContribuicoesNoForum = maisContribuicoesNoForum;
    }

    public int getCursosConcluidos() {
        return cursosConcluidos;
    }

    public void setCursosConcluidos(int cursosConcluidos) {
        this.cursosConcluidos = cursosConcluidos;
    }

    public boolean isTemVoucher() {
        return temVoucher;
    }

    public void setTemVoucher(boolean temVoucher) {
        this.temVoucher = temVoucher;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    // Métodos de negócio
    public int calcularCursosAdicionais() {
        return nota > 7.0 ? 3 : 0;
    }

    public boolean verificarSeGanhouCursoAdicional() {
        return maisContribuicoesNoForum;
    }

    public void verificarStatusPremium() {
        if (cursosConcluidos >= 12) {
            this.premium = true;
        }
    }

    public void verificarRecebimentoDeVoucher() {
        if (premium) {
            this.temVoucher = true;
        }
    }

	public void setContribuicoesUteisNoForum(int i) {
		// TODO Auto-generated method stub
		
	}
}
