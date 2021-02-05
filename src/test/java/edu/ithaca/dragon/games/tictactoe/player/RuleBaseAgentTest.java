package edu.ithaca.dragon.games.tictactoe.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import edu.ithaca.dragon.games.tictactoe.board.TwoDArrayBoard;

public class RuleBaseAgentTest {

    @Test
    public void isBoardEmptyTest(){
        RuleBaseAgent p = new RuleBaseAgent();
        assertTrue(p.boardEmpty(new TwoDArrayBoard("         ")));
        assertFalse(p.boardEmpty(new TwoDArrayBoard("X        ")));
        assertFalse(p.boardEmpty(new TwoDArrayBoard("O        ")));
        assertFalse(p.boardEmpty(new TwoDArrayBoard("        X")));
        assertFalse(p.boardEmpty(new TwoDArrayBoard("XXXXXXXXX")));
    }

    @Test
    public void blockLocationTest(){
        RuleBaseAgent p = new RuleBaseAgent();
        assertEquals(new Pair<>(2,0), p.blockLocation("XX       ".split("")));
        assertEquals(new Pair<>(0,0), p.blockLocation(" XX      ".split("")));
        assertEquals(new Pair<>(1,0), p.blockLocation("X X      ".split("")));
        assertEquals(new Pair<>(2,0), p.blockLocation("OO       ".split("")));
        assertEquals(new Pair<>(0,2), p.blockLocation("X  X     ".split("")));
        assertEquals(new Pair<>(2,2), p.blockLocation("X   X    ".split("")));
        assertEquals(new Pair<>(1,1), p.blockLocation(" X     X ".split("")));
        assertEquals(null, p.blockLocation("X       X".split("")));
    }
}
