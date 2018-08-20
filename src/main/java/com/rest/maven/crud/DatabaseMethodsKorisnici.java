package com.rest.maven.crud;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.maven.datasource.DatabaseKorisnici;
import com.rest.maven.model.Korisnici;

@Path("/korisnici")
public class DatabaseMethodsKorisnici {

	@GET
	@Produces({ MediaType.TEXT_HTML })
	public String returnString() {

		Connection connect = null;

		String dbase = "jdbc:mysql://localhost:3306/dbkodovi?useSSL=false";
		String dbpass = "root";
		String dbuser = "root";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(dbase, dbuser, dbpass);
			return "Connection succesfull";

		} catch (Exception e) {
			return "Connection fail";
		}
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Korisnici findKorisnik(@PathParam("id") Integer id) {
		Korisnici korisnik = new Korisnici();
		DatabaseKorisnici db = new DatabaseKorisnici();
		korisnik = db.getKorisnikInfo(id);
		return korisnik;
	}

}
