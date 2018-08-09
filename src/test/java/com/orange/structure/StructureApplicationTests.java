package com.orange.structure;

import com.orange.structure.binary_sort.BinarySort;
import com.orange.structure.binary_tree.IterateTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StructureApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
    public void testIterator() {
//        TreeSet<String> set  = new TreeSet<>();
//        String[] strArray = new String[]{"dd", "fds", "ee", "rr", "ll", "mm", "bb", "cc"};
//        List list = Arrays.asList(strArray);
//        set.addAll(list);
//        TreeMap<String, String> map = new TreeMap<>();
//        for(Map.Entry entry : map.entrySet()){
//
//        }
        new IterateTree().iteratorBehind2(new IterateTree().root);
        new IterateTree().iteratorBehind(new IterateTree().root);
    }

    @Test
    public void TestBinarySort(){
	    new BinarySort().iterator();
    }
}
