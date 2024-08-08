package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.NoticeBoardDao;
import com.youtube.jwt.entity.Designations;
import com.youtube.jwt.entity.NoticeBoard;
import com.youtube.jwt.exception.EntityNotFoundException;

@Service
public class NoticeBoardService {
@Autowired
private NoticeBoardDao noticeBoardDao;

public NoticeBoard postNotice(NoticeBoard noticeBoard) {
    return noticeBoardDao.save(noticeBoard);
}
public List<NoticeBoard> getAllNotice() {
    return noticeBoardDao.findAll(); 
}
public Optional<NoticeBoard> findNoticeById(Long id) {
    return noticeBoardDao.findById(id);
}
public void deleteById(Long id) {
    if (!noticeBoardDao.existsById(id)) {
        throw new EntityNotFoundException("Notice not found with id " + id);
    }
    noticeBoardDao.deleteById(id);
}

// Method to update a notice by its ID
public NoticeBoard updateNotice(Long id, NoticeBoard updatedNoticeBoard) {
    Optional<NoticeBoard> existingNotice = noticeBoardDao.findById(id);
    if (existingNotice.isPresent()) {
        NoticeBoard noticeBoard = existingNotice.get();
        noticeBoard.setNoticeHeading(updatedNoticeBoard.getNoticeHeading());
        noticeBoard.setDepartment(updatedNoticeBoard.getDepartment());
        noticeBoard.setType(updatedNoticeBoard.getType());
        noticeBoard.setNoticeDetails(updatedNoticeBoard.getNoticeDetails());
        noticeBoard.setDate(updatedNoticeBoard.getDate());
        return noticeBoardDao.save(noticeBoard);
    } else {
        throw new EntityNotFoundException("Notice not found with id " + id);
    }
}
}
