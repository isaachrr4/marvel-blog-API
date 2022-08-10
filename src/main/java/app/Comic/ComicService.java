package app.Comic;

import app.Comic.dtos.ComicResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ComicService {

    private final ComicRepository comicrepo;

    @Autowired
    public ComicService(ComicRepository comicrepo) {
        this.comicrepo = comicrepo;
    }


    public List<ComicResponse> fetchAllComics() {
        return comicrepo.findAll()
                .stream()
                .map(ComicResponse::new)
                .collect(Collectors.toList());
    }
}
