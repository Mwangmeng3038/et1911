package com.etoak.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.etoak.action.UserAction;
import com.etoak.service.UserService;

/*
 * ע��@Configuration:�൱��xml�ĸ�Ԫ��<beans>��ǩ,��ʾ����һ��ioc����
 * */
@Configuration
public class UserConfig {

	/*ʹ��@Beanע��spring bean
	 * ���������൱��<bean>��ǩ��class���� 
	 * ������������Ϊ��<bean>��ǩ��id����
	*/
	@Bean("userService")
	public UserService userService(){
		return new UserService();
	}
	
	@Bean
	public UserAction userAction(@Qualifier("userService") UserService userService){
		UserAction userAction = new UserAction();
		userAction.setUserService(userService);
		return  userAction;
	}

}
