/*
  	** mybatis 프레임워크의 핵심 컴포넌트
  	   1) SqlSession : 실제 SQL을 실행하는 객체로 이 객체는 SQL을 처리하기 위해
  	   				   JDBC드라이버를 사용합니다.
  	   
  	   2) SqlSessionFactory : SqlSession 객체를 생성합니다.
  	   
  	   3) SqlSessionFactoryBuilder : 마이바티스 설정 파일의 내용을 토대로 SqlSessionFactory를 생성합니다.
  	   
  	   4) mybatis 설정 파일 : 데이터 베이스 연결 정보, 트랜잭션 정보,
  	   						mybatis 제어 정보 등의 설정 내용을 포함하고 있습니다.
  	   						SqlSessionFactory 를 만들 때 사용됩니다.
  	   
  	   5) SQL 맵퍼 파일 : SQL문을 담고 있는 파일로 SqlSession 객체가 참조합니다.
  	   
  	** SqLSession의 주요 메서드
  	   1) selectList() : select 문을 실행합니다.
  	                     값 객체(Value Object) 목록을 반환합니다.
  	                     쿼리 결과를 List<E>로 반환합니다.
  	                     결과가 없으면 size() 가 0인 List를 반환합니다.
 	   2) selectOne() : select 문을 실행합니다.
 	   					하나의 값 객체(Value Object)를 반환합니다.
 	   					쿼리결과가 없으면 null을 반환합니다.
 	   3) insert() : insert문을 실행합니다. 반환값은 입력한 로우 갯수입니다.
 	   4) update() : update문을 실행합니다. 반환값은 변경한 로우 갯수입니다.
 	   5) delete() : delete문을 실행합니다. 반환값는 삭제한 로우 갯수입니다.
 */
package org.hta.member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hta.member.domain.Member;

public class MemberDao_설명 {
	
	private SqlSession getSession() {
		SqlSession session = null;
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("org/hta/mybatis/config/sqlMapConfig.xml");
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
			session = sf.openSession(true);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}

	public int chk(Member mem) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Member mem) {
		// TODO Auto-generated method stub
		return 0;
	}

}
