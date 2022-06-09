import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void test1() {
        assertEquals(10, Solution.getResult("STWSWTPPTPTTPWPP", "Human"));
    }

    @Test
    public void test2() {
        assertEquals(15, Solution.getResult("STWSWTPPTPTTPWPP", "Swamper"));
    }

    @Test
    public void test3() {
        assertEquals(12, Solution.getResult("STWSWTPPTPTTPWPP", "Woodman"));
    }

    @Test
    public void test4() {
        assertEquals(30, Solution.getResult("SSSSSSSSSSSSSSSS", "Human"));
    }

    @Test
    public void test5() {
        assertEquals(6, Solution.getResult("PPPPPSSPPSSPPPPP", "Human"));
    }

    @Test
    public void test6() {
        assertEquals(-1, Solution.getResult("", "Human"));
    }

    @Test
    public void test7() {

        assertEquals(-1, Solution.getResult("STWSWTPPTPTTPWPP", ""));
    }

    @Test
    public void test8() {

        assertEquals(-1, Solution.getResult("STWSWTPPTPTTPWPP", "Yeti"));
    }

    @Test
    public void test9() {

        assertEquals(-1, Solution.getResult(null, "Swamper"));
    }

    @Test
    public void test10() {
        assertEquals(-1, Solution.getResult("STWSWTPPTPTTPWPP", null));
    }

    @Test
    public void test11() {
        assertEquals(-1, Solution.getResult(null, null));
    }

    @Test
    public void test12() {
        assertEquals(0, Solution.getResult("qeertyuiop[]aedr", "Human"));
    }

    @Test
    public void test13() {
        assertEquals(-1, Solution.getResult("]]]]]]]]]]]]]]]]]", "Woodman"));
    }

}
