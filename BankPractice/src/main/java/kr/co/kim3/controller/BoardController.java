package kr.co.kim3.controller;

import kr.co.kim3.board.vo.BoardVO;
import kr.co.kim3.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/create")
    public String createBoard(@ModelAttribute BoardVO board, Model model) {
        boardService.createBoard(board);
        model.addAttribute("message", "Board created successfully.");
        return "redirect:/boards/" + board.getbType();
    }

    @GetMapping("/{bType}")
    public String getBoardByType(@PathVariable String bType, Model model) {
        List<BoardVO> boards = boardService.getBoardByType(bType);
        model.addAttribute("boards", boards);
        return "boardList";
    }

    @PostMapping("/delete/{bNumber}")
    public String deleteBoard(@PathVariable int bNumber, Model model) {
        boardService.deleteBoard(bNumber);
        model.addAttribute("message", "Board deleted successfully.");
        return "redirect:/boards";
    }
}
