package by.htp3.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.htp3.hotel.dao.RegistrationDAO;
import by.htp3.hotel.dao.exception.DAOException;
import by.htp3.hotel.dao.impl.pool.ConnectionPool;
import by.htp3.hotel.dao.impl.pool.ConnectionPoolException;

public class SOLRegistrationDAO implements RegistrationDAO {
	@Override
	public void addNewUsers(String name, String lastname, String email, String login, String password)throws DAOException {
		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;

		try {
			con = ConnectionPool.getInstance().takeConnection();

			st = con.prepareStatement("INSERT INTO usersreg (name, lastname, email, login, password) VALUES (?,?,?,?,?)");

			st.setString(1, name);
			st.setString(2, lastname);
			st.setString(3, email);
			st.setString(4, login);
			st.setString(5, password);
		
			
			
			
			
			
			
			try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Logination sql error..", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("pool exception", e);
		} finally {

			if (st != null & st2!= null) {
				try {
					st.close();
					
				} catch (SQLException e) {
					
				}
			}
			try {
				ConnectionPool.getInstance().returnConnection(con);
			} catch (ConnectionPoolException e) {
				
			}

		}
	}

}
