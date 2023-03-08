package com.example.demo.domain.doard.service.impl;

import com.example.demo.domain.doard.Board;
import com.example.demo.domain.doard.presentation.dto.request.BoardRequest;
import com.example.demo.domain.doard.repository.BoardRepository;
import com.example.demo.domain.doard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public void create(BoardRequest boardRequest){
        Board board = Board.builder()
                .name(boardRequest.getName())
                .title(boardRequest.getTitle())
                .content(boardRequest.getContent())
                .build();
        boardRepository.save(board);
    }

    @Override
    public void edit(BoardRequest boardRequest,Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(()->new RuntimeException());
        board.update(boardRequest.getName(), boardRequest.getTitle(), boardRequest.getContent());
        boardRepository.save(board);
    }

    @Override
    public void delete(Long id){
       boardRepository.deleteById(id);
    }
}
