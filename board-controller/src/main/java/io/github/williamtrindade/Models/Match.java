package io.github.williamtrindade.Models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class Match {
    public static String readNotation() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return in.readLine();
    }

    public Move getMoveFromString(String move) {
        String[] input = move.split(" ");
        String white = input[0];
        String black = input[1];
        int matchId = parseInt(input[2]);
        return new Move(white, black, matchId);
    }
}
