package com.book.rental.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Inject
	SqlSession sqlSession;

	@Override
	public String loginOk(HashMap<String, String> reqMap) {
		
		String name=sqlSession.selectOne("LoginDao.loginOk",reqMap);
		
		return name;
	}
	

}
