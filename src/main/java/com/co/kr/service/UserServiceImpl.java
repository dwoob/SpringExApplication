package com.co.kr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.kr.domain.LoginDomain;
import com.co.kr.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper UserMapper;

	@Override
	public void mbCreate(LoginDomain loginDomain) {
		UserMapper.mbCreate(loginDomain);
	}
	@Override
	public LoginDomain mbSelectList(Map<String, String> map) {
		return UserMapper.mbSelectList(map);
	}
	@Override
	public List<LoginDomain> mbAllList(Map<String, Integer> map) { 
		return UserMapper.mbAllList(map);
	}
	@Override
	public void mbUpdate(LoginDomain loginDomain) {
		UserMapper.mbUpdate(loginDomain);
	}
	@Override
	public void mbRemove(Map<String, String> map) {
		UserMapper.mbRemove(map);
	}
	@Override
	public LoginDomain mbGetId(Map<String, String> map) {
		return UserMapper.mbGetId(map);
	}
	@Override
	public int mbDuplicationCheck(Map<String, String> map) {

		return UserMapper.mbDuplicationCheck(map);
	}
	@Override
	public int mbGetAll() {

		return UserMapper.mbGetAll();
	}
}