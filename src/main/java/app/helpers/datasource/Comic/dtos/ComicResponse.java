package app.helpers.datasource.Comic.dtos;

import app.helpers.datasource.Comic.Comic;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComicResponse {

    private String comicid;

    private String comicurl;

    public ComicResponse(Comic comic) {
        this.comicid = comic.getComicid();
        this.comicurl = comic.getComicurl();
    }
}
