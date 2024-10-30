package com.ohgiraffers.studyborad;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    public List<Board> BoardList() {
        return boardRepository.selectAll();
    }

    public Optional<Board> BoardOne(String uid) {
        return boardRepository.selelctOne(uid);
    }

    public void ViewcntUpdate(String uid) {
        boardRepository.updateViewCnt(uid);
    }
}
