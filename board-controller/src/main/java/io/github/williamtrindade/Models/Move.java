package io.github.williamtrindade.Models;

import java.io.Serializable;

public class Move implements Serializable {
    private String white;
    private String black;
    private Integer chessMatchId;

    public Move(String white, String black, Integer chessMatchId) {
        this.white = white;
        this.black = black;
        this.chessMatchId = chessMatchId;
    }

    public String getBlack() {
        return black;
    }

    public void setBlack(String black) {
        this.black = black;
    }

    public String getWhite() {
        return white;
    }

    public void setWhite(String white) {
        this.white = white;
    }

    public Integer getChessMatchId() {
        return chessMatchId;
    }

    public void setChessMatchId(Integer chessMatchId) {
        this.chessMatchId = chessMatchId;
    }
}
