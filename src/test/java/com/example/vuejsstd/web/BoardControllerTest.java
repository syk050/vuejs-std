package com.example.vuejsstd.web;

import com.example.vuejsstd.entity.Board;
import com.example.vuejsstd.entity.BoardRepository;
import com.example.vuejsstd.web.dto.BoardDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 작성해야 TestRestTemplate 에러 안남
class BoardControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void Board_Up() throws Exception {
        String title = "Test Title";
        String contents = "Test contents";
        String author = "Test author";

        BoardDto boardDto = BoardDto.builder()
                .title(title)
                .contents(contents)
                .author(author)
                .build();

        String url = "http://localhost:" + port + "/board";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, boardDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Board> all = boardRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContents()).isEqualTo(contents);
    }
}