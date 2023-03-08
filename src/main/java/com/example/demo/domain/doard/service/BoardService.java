package com.example.demo.domain.doard.service;

import com.example.demo.domain.doard.presentation.dto.request.BoardRequest;

public interface BoardService {

    public void create(BoardRequest boardRequest);
    public void edit(BoardRequest boardRequest,Long id);
    public void delete(Long id);
}
