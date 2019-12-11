package com.briup.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IResuleSetWork {
	Object doWork(ResultSet rs)throws SQLException;
}
