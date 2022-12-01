package com.vue.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.dto.MemberDTO;
import com.vue.dto.MockMemberDTO;
import com.vue.dto.ProductDTO;
import com.vue.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	@Autowired
	private MemberMapper memberMapper;
	public int addMockProduct(List<ProductDTO> productMock) {
		int addCount = 0;

		try {
			for (ProductDTO productMockDTO : productMock) {
				addCount +=	memberMapper.addMockProduct(productMockDTO);
			}
		}catch (NullPointerException e) {
			log.info("Product의 Mock 데이터가 null입니다.");
			return -1;
		}
		
		log.info(addCount + "");
		return addCount;

	}
	public int addMockMember(List<MockMemberDTO> memberMock) {
		int addCount = 0;

		try {
			for (MockMemberDTO mockMemberDTO : memberMock) {
				log.info(mockMemberDTO.getUserId());
				addCount +=	memberMapper.addMockMember(mockMemberDTO);
			}
		}catch (NullPointerException e) {
			log.info("User의 Mock 데이터가 null입니다.");
			return -1;
		}
		
		log.info(addCount + "");
		return addCount;
	}
	@Override
	public boolean joinCheck(MemberDTO member) throws NullPointerException {
		MemberDTO getMember = memberMapper.getMember(member);
		int resultData = 0;
		
		if (getMember == null) {
			resultData= memberMapper.addMember(member);
		}
		
		return resultData == 1;
	}

	@Override
	public String loginCheck(MemberDTO member) {
		MemberDTO getMember = memberMapper.getMember(member);
		log.info(getMember+ "");
		String resultData = "";
		if (getMember == null) {
			resultData = "errorId";
		}

		if (resultData == "" && !getMember.getMemberPass().equals(member.getMemberPass())) {
			resultData = "errorPass";
		}
		return resultData;
	}
}