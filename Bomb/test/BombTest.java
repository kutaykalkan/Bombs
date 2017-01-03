import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kutay on 12/5/2016.
 */
public class BombTest {
    @Test
    public void test(){
        String string = "";
        Bomb b = new Bomb(string, 2);
        String[] actual = b.explode();
        String[] expected = {""};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void test1(){
        String string = "..B....";
        Bomb b = new Bomb(string, 2);
        String[] actual = b.explode();
        String[] expected = {"..B....", "<...>..", "......>", "......."};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2(){
        String string = "..B.B..B";
        Bomb b = new Bomb(string, 10);
        String[] actual = b.explode();
        String[] expected = {"..B.B..B", "........"};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test3(){
        String string = "B.B.B.BB.";
        Bomb b = new Bomb(string, 2);
        String[] actual = b.explode();
        String[] expected = {
                "B.B.B.BB.",
                "<.X.X<>.>",
                "<.<<>.>.>",
                "<<....>.>",
                "........>",
                "........."};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test4(){
        String string = "..B.B..B";
        Bomb b = new Bomb(string, 1);
        String[] actual = b.explode();
        String[] expected = {
                "..B.B..B",
                ".<.X.><.",
                "<.<.><>.",
                ".<..<>.>",
                "<..<..>.",
                "..<....>",
                ".<......",
                "<.......",
                "........"};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test5(){
        String string = "..B.BB..B.B..B...";
        Bomb b = new Bomb(string, 1);
        String[] actual = b.explode();
        String[] expected = {
                "..B.BB..B.B..B...",
                ".<.X<>><.X.><.>..",
                "<.<<>.X><.><>..>.",
                ".<<..X.X>.<>.>..>",
                "<<..<.X.>X..>.>..",
                "<..<.<.><>>..>.>.",
                "..<.<..<>.>>..>.>",
                ".<.<..<..>.>>..>.",
                "<.<..<....>.>>..>",
                ".<..<......>.>>..",
                "<..<........>.>>.",
                "..<..........>.>>",
                ".<............>.>",
                "<..............>.",
                "................>",
                "................."};
        assertArrayEquals(expected, actual);
    }
}