/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Administrador
 */
public class Matricula {
    private int codMatricula;
    private ArrayList<Turma> turma = new ArrayList();
    private ArrayList<Aluno> aluno = new ArrayList();
    private Calendar dataMatricula;
    private int modulo;

    /**
     * @return the codMatricula
     */
    public int getCodMatricula() {
        return codMatricula;
    }

    /**
     * @param codMatricula the codMatricula to set
     */
    public void setCodMatricula(int codMatricula) {
        this.codMatricula = codMatricula;
    }

    /**
     * @return the turma
     */
    public ArrayList<Turma> getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(ArrayList<Turma> turma) {
        this.turma = turma;
    }

    /**
     * @return the aluno
     */
    public ArrayList<Aluno> getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(ArrayList<Aluno> aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the dataMatricula
     */
    public Calendar getDataMatricula() {
        return dataMatricula;
    }

    /**
     * @param dataMatricula the dataMatricula to set
     */
    public void setDataMatricula(Calendar dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    /**
     * @return the modulo
     */
    public int getModulo() {
        return modulo;
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(int modulo) {
        this.modulo = modulo;
    }
    
}
