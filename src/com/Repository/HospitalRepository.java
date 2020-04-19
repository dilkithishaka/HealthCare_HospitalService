package com.Repository;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Model.Hospital;

public class HospitalRepository {
	
	Connection con = null;
	
	public HospitalRepository() {
		String dbURL = "";
		String dbUname = "";
		String dbPassword = "";
		
		try {
			Class.forName("");
			con = (Connection) DriverManager.getConnection(dbURL, dbUname, dbPassword);
			System.out.println("connected");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public Hospital searchHospital(int hospitalID) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM hospitals WHERE hospitalID = " +hospitalID;
		Hospital h = new Hospital();
		
		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				h.setHospitalID(result.getInt(1));
				h.setHospitalName(result.getString(2));
				h.setCity(result.getString(3));
				h.setAddress(result.getString(4));
				h.setEmail(result.getString(5));
				h.setContactNumber(result.getInt(6));
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return h;
	}

	public List<Hospital> viewHospitals() {
		// TODO Auto-generated method stub
		List<Hospital> hospital = new ArrayList();
		
		String sql = "SELECT * FROM hospitals";
		
		try {
			
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(sql);
			
			while(result.next()) {
				Hospital h = new Hospital();
				h.setHospitalID(result.getInt(1));
				h.setHospitalName(result.getString(2));
				h.setCity(result.getString(3));
				h.setAddress(result.getString(4));
				h.setEmail(result.getString(5));
				h.setContactNumber(result.getInt(6));
				
				hospital.add(h);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return hospital;
	}

	public List<Hospital> viewDoctors() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Hospital> viewPayments() {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(Hospital h) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO hospitals VALUES (?,?,?,?,?,?)";
		
		try {
				
			PreparedStatement statement = con.prepareStatement(sql);
				
			statement.setInt(1,h.getHospitalID());
			statement.setString(2,h.getHospitalName());
			statement.setString(3,h.getCity());
			statement.setString(4,h.getAddress());
			statement.setString(5,h.getEmail());
			statement.setInt(6,h.getContactNumber());
				
			statement.executeUpdate();
				System.out.println("one row inserted successfully...");							
		}catch (Exception e) {
				// TODO: handle exception
			System.out.println(e);
			}
		
	}

	public void update(Hospital h) {
		// TODO Auto-generated method stub
		String sql = "UPDATE hospitals SET hospitalName=?, city=?, address=?, email=?, contactNumber=? WHERE hospitalID=?";
		
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(2,h.getHospitalName());
			statement.setString(3,h.getCity());
			statement.setString(4,h.getAddress());
			statement.setString(5,h.getEmail());
			statement.setInt(6,h.getContactNumber());
			statement.setInt(1,h.getHospitalID());
			statement.executeUpdate();
			
			System.out.println("One row updated...");
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public void delete(int hospitalID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM hospitals WHERE hospitalID=?";
		
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, hospitalID);
			statement.executeUpdate();
			
			System.out.println("One row deleted!");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
}
