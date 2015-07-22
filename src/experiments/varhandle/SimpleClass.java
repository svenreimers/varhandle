/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experiments.varhandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sven
 */
public class SimpleClass {

    public int intField;
    public Integer integerField;
    public String o;

    public SimpleClass(int initialValue) {
        intField = initialValue;
        integerField = initialValue;
        o = "HelloWorld";
    }

    public int getInt() throws Exception {
        VarHandle handle = MethodHandles.lookup().findFieldVarHandle(SimpleClass.class, "intField", int.class);
        return (int) handle.get(this);
    }

    public String getString() throws Exception {
        VarHandle handle = MethodHandles.lookup().findFieldVarHandle(SimpleClass.class, "o", String.class);
        return (String) handle.get(this);
    }


}
