package org.zerock.ex00.mappers;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.ex00.domain.BoardVO;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {

    @Autowired(required = false)
    BoardMapper boardMapper;

    @Test
    public void test1(){
        log.info(boardMapper);
    }

    @Test
    public void testList(){
        boardMapper.getList().forEach(boardVO -> log.info(boardVO));
    }

    @Test
    public void testInsert(){

        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("NewTitle");
        boardVO.setContent("New Test...");
        boardVO.setWriter("newbie");

        log.info("COUNT :" + boardMapper.insert(boardVO));

        log.info("BNO : " + boardVO.getBno());

    }
    @Test
    public void testSelect(){
        Long bno = 7L;

        log.info(boardMapper.select(bno));
    }

    @Test
    public void testUpdate(){
        Long bno = 7L;

        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("Update Title");
        boardVO.setContent("Update Content");
        boardVO.setBno(bno);

        int updateCount = boardMapper.update(boardVO);

        log.info("update : " + updateCount);
    }

    @Test
    public void testDelete(){
        Long bno = 1L;

        int deleteCount = boardMapper.delete(bno);

        log.info("delete : " + deleteCount);
    }

}
