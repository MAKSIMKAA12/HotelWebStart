package by.htp3.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.dao.PersonalAccountDAO;
import by.htp3.hotel.dao.exception.DAOException;
import by.htp3.hotel.dao.impl.pool.ConnectionPool;
import by.htp3.hotel.dao.impl.pool.ConnectionPoolException;


public class SQLPersonalAccountDAO implements PersonalAccountDAO {

	@Override
	public User showUserInformation(String login) throws DAOException {
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	
	try {
		con = ConnectionPool.getInstance().takeConnection();
		


		st = con.prepareStatement("select * from usersreg where login=?");
		System.out.println("селект");
      
		st.setString(1, login);
		
		System.out.println("выборка 5 пораметров");
		rs = st.executeQuery();
		System.out.println(" после rs");
		if (!rs.next()) {
			return null;
		}

		User user = new User();
		System.out.println("cоздание юзера");
		user.setName(rs.getString("name"));
		user.setSurname(rs.getString("lastname"));
		user.setEmail(rs.getString("email"));
		user.setLogin(rs.getString("login"));
		user.setPassword(rs.getString("password"));
		System.out.println("Параметры из DAO");

		return user;
	}  catch (SQLException e) {
		throw new DAOException("Logination sql error..", e);
	} catch (ConnectionPoolException e) {
		throw new DAOException("pool exception", e);
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// logging
			}
		}

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// logging
			}
		}
		try {
			ConnectionPool.getInstance().returnConnection(con);
		} catch (ConnectionPoolException e) {
			//loggin error
		}

	}

	}

}
