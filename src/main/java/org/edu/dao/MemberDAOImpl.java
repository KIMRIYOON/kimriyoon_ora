package org.edu.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.edu.vo.MemberVO;
import org.edu.vo.PageVO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements IF_MemberDAO {
	
	private static String mapperQuery = "org.edu.dao.IF_MemberDAO";
	                      //쿼리가 아직 안쓰이면 밑에 노란색 줄로 표시된다.
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insertMember(MemberVO memberVO) throws Exception {
		sqlSession.insert(mapperQuery + ".insertMember", memberVO);
	}

	@Override
	public List<MemberVO> selectMember(PageVO pageVO) throws Exception {
		return sqlSession.selectList(mapperQuery + ".selectMember", pageVO);
	}

	@Override
	public void updateMember(MemberVO memberVO) throws Exception {
		sqlSession.update(mapperQuery + ".updateMember", memberVO);
		
	}

	@Override
	public void deletMember(String user_id) throws Exception {
		sqlSession.delete(mapperQuery + ".deleteMember", user_id);
		
	}

	@Override
	public MemberVO viewMember(String user_id) throws Exception {
		return sqlSession.selectOne(mapperQuery + ".viewMember", user_id);
	}

	@Override
	public int countUserId(PageVO pageVO) throws Exception {
		return sqlSession.selectOne(mapperQuery + ".countUserId", pageVO);
	}



}
