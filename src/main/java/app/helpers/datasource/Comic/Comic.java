package app.helpers.datasource.Comic;

import app.user.User;

import javax.persistence.*;

@Entity
@Table(name = "comic")
public class Comic {
    @Id
    @Column(name = "comicid", nullable = false)
    private String comicid;

    @ManyToOne
    @JoinColumn(name = "user_userid")
    private User user;


    @Column(name = "comicurl", nullable = false)
    private String comicurl;

    public String getComicid() {
        return comicid;
    }

    public void setComicid(String comicid) {
        this.comicid = comicid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComicurl() {
        return comicurl;
    }

    public void setComicurl(String comicurl) {
        this.comicurl = comicurl;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "comicid='" + comicid + '\'' +
                ", user=" + user +
                ", comicurl='" + comicurl + '\'' +
                '}';
    }


}