package mj.Store.service;



public interface memberService {
	
	public int insert(memberDataBean member);
	public memberDataBean getMember(String st_id);
	public memberDataBean getMember2(String st_id);
	public int updateMember(memberDataBean member, String st_id);


}
