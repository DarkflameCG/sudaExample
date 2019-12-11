package com.briup.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IPsWork {

	void doWork(PreparedStatement ps)throws SQLException;
	
}
