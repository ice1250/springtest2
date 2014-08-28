package com.taehee.springtest.mybatis;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.taehee.springtest.dao.UserDao;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public int getLoginResult(Map<String, String> map) {
		return (Integer) getSqlSession().selectOne("userDao.getLoginResult",
				map);
	}

}
