package com.example.demo.domain.doard.presentation;

import com.example.demo.domain.doard.presentation.dto.request.BoardRequest;
import com.example.demo.domain.doard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> create(@RequestBody BoardRequest boardRequest){
        boardService.create(boardRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{seq}")
    public ResponseEntity<Void> edit(@RequestBody BoardRequest boardRequest,@PathVariable Long id){
        boardService.edit(boardRequest,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{seq}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boardService.delete(id);
        return new ResponseEntity<>(null);
    }

}
