package com.rest.maven.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rest.maven.model.Tabela;

public class DatabaseTabela {
	
	public Tabela getTabelaInfo() {
		
		Tabela tabela = new Tabela();
		DatabaseSource db = new DatabaseSource();
		
		Connection connection = db.getConnection();
		
		String sql = "select * from dbkodovi.tabela where id = 6";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				tabela.setId(rs.getInt(1));
				tabela.setKod(rs.getString(2));
				tabela.setNagrada(rs.getString(3));
				tabela.setProveren(rs.getInt(4));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tabela;
		
	}
	
	public Tabela getTabelainfo (Integer id) {
		
		Tabela tabela = new Tabela();
		DatabaseSource db = new DatabaseSource();
		
		Connection connection = db.getConnection();
		
		String sql = "select * from dbkodovi.tabela where id = " + id + "";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				tabela.setId(rs.getInt(1));
				tabela.setKod(rs.getString(2));
				tabela.setNagrada(rs.getString(3));
				tabela.setProveren(rs.getInt(4));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tabela;
		
	}
		
	}


