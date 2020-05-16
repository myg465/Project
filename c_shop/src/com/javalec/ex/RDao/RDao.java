package com.javalec.ex.RDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.RDto.RDto;

public class RDao {
			//db연결 필요 변수
			Context context=null;
			DataSource ds=null;
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql=null;
			
			
			ArrayList<RDto> list=new ArrayList<RDto>();
			RDto dto=new RDto();
			
			//데이터를 받는데 필요변수
			int rId,rHit,rGroup,rStep,rIndent,rNum;
			String id,name,rTitle,rContent,rContentimg;
			Timestamp rDate;
			
			
			//생성자
			public RDao() {
				//커넥션풀 생성(생성하자마자)
				try {
					context=new InitialContext();
					ds=(DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			
			//전체 select-list
			public ArrayList<RDto> list(int page,int limit) {
				//번호를 붙여서 가져옴(최대 갯수만큼)
				int startrow=(page-1)*10+1;
				int endrow=startrow+limit-1;
				
				
				sql="select * from (select rownum rnum,rId,id,name,rTitle,rContent,rContentImg,rDate,rHit,rGroup,rStep,rIndent from"+ 
					"(select * from mvc_review order by rGroup desc,rid asc)) where rnum>=? and rnum<=?";
				
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, startrow);
					pstmt.setInt(2, endrow);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						rNum=rs.getInt("rnum");
						rId=rs.getInt("rId");
						name=rs.getString("name");
						rTitle=rs.getString("rTitle");
						rContent=rs.getString("rContent");
						rContentimg=rs.getString("rContentimg");
						rHit=rs.getInt("rHit");
						rDate=rs.getTimestamp("rDate");
						rGroup=rs.getInt("rGroup");
						rStep=rs.getInt("rStep");
						rIndent=rs.getInt("rIndent");
						id=rs.getString("id");

						dto=new RDto(rNum,rId, id, name, rTitle, rContent, rContentimg, rDate, rHit, rGroup, rStep, rIndent);
						list.add(dto);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				return list;
				
			}//전체 select
			
			/*
			//검색select(오버로딩)
			public ArrayList<BDto> list(int page,int limit,String category,String searchcon) {
				//번호를 붙여서 가져옴(최대 갯수만큼)
				int startrow=(page-1)*10+1;
				int endrow=startrow+limit-1;
				
				sql="select * from (select rownum rnum,bId,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent from"+ 
					"(select * from mvc_board where "+category+" like '%"+searchcon+"%' order by bGroup desc,bid asc)) where rnum>="+startrow+" and rnum<="+endrow;
				
				try {
					con=ds.getConnection();
					Statement stmt=con.createStatement();
					System.out.println(sql);
					rs=stmt.executeQuery(sql);
					while(rs.next()) {
						bId=rs.getInt("bId");
						bName=rs.getString("bName");
						bTitle=rs.getString("bTitle");
						bContent=rs.getString("bContent");
						bHit=rs.getInt("bHit");
						bDate=rs.getTimestamp("bDate");
						bGroup=rs.getInt("bGroup");
						bStep=rs.getInt("bStep");
						bIndent=rs.getInt("bIndent");

						dto=new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
						list.add(dto);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				return list;
				
			}//전체 select
			
			
			//3개 얻어오기(앞뒤글 포함)//글읽기
			public ArrayList<BDto> content_view(int bId) {
				
				plusHit(bId);

				sql="select * from (select rownum rnum,bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent from" + 
						"(select * from mvc_board order by bgroup desc,bid asc))" + 
						"where bid between (select max(bid) from mvc_board where bid<?) and (select min(bid) from mvc_board where bid>?)";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, bId);
					pstmt.setInt(2, bId);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						bId=rs.getInt("bId");
						bName=rs.getString("bName");
						bTitle=rs.getString("bTitle");
						bContent=rs.getString("bContent");
						bDate=rs.getTimestamp("bDate");
						bHit=rs.getInt("bHit");
						bGroup=rs.getInt("bGroup");
						bStep=rs.getInt("bStep");
						bIndent=rs.getInt("bIndent");
						
						dto=new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
						list.add(dto);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				return list;
				
			}//content_view
				
				
				//한개 얻는 메소드(수정,답글용)
				public BDto content_view2(int bId) {
				
				sql="select * from mvc_board where bId=?";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, bId);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						bId=rs.getInt("bId");
						bName=rs.getString("bName");
						bTitle=rs.getString("bTitle");
						bContent=rs.getString("bContent");
						bDate=rs.getTimestamp("bDate");
						bHit=rs.getInt("bHit");
						bGroup=rs.getInt("bGroup");
						bStep=rs.getInt("bStep");
						bIndent=rs.getInt("bIndent");
						
						dto=new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				return dto;
				
			}//content_view
			
			
			//글작성(insert)
			public int write(String bName,String bTitle,String bContent) {
				
				int check=0;
				sql="insert into mvc_board values (mvc_board_seq.nextval,?,?,?,sysdate,0,mvc_board_seq.currval,0,0)";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, bName);
					pstmt.setString(2, bTitle);
					pstmt.setString(3, bContent);
					check=pstmt.executeUpdate();
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				return check;
				
			}//insert
			
			//리플달기(insert)
			public int reply(int bId,int bGroup,int bStep,int bIndent,String bName,String bTitle,String bContent) {
				
				int check=0;
				//스텝 1증가
				plusStep(bId);
				sql="insert into mvc_board values(mvc_board_seq.nextval,?,?,?,sysdate,0,?,?,?)";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,bName);
					pstmt.setString(2, bTitle);
					pstmt.setString(3, bContent);
					pstmt.setInt(4, bGroup);
					pstmt.setInt(5, bStep+1);
					pstmt.setInt(6, bIndent+1);
					check=pstmt.executeUpdate();
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				return check;
				
			}//reply
			
			//삭제(delete)
			public int delete(int bId) {
				
				int check=0;
				sql="delete from mvc_board where bId=?";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, bId);
					check=pstmt.executeUpdate();
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(pstmt!=null) rs.close();
						if(con!=null) con.close();
					}catch(Exception e2){
						e2.printStackTrace();
					}
				}
				
				return check;
				
			}//delete
			
			//수정(update)
			public int modify(int bId,String bName,String bTitle,String bContent) {
				
				int check=0;
				sql="update mvc_board set bName=?,bTitle=?,bContent=? where bId=?";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, bName);
					pstmt.setString(2, bTitle);
					pstmt.setString(3, bContent);
					pstmt.setInt(4, bId);
					check=pstmt.executeUpdate();
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(pstmt!=null) rs.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				return check;
				
			}//modify
			
			//조회수 증가 메소드
			public void plusHit(int bId) {
				sql="update mvc_board set bHit=bHit+1 where bId=?";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, bId);
					pstmt.executeUpdate();
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();	
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
			}//plusHit
			
			//댓글수 증가 메소드(plusstep)
			public void plusStep(int bId) {
				sql="update mvc_board set bStep=bStep+1 where bId=?";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, bId);
					pstmt.executeUpdate();
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();	
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
			}//plusStep
			*/
			
			//전체 카운트 얻어오기
			public int getlistCount() {
				
				int count=0;
				
				sql="select count(*) as count from mvc_review";
				
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						count=rs.getInt("count");
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				return count;
			}//전체 카운트 얻어오기
			
			
			//전체 카운트 얻어오기(오버로딩)
			public int getlistCount(String category,String searchcon) {
				
				int count=0;
				
				sql="select count(*) as count from mvc_review where "+category+" like '%"+searchcon+"%'";
				
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						count=rs.getInt("count");
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				return count;
			}//전체 카운트 얻어오기
			
}//class
