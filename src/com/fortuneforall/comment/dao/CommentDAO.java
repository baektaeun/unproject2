package com.fortuneforall.comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fortuneforall.comment.domain.Comment;
import com.fortuneforall.drink.domain.Drink;
import com.fortuneforall.fortunereview.domain.FortuneReview;
import com.fortuneforall.util.ConnectionPool;
import com.fortuneforall.util.JdbcUtil;

public class CommentDAO {
	
	public List<Comment> selectBoard(int no){
		List<Comment> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		
		try {
			
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			
			sql.append("select m.id, c.CONTENT, c.reg_date, c.comment_no");
			sql.append("  from tb97_board b ");
			sql.append(" inner join tb97_comment c");
			sql.append("    on b.board_NO = c.board_NO ");
			sql.append(" inner join tb97_member m");
			sql.append("    on m.MEMBER_NO = c.MEMBER_NO ");
			sql.append(" where c.board_no = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getString("id"));
				comment.setContent(rs.getString("content"));
				comment.setReg_date(rs.getDate("reg_date"));
				comment.setComment_no(Integer.parseInt(rs.getString("comment_no")));
				list.add(comment);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
		return list;
		
	}
	
	public void insertComment(Comment comment) {
		List<Comment> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		System.out.println("comment id : "+comment.getId());
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into tb97_comment(board_no, member_no, comment_no, content) values(?, (select member_no from tb97_member where id = ?), s_comment_no.nextval, ?)");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, comment.getBoard_no());
			pstmt.setString(2, comment.getId());
			pstmt.setString(3, comment.getContent());
			
			
			int cnt = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
	}
	
	public void updateComment(Comment c) {
		List<Comment> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update tb97_comment set content = ? where comment_no = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, c.getContent());
			pstmt.setInt(2, c.getComment_no());
			list.add(c);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	public boolean deleteBoard(int no) {
		List<Comment> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from tb97_comment where comment_no = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			int cnt = pstmt.executeUpdate();
			if(cnt == 0) {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
		return true;
	}
	
	public int checkId(String id, int board_no) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select m.member_no from tb97_member m inner join tb97_comment c on c.member_no = m.member_no where m.id = ? and c.comment_no = ?");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, id);
			stmt.setInt(2, board_no);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if(rs.getInt("member_no")!=0) {
					System.out.println("same person");
					return 0;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return 1;
	}
}
