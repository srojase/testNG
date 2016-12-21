package factory;

import java.sql.Connection;

public interface IDBAdapter {
	public Connection getConexion();
}
