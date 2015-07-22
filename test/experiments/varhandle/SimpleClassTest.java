/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experiments.varhandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.invoke.VarHandles;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author sven
 */
public class SimpleClassTest {
    
    public SimpleClassTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testVarHandleLookupInt() throws Exception {
        SimpleClass simpleObject = new SimpleClass(1);
        VarHandle handle = MethodHandles.lookup().findFieldVarHandle(SimpleClass.class, "intField", int.class);
        System.out.println(handle);
        Assert.assertNotNull(handle);
    }
    
    @Test
    public void testVarHandleGetObjectString() throws Exception {
        SimpleClass simpleObject = new SimpleClass(1);
        Assert.assertEquals("HelloWorld", simpleObject.getString());
    }    

    @Test
    public void testVarHandleGet() throws Exception {
        SimpleClass simpleObject = new SimpleClass(1);
        Assert.assertEquals(1, simpleObject.getInt());
    }    

    @Test
    public void testVarHandleGetInt() throws Exception {
        SimpleClass simpleObject = new SimpleClass(1);
        VarHandle handle = MethodHandles.lookup().findFieldVarHandle(SimpleClass.class, "intField", int.class);
        Object varHandleResult = handle.get(simpleObject);
        Assert.assertEquals(1, varHandleResult);
    }    

    @Test
    public void testVarHandleSet() throws Exception {
        SimpleClass simpleObject = new SimpleClass(1);
        VarHandle handle = MethodHandles.lookup().findFieldVarHandle(SimpleClass.class, "intField", int.class);
        System.out.println(handle);
        Assert.assertNotNull(handle);
        handle.set(simpleObject, 2);
        Assert.assertEquals(2, simpleObject.intField);
    }    
    
//    @Test
//    public void testVarHandleLookupInteger() throws Exception {
//        SimpleClass simpleClass = new SimpleClass(1);
//        VarHandle handle = VarHandles.lookup().findField(SimpleClass.class, "integerField", java.lang.Integer.class);
//        Assert.assertNotNull(handle);
//        Object andAdd = handle.getAndAdd(simpleClass, 1);
//        System.err.println(andAdd);
//        Assert.assertEquals(Integer.valueOf(2), simpleClass.integerField);
//    }
    
}
