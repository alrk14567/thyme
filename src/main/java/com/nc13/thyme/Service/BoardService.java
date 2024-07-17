package com.nc13.thyme.Service;

import com.nc13.thyme.model.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final SqlSession SESSION;
    private final String NAMESPACE="mappers.BoardMapper";

    public List<BoardDTO> selectAll() {
        return SESSION.selectList(NAMESPACE+".selectAll");
    }

    public BoardDTO selectOne(int id) {
        return SESSION.selectOne(NAMESPACE+".selectOne",id);
    }

}
