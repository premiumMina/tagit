package com.nexters.tagit.mapper;

import java.util.List;
import com.nexters.tagit.model.User;

// User 테이블에서 쿼리를 진행하는 인터페이스
public interface UserMapper {
	
	List<User> selectAll();
	void insertUser(User user);
	User selectById(User user); 

}
