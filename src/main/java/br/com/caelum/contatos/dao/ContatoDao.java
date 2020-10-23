package br.com.caelum.contatos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caelum.contatos.modelo.Contato;

@Repository
public class ContatoDao {
	private final Connection connection;

	@Autowired
	public ContatoDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> lista() {
		try {
			List<Contato> listaDeContatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));

				listaDeContatos.add(contato);
			}

			rs.close();
			stmt.close();

			return listaDeContatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void salva(Contato contato) {
		try {
			PreparedStatement ps = this.connection.prepareStatement("insert into contatos (nome, email, telefone) values (?, ?, ?)");
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getTelefone());
			
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
