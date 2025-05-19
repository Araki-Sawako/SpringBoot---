package com.college.yi.bookmanager.util;

import java.util.List;

public class UserDetails {

	public UserDetails(String username, String password, boolean enabled, boolean b, boolean c, boolean d,
			List<SimpleGrantedAuthority> singletonList) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

}

interface UserDetailsService {

}

class SimpleGrantedAuthority{
	public SimpleGrantedAuthority(String string) {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
}
class UsernameNotFoundException extends Exception {

	public UsernameNotFoundException(String string) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

}
