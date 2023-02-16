package dao;

import java.sql.SQLException;
import model.Estudante;

public interface IEstudante {
    public void inserir(Estudante estudante) throws SQLException;
    public void excluir(Estudante estudante) throws SQLException;
    public void alterar(Estudante estudante, String novoNome) throws SQLException;


}