package com.co.kr.service;

import java.util.List;
import java.util.Map;

import com.co.kr.domain.LoginDomain;


public interface UserService {

    public LoginDomain mbSelectList(Map<String, String> map);
    
    public List<LoginDomain> mbAllList(Map<String, Integer> map);
    
    public static int mbGetAll() {
		// TODO Auto-generated method stub
		return 0;
	}

    public static void mbCreate(LoginDomain loginDomain) {
		// TODO Auto-generated method stub
		
	}

    public LoginDomain mbGetId(Map<String, String> map);
    
    public static int mbDuplicationCheck(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}

    public void mbUpdate(LoginDomain loginDomain); 

    public static void mbRemove(Map<String, String> map) {
		// TODO Auto-generated method stub
	} 
    
}