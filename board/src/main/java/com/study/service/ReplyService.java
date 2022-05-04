package com.study.service;

import com.study.dto.Criteria;
import com.study.dto.ReplyDTO;
import com.study.dto.ReplyPageDTO;

public interface ReplyService {
	public boolean insert(ReplyDTO insertDto);
	public ReplyDTO readRow(int rno);
	public boolean replyUpdate(ReplyDTO updateDto);
	public boolean replyDelete(int rno);
	public ReplyPageDTO getList(Criteria cri, int bno);
	public boolean getCountBno(int bno);
}
