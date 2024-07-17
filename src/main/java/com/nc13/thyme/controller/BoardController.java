package com.nc13.thyme.controller;

import com.nc13.thyme.Service.BoardService;
import com.nc13.thyme.model.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/")
public class BoardController {
    private final BoardService BOARD_SERVICE;

    @GetMapping("showAll")
    public String showAll(Model model) {
        List<BoardDTO> list = BOARD_SERVICE.selectAll();
        model.addAttribute("list",list);

        return "board/showAll";
    }

    @GetMapping("showOne/{id}")
    public String showOne(@PathVariable int id, Model model) {
        BoardDTO selected=BOARD_SERVICE.selectOne(id);
        model.addAttribute("boardDTO",selected);
        model.addAttribute("logIn",1);
        return "board/showOne";
    }

    @GetMapping("write")
    public String showWirte(Model model) {
        model.addAttribute("boardDTO",new BoardDTO());
        return "board/write";
    }

    @PostMapping("write")
    public String write(BoardDTO boardDTO) {
        System.out.println(boardDTO);
        return "redirect:/board/showAll";
    }

}
