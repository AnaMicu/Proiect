package com.sii.biblioteca.controllers;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sii.biblioteca.models.BaseModel;

public class BaseController<T extends BaseModel> {

	private final Class<T> clazz;

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost:3306/biblioteca";
	private final String DB_NAME = "biblioteca";
	private final String USER = "root";
	private final String PASS = "root";

	protected Connection conn = null;
	java.util.Map<String, Class<?>> map = new HashMap<String, Class<?>>();

	public BaseController(Class<T> clazz) {
		this.clazz = clazz;
		this.map.put(
				DB_NAME.concat(".").concat(clazz.getSimpleName().toLowerCase()),
				clazz);
	}

	public  void openConnection() {

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			conn.setTypeMap(map);

		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot open connection");
		}

	}

	public void closeConnection() {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Cannot close connection");
			}
		}

	}

	public List<T> selectAll() {
		List<T> values = new ArrayList<T>();

		openConnection();

		try {

			// query
			String query = "SELECT * FROM ".concat(clazz.getSimpleName());

			// create the java statement
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {
				// create an object of type T
				T current_object = clazz.newInstance();

				// get all the fields of the object
				Field[] fields = clazz.getDeclaredFields();

				// set each field with the corresponding value from returned by the select
				for (Field f : fields) {
					f.set(current_object,
							rs.getObject(f.getName().toLowerCase()));
				}

				values.add(current_object);
			}

			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			closeConnection();
		}

		return values;
	}

	
	// public T getById(int id){}
	
	

}
