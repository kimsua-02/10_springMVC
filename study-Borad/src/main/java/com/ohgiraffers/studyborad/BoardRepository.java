package com.ohgiraffers.studyborad;

import java.util.List;
import java.util.Optional;

public class BoardRepository {

    public List<Board> selectAll();

    public Optional<Board> selectOne(String uid);

    public void updateViewCnt(String uid);
}
