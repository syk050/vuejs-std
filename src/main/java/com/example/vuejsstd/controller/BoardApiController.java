package com.example.vuejsstd.controller;

import com.example.vuejsstd.Service.BoardService;
import com.example.vuejsstd.controller.rest.ApiResult;
import com.example.vuejsstd.domain.Board;
import com.example.vuejsstd.dto.BoardDTO;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
public class BoardApiController {

    BoardService boardService;

    @GetMapping("/api/boards")
    public ApiResult<List<Board>> getAll() {
        List<Board> list = boardService.list();

        return ApiResult.<List<Board>>builder()
                .data(list)
                .build();
    }

    @GetMapping("/api/boards/{id}")
    public ResponseEntity<?> getBoardById(@PathVariable("id") Long id) {
        ResponseEntity<?> entity = null;

        try {
            entity = new ResponseEntity<BoardDTO>(boardService.view(id), HttpStatus.OK);
        } catch (Exception e) {
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return entity;
    }

    @PostMapping("/api/boards/post")
    public ResponseEntity<?> create(@RequestBody final BoardDTO boarddto) {

        try {
            return new ResponseEntity<BoardDTO>(boardService.post(boarddto), HttpStatus.CREATED);
        } catch (final Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/api/boards/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody BoardDTO boarddto) {
        try {
            return new ResponseEntity<BoardDTO>(boardService.update(boarddto, id), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/api/boards/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        ResponseEntity<?> entity = null;

        try {
            boardService.delete(id);
            entity = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return entity;
    }


}
