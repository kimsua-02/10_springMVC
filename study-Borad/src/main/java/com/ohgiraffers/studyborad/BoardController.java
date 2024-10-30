package com.ohgiraffers.studyborad;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Configuration
@RequestMapping("/boards")
public class BoardController {

    private BoardService boardService;

    @GetMapping
    public String boards(Model model) {
        List<Board> boards = boardService.BoardList();
        model.addAttribute("boards",boards);
        return "boards/boards";
    }

    @GetMapping("{uid}")
    public String board(@PathVariable("uid") String uid, Model model) {
        boardService.ViewcntUpdate(uid);
        Board board = result.get();
        model.addAttribute("board",board);
        log.info("board={}", board);
        return "boards/board";
    }
}
