package SortTesting.src;


import org.junit.jupiter.api.Test;

import  static com.google.common.truth.Truth.assertThat;

//test the string is sorted or not.
public class TestSort{
    @Test
    public  void testSort()
    {
        String[] input = {"rawr","a","zaza","newway"};
        String[] expected = {"a","newway","rawr","zaza"};
        Sort.sort(input);
        assertThat(input).isEqualTo(expected);
    }
    @Test
    //test the findSmallest:is it a smllest string in the string[]?
    public void testFindSmallest()
    {
        String[] input = {"rawr","a","zaza","newway"};
        String expected = "a";
        assertThat(Sort.findSmallest(input,0)).isEqualTo(expected);
        expected = "newway";
        assertThat(Sort.findSmallest(input,1)).isEqualTo(expected);
    }


}

