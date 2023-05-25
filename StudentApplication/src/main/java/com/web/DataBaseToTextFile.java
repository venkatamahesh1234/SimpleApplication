package com.web;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseToTextFile {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/odb";
		String user = "root";
		String password = "root";
		String query = "SELECT * FROM Student";
		try {
			// Establishing Database Connection
			Connection con = DriverManager.getConnection(url, user, password);

			// Create Statement And Execute Query
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Open Output File
			FileWriter fw = new FileWriter("output.txt");

			// Write Data To Output File
			while (rs.next()) {
				Integer stdId = rs.getInt("stdId");
				String name = rs.getString("name");
				String course = rs.getString("course");
				double fee = rs.getDouble("fee");
				int s1 = rs.getInt("s1");
				int s2 = rs.getInt("s2");
				int s3 = rs.getInt("s3");
				double total = rs.getDouble("total");
				double percentage = rs.getDouble("percentage");
				String grade = rs.getString("grade");
				fw.write(stdId + "\t" + name + "\t" + course + "\t" + fee + "\t" + s1 + "\t" + s2 + "\t" + s3 + "\t"
						+ total + "\t" + percentage + "\t" + grade + "\t" + "\n");
			}
			rs.close();
			stmt.close();
			rs.close();
			con.close();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
